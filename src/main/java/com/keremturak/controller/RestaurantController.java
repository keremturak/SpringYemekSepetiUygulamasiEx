package com.keremturak.controller;

import com.keremturak.dto.request.RestaurantSaveRequestDto;
import com.keremturak.repository.entity.Order;
import com.keremturak.repository.entity.Product;
import com.keremturak.repository.entity.Restaurant;
import com.keremturak.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.keremturak.constants.RestApiList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RESTAURANT)
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping(SAVE)
    public ResponseEntity<Restaurant> save(@RequestBody @Valid RestaurantSaveRequestDto dto) {
        return ResponseEntity.ok(restaurantService.save(dto));
    }

    @GetMapping(FINDALLORDERS)
    public ResponseEntity<List<Order>> findAllOrders(Long id) {
        return ResponseEntity.ok(restaurantService.findAllOrders(id));
    }

    @GetMapping(FINDALLPRODUCT)
    public ResponseEntity<List<Product>> findAllProduct(Long restaurantId) {
        return ResponseEntity.ok(restaurantService.findAllProduct(restaurantId));
    }
}
