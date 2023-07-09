package com.keremturak.mapper;

import com.keremturak.dto.request.RestaurantSaveRequestDto;
import com.keremturak.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {
    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);

    Restaurant restaurantSaveDto(RestaurantSaveRequestDto dto);
}
