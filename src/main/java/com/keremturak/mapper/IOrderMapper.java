package com.keremturak.mapper;

import com.keremturak.dto.request.CustomerRegisterRequestDto;

import com.keremturak.dto.request.OrderCreateOrderRequestDto;
import com.keremturak.repository.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderMapper {
    IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);

    Order orderCreateOrderDto(OrderCreateOrderRequestDto orderCreateOrderRequestDto);
}
