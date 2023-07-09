package com.keremturak.service;

import com.keremturak.dto.request.CustomerRegisterRequestDto;
import com.keremturak.dto.request.OrderCreateOrderRequestDto;
import com.keremturak.exceptions.ErrorType;
import com.keremturak.exceptions.YemekSepetiException;
import com.keremturak.mapper.ICustomerMapper;
import com.keremturak.repository.ICustomerRepository;
import com.keremturak.repository.entity.Customer;
import com.keremturak.repository.entity.Order;
import com.keremturak.repository.entity.Restaurant;
import com.keremturak.utility.CodeGenerator;
import com.keremturak.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {
    private final MailService mailService;
    private final OrderService orderService;
    private final ICustomerRepository customerRepository;
    private final RestaurantService restaurantService;

    public CustomerService(ICustomerRepository customerRepository, MailService mailService, OrderService orderService,RestaurantService restaurantService) {
        super(customerRepository);
        this.customerRepository = customerRepository;
        this.mailService = mailService;
        this.orderService = orderService;
        this.restaurantService = restaurantService;
    }

    public Customer register(CustomerRegisterRequestDto dto) {
        if (!customerRepository.findByEmail(dto.getEmail()).isEmpty()) {
            throw new YemekSepetiException(ErrorType.REGISTER_KULLANICIADI_KAYITLI);
        }
        Customer customer = ICustomerMapper.INSTANCE.customerRegisterFromDto(dto);
        String verificationCode = CodeGenerator.generatecode();
        mailService.sendMail(dto.getEmail(), verificationCode);
        customer.setVerificationCode(verificationCode);
        return customerRepository.save(customer);
    }

    public Customer authentication(String email, String authCode) {
        if (customerRepository.findByEmail(email).isEmpty()) {
            throw new YemekSepetiException(ErrorType.REGISTER_KULLANICIADI_KAYITLI);
        }
        Customer customer = customerRepository.findByEmail(email).get();
        if (customer.getStatus() == 0) {
            if (customer.getVerificationCode().equals(authCode)) {
                customer.setStatus(1);
                return customerRepository.save(customer);
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

        if (customer != null && customer.getStatus() == 1) {
            if (restaurantService.findById(dto.getRestaurantid()).isPresent()){
                return orderService.createOrder(dto);
            }throw  new YemekSepetiException(ErrorType.BOYLE_BIR_RESTAURANT_YOK);
        }throw new YemekSepetiException(ErrorType.AKTIVASYONU_YAPILAN_KAYIT_YOK);


    }
}
