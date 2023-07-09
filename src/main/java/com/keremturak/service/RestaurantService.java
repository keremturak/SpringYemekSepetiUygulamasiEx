package com.keremturak.service;

import com.keremturak.dto.request.RestaurantSaveRequestDto;
import com.keremturak.mapper.IRestaurantMapper;
import com.keremturak.repository.IRestaurantRepository;
import com.keremturak.repository.entity.Order;
import com.keremturak.repository.entity.Product;
import com.keremturak.repository.entity.Restaurant;
import com.keremturak.utility.ServiceManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService extends ServiceManager<Restaurant, Long> {
    private final IRestaurantRepository restaurantRepository;
    private final OrderService orderService;
    private final ProductService productService;



    public RestaurantService(IRestaurantRepository restaurantRepository, OrderService orderService, ProductService productService) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
        this.orderService = orderService;
        this.productService = productService;
    }

    public Restaurant save(RestaurantSaveRequestDto dto){
    Restaurant restaurant = IRestaurantMapper.INSTANCE.restaurantSaveDto(dto);
    return restaurantRepository.save(restaurant);
    }

    public List<Order> findAllOrders(Long id) {
        return orderService.findAllByRestaurantId(id);
    }

    public List<Product> findAllProduct(Long restaurantId) {
        return productService.findAllByRestaurantId(restaurantId);
    }
}
