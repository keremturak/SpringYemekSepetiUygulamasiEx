package com.keremturak.controller;

import com.keremturak.dto.request.OrderCreateOrderRequestDto;
import com.keremturak.repository.entity.Order;
import com.keremturak.service.OrderService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static com.keremturak.constants.RestApiList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ORDER)
public class OrderController {
    private final OrderService orderService;


    @GetMapping(FINDALL)
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

}
