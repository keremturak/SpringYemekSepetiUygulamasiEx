package com.keremturak.mapper;

import com.keremturak.dto.request.ProductSaveRequestDto;
import com.keremturak.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);
    Product productSaveDto(ProductSaveRequestDto productSaveRequestDto);
}
