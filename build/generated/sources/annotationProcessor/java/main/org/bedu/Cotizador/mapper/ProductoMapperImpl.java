package org.bedu.Cotizador.mapper;

import javax.annotation.processing.Generated;
import org.bedu.Cotizador.dto.ProductoDTO;
import org.bedu.Cotizador.dto.createDTO.CreateProductoDTO;
import org.bedu.Cotizador.dto.updateDTO.UpdateProductoDTO;
import org.bedu.Cotizador.model.Producto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T08:44:06-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDTO toDTO(Producto entity) {
        if ( entity == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId( (int) entity.getId() );
        productoDTO.setNombre( entity.getNombre() );
        productoDTO.setImagen( entity.getImagen() );
        productoDTO.setSku( entity.getSku() );
        productoDTO.setPrecio( entity.getPrecio() );
        productoDTO.setStock( entity.getStock() );
        productoDTO.setDescripcion( entity.getDescripcion() );
        productoDTO.setCategoria( entity.getCategoria() );
        productoDTO.setMarca( entity.getMarca() );
        productoDTO.setModelo( entity.getModelo() );

        return productoDTO;
    }

    @Override
    public Producto toModel(CreateProductoDTO data) {
        if ( data == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setNombre( data.getNombre() );
        producto.setImagen( data.getImagen() );
        producto.setSku( data.getSku() );
        producto.setPrecio( data.getPrecio() );
        producto.setStock( data.getStock() );
        producto.setDescripcion( data.getDescripcion() );
        producto.setCategoria( data.getCategoria() );
        producto.setMarca( data.getMarca() );
        producto.setModelo( data.getModelo() );

        return producto;
    }

    @Override
    public Producto updateModel(UpdateProductoDTO updDTO, Producto entity) {
        if ( updDTO == null ) {
            return entity;
        }

        entity.setNombre( updDTO.getNombre() );
        entity.setSku( updDTO.getSku() );
        entity.setPrecio( updDTO.getPrecio() );
        entity.setStock( updDTO.getStock() );
        entity.setDescripcion( updDTO.getDescripcion() );
        entity.setCategoria( updDTO.getCategoria() );
        entity.setMarca( updDTO.getMarca() );
        entity.setModelo( updDTO.getModelo() );

        return entity;
    }
}
