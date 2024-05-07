package org.bedu.Cotizador.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.bedu.Cotizador.dto.CotizacionDTO;
import org.bedu.Cotizador.dto.ItemCotizacionDTO;
import org.bedu.Cotizador.dto.ProductoDTO;
import org.bedu.Cotizador.dto.createDTO.CreateCotizacionDTO;
import org.bedu.Cotizador.model.Cliente;
import org.bedu.Cotizador.model.Cotizacion;
import org.bedu.Cotizador.model.ItemCotizacion;
import org.bedu.Cotizador.model.Producto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T08:44:07-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CotizacionMapperImpl implements CotizacionMapper {

    @Override
    public CotizacionDTO toDTO(Cotizacion entity) {
        if ( entity == null ) {
            return null;
        }

        CotizacionDTO cotizacionDTO = new CotizacionDTO();

        cotizacionDTO.setClienteId( entityClienteId( entity ) );
        cotizacionDTO.setId( entity.getId() );
        cotizacionDTO.setItems( itemCotizacionListToItemCotizacionDTOList( entity.getItems() ) );
        cotizacionDTO.setImagen( entity.getImagen() );
        cotizacionDTO.setFecha( entity.getFecha() );
        cotizacionDTO.setTotal( entity.getTotal() );

        return cotizacionDTO;
    }

    @Override
    public Cotizacion toModel(CreateCotizacionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cotizacion cotizacion = new Cotizacion();

        cotizacion.setCliente( createCotizacionDTOToCliente( dto ) );
        cotizacion.setImagen( dto.getImagen() );

        return cotizacion;
    }

    private Long entityClienteId(Cotizacion cotizacion) {
        if ( cotizacion == null ) {
            return null;
        }
        Cliente cliente = cotizacion.getCliente();
        if ( cliente == null ) {
            return null;
        }
        long id = cliente.getId();
        return id;
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

    protected ItemCotizacionDTO itemCotizacionToItemCotizacionDTO(ItemCotizacion itemCotizacion) {
        if ( itemCotizacion == null ) {
            return null;
        }

        ItemCotizacionDTO itemCotizacionDTO = new ItemCotizacionDTO();

        itemCotizacionDTO.setId( itemCotizacion.getId() );
        itemCotizacionDTO.setProducto( productoToProductoDTO( itemCotizacion.getProducto() ) );
        itemCotizacionDTO.setCantidad( itemCotizacion.getCantidad() );
        itemCotizacionDTO.setPrecioUnitario( itemCotizacion.getPrecioUnitario() );
        itemCotizacionDTO.setSubtotal( itemCotizacion.getSubtotal() );

        return itemCotizacionDTO;
    }

    protected List<ItemCotizacionDTO> itemCotizacionListToItemCotizacionDTOList(List<ItemCotizacion> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemCotizacionDTO> list1 = new ArrayList<ItemCotizacionDTO>( list.size() );
        for ( ItemCotizacion itemCotizacion : list ) {
            list1.add( itemCotizacionToItemCotizacionDTO( itemCotizacion ) );
        }

        return list1;
    }

    protected Cliente createCotizacionDTOToCliente(CreateCotizacionDTO createCotizacionDTO) {
        if ( createCotizacionDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        if ( createCotizacionDTO.getClienteId() != null ) {
            cliente.setId( createCotizacionDTO.getClienteId() );
        }

        return cliente;
    }
}
