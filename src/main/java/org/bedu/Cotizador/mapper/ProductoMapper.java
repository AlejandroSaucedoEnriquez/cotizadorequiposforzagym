package org.bedu.Cotizador.mapper;

import org.bedu.Cotizador.dto.ProductoDTO;
import org.bedu.Cotizador.dto.createDTO.CreateProductoDTO;
import org.bedu.Cotizador.dto.updateDTO.UpdateProductoDTO;
import org.bedu.Cotizador.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDTO toDTO(Producto entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "itemCotizacion", ignore = true)
    Producto toModel(CreateProductoDTO data);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "itemCotizacion", ignore = true)
    Producto updateModel(UpdateProductoDTO updDTO, @MappingTarget Producto entity);
}