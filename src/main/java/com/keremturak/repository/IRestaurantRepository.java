package com.keremturak.repository;

import com.keremturak.repository.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRestaurantRepository extends JpaRepository<Restaurant, Long> {

}
