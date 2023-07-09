package com.keremturak.controller;

import com.keremturak.dto.request.CustomerRegisterRequestDto;
import com.keremturak.dto.request.OrderCreateOrderRequestDto;
import com.keremturak.dto.response.CustomerRegisterResponseDto;
import com.keremturak.repository.entity.Customer;
import com.keremturak.repository.entity.Order;
import com.keremturak.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.keremturak.constants.RestApiList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping(SAVE)
    public ResponseEntity<CustomerRegisterResponseDto> register(@RequestBody @Valid CustomerRegisterRequestDto dto){
        CustomerRegisterResponseDto  responseDto = customerService.register(dto);
        return ResponseEntity.ok(responseDto);
    }
    @PostMapping(AUTHENTICATION)
    public CustomerRegisterResponseDto authentication(String email, String authCode){
        return customerService.authentication(email,authCode);
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<CustomerRegisterResponseDto>> findAll(){
        return ResponseEntity.ok(customerService.findAllDto());
    }

    @GetMapping(FINDALLORDERS)
    public ResponseEntity<List<Order>> findAllOrders(Long id){
        return ResponseEntity.ok(customerService.findAllOrders(id));
    }
    @GetMapping(ORDER)
    public ResponseEntity<Order> order(@Valid OrderCreateOrderRequestDto dto){
        return ResponseEntity.ok(customerService.order(dto));
    }
    @PostMapping(ADDBALANCE)
    public ResponseEntity<CustomerRegisterResponseDto> addBalance(Long id, Long amount){
        return ResponseEntity.ok(customerService.addBalance(id,amount));
    }   @PostMapping(ADDCARDDETAILS)
    public ResponseEntity<CustomerRegisterResponseDto> addCardDetails(Long id, String cardNumber, Long amount){
        return ResponseEntity.ok(customerService.addCardDetails(id,cardNumber,amount));
    }

}
