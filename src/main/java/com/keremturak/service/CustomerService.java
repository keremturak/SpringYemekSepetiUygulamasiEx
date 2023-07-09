package com.keremturak.service;

import com.keremturak.dto.request.CustomerRegisterRequestDto;
import com.keremturak.dto.request.OrderCreateOrderRequestDto;
import com.keremturak.dto.response.CustomerRegisterResponseDto;
import com.keremturak.exceptions.ErrorType;
import com.keremturak.exceptions.YemekSepetiException;
import com.keremturak.mapper.ICustomerMapper;
import com.keremturak.repository.ICustomerRepository;
import com.keremturak.repository.entity.Customer;
import com.keremturak.repository.entity.Order;
import com.keremturak.repository.entity.Product;
import com.keremturak.repository.entity.Restaurant;
import com.keremturak.utility.CodeGenerator;
import com.keremturak.utility.ServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {
    private final MailService mailService;
    private final OrderService orderService;
    private final ICustomerRepository customerRepository;
    private final ProductService productService;

    public CustomerService(ICustomerRepository customerRepository, MailService mailService, OrderService orderService,ProductService productService) {
        super(customerRepository);
        this.customerRepository = customerRepository;
        this.mailService = mailService;
        this.orderService = orderService;
        this.productService = productService;
    }

    public CustomerRegisterResponseDto register(CustomerRegisterRequestDto dto) {
        if (!customerRepository.findByEmail(dto.getEmail()).isEmpty()) {
            throw new YemekSepetiException(ErrorType.REGISTER_KULLANICIADI_KAYITLI);
        }
        Customer customer = ICustomerMapper.INSTANCE.customerRegisterFromDto(dto);
        customer.setBalance(0L);
        String verificationCode = CodeGenerator.generatecode();
        mailService.sendMail(dto.getEmail(), verificationCode);
        customer.setVerificationCode(verificationCode);

        return ICustomerMapper.INSTANCE.customerRegisterResponseDtofromCustomer(customerRepository.save(customer));
    }
    public List<CustomerRegisterResponseDto> findAllDto(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerRegisterResponseDto> responsecustomers =new ArrayList<>();
        customers.forEach(customer->responsecustomers.add(ICustomerMapper.INSTANCE.customerRegisterResponseDtofromCustomer(customer)));
        return responsecustomers;
    }

    public CustomerRegisterResponseDto authentication(String email, String authCode) {
        if (customerRepository.findByEmail(email).isEmpty()) {
            throw new YemekSepetiException(ErrorType.REGISTER_KULLANICIADI_KAYITLI);
        }
        Customer customer = customerRepository.findByEmail(email).get();
        if (customer.getStatus() == 0) {
            if (customer.getVerificationCode().equals(authCode)) {
                customer.setStatus(1);
                Customer customer2 = customerRepository.save(customer);
                return ICustomerMapper.INSTANCE.customerRegisterResponseDtofromCustomer(customer2);
            }
            throw new YemekSepetiException(ErrorType.DOGRULAMA_KODU_ESLESMIYOR);
        }
        throw new YemekSepetiException(ErrorType.AKTIVASYONUNUZ_YAPILMISTIR);


    }

    public List<Order> findAllOrders(Long id) {
        return orderService.findAllByCustomerId(id);
    }

    public Order order(OrderCreateOrderRequestDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerid()).get();
        Product product = productService.findById(dto.getProductid()).get();

        if (customer != null && customer.getStatus() == 1) {
            if (customer.getBalance()>product.getCost()){
                customer.setBalance(customer.getBalance()-product.getCost());
                save(customer);
                return orderService.createOrder(dto,product);
            }throw  new YemekSepetiException(ErrorType.BAKIYE_YETERSIZ);
        }throw new YemekSepetiException(ErrorType.AKTIVASYONU_YAPILAN_KAYIT_YOK);


    }

    public CustomerRegisterResponseDto addBalance(Long id, Long amount) {
        Optional<Customer> customer= customerRepository.findById(id);
        if (customer.isPresent()){
            if (customer.get().getCardDetails()!=null){
                customer.get().setBalance(customer.get().getBalance()+amount);
                Customer customer2 =customerRepository.save(customer.get());
                System.out.println(customer2.getBalance());
                return ICustomerMapper.INSTANCE.customerRegisterResponseDtofromCustomer(customer2);
            }throw new YemekSepetiException(ErrorType.KART_BILGILERINIZI_GIRINIZ);

        }throw new YemekSepetiException(ErrorType.KULLANICI_BULUNAMADI);
    }

    public CustomerRegisterResponseDto addCardDetails(Long id, String cardNumber, Long amount) {
        Customer customer = customerRepository.findById(id).get();
        if (customer!=null){
            customer.setCardDetails(cardNumber);
            customer.setBalance(amount);
            return ICustomerMapper.INSTANCE.customerRegisterResponseDtofromCustomer(customerRepository.save(customer));
        }throw new YemekSepetiException(ErrorType.KULLANICI_BULUNAMADI);
    }
}
