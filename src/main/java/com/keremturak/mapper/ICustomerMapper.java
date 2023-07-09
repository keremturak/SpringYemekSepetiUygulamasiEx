package com.keremturak.mapper;

import com.keremturak.dto.request.CustomerRegisterRequestDto;
import com.keremturak.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);
    Customer customerRegisterFromDto(CustomerRegisterRequestDto customerRegisterRequestDto);

}
