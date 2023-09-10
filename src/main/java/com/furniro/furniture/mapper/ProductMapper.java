package com.furniro.furniture.mapper;

import com.furniro.furniture.dto.ProductDtoMapper;
import com.furniro.furniture.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDtoMapper mapToProduct(Product product);
}
