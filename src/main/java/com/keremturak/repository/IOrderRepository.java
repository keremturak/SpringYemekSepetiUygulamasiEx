package com.keremturak.repository;

import com.keremturak.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerid(Long id);

    List<Order> findAllByRestaurantid(Long id);
}
