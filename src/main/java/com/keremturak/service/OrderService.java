package com.keremturak.service;

import com.keremturak.dto.request.OrderCreateOrderRequestDto;
import com.keremturak.mapper.IOrderMapper;
import com.keremturak.repository.IOrderRepository;
import com.keremturak.repository.entity.Order;
import com.keremturak.repository.entity.Product;
import com.keremturak.utility.ServiceManager;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends ServiceManager<Order,Long> {
    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }
    public Order createOrder(OrderCreateOrderRequestDto dto, Product product){
        Order order = IOrderMapper.INSTANCE.orderCreateOrderDto(dto);
        order.setRestaurantid(product.getRestaurantid());
        return (orderRepository.save(order));
    }

    public List<Order> findAllByCustomerId(Long id) {
        return orderRepository.findAllByCustomerid(id);
    }
    public List<Order> findAllByRestaurantId(Long id) {
        return orderRepository.findAllByRestaurantid(id);
    }

}
