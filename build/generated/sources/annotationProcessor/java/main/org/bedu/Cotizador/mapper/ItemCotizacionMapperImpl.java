package org.bedu.Cotizador.mapper;

import javax.annotation.processing.Generated;
import org.bedu.Cotizador.dto.ItemCotizacionDTO;
import org.bedu.Cotizador.dto.ProductoDTO;
import org.bedu.Cotizador.model.ItemCotizacion;
import org.bedu.Cotizador.model.Producto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T20:37:17-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ItemCotizacionMapperImpl implements ItemCotizacionMapper {

    @Override
    public ItemCotizacionDTO toDTO(ItemCotizacion entity) {
        if ( entity == null ) {
            return null;
        }

        ItemCotizacionDTO itemCotizacionDTO = new ItemCotizacionDTO();

        itemCotizacionDTO.setId( entity.getId() );
        itemCotizacionDTO.setProducto( productoToProductoDTO( entity.getProducto() ) );
        itemCotizacionDTO.setCantidad( entity.getCantidad() );
        itemCotizacionDTO.setPrecioUnitario( entity.getPrecioUnitario() );
        itemCotizacionDTO.setSubtotal( entity.getSubtotal() );

        return itemCotizacionDTO;
    }

    protected ProductoDTO productoToProductoDTO(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId( (int) producto.getId() );
        productoDTO.setNombre( producto.getNombre() );
        productoDTO.setImagen( producto.getImagen() );
        productoDTO.setSku( producto.getSku() );
        productoDTO.setPrecio( producto.getPrecio() );
        productoDTO.setStock( producto.getStock() );
        productoDTO.setDescripcion( producto.getDescripcion() );
        productoDTO.setCategoria( producto.getCategoria() );
        productoDTO.setMarca( producto.getMarca() );
        productoDTO.setModelo( producto.getModelo() );

        return productoDTO;
    }
}
