package com.keremturak.controller;

import com.keremturak.dto.request.CustomerRegisterRequestDto;
import com.keremturak.dto.request.OrderCreateOrderRequestDto;
import com.keremturak.repository.entity.Customer;
import com.keremturak.repository.entity.Order;
import com.keremturak.service.CustomerService;
import com.keremturak.service.MailService;
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
    public ResponseEntity<Customer> register(@RequestBody @Valid CustomerRegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }
    @PostMapping(AUTHENTICATION)
    public Customer authentication(String email, String authCode){
        return customerService.authentication(email,authCode);
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping(FINDALLORDERS)
    public ResponseEntity<List<Order>> findAllOrders(Long id){
        return ResponseEntity.ok(customerService.findAllOrders(id));
    }
    @PostMapping(ORDER)
    public ResponseEntity<Order> order(@Valid OrderCreateOrderRequestDto dto){
        return ResponseEntity.ok(customerService.order(dto));
    }

}
