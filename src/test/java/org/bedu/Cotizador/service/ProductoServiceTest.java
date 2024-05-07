package org.bedu.Cotizador.service;

import org.bedu.Cotizador.dto.createDTO.CreateProductoDTO;
import org.bedu.Cotizador.dto.ProductoDTO;
import org.bedu.Cotizador.dto.updateDTO.UpdateProductoDTO;
import org.bedu.Cotizador.model.Producto;
import org.bedu.Cotizador.repository.ProductoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductoServiceTest {

    @MockBean
    private ProductoRepository repository;

    @Autowired
    private ProductoService service;

    @Test
    @DisplayName("Service should be injected")
    void smokeTest() {
        assertNotNull(service);
    }

    @Test
    @DisplayName("Test para obtener la lista de productos")
    void findAllTest() {
        List<Producto> Productos = new LinkedList<>();

        Producto producto = new Producto();

        producto.setId(1);
        producto.setNombre("Mancuerna Precor 5 kg");
        producto.setSku("ManNeg001");
        producto.setPrecio(new BigDecimal("500"));
        producto.setStock(25);
        producto.setDescripcion("Mancuerna hexagonal negro de cinco kg");
        producto.setCategoria("Accesorios");
        producto.setMarca("Precor");
        producto.setModelo("sg563");

        Productos.add(producto);

        when(repository.findAll()).thenReturn(Productos);

        List<ProductoDTO> result = service.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(producto.getId(), result.get(0).getId());
        assertEquals(producto.getNombre(), result.get(0).getNombre());
        assertEquals(producto.getSku(), result.get(0).getSku());
        assertEquals(producto.getPrecio(),result.get(0).getPrecio());
        assertEquals(producto.getStock(), result.get(0).getStock());
        assertEquals(producto.getDescripcion(), result.get(0).getDescripcion());
        assertEquals(producto.getCategoria(), result.get(0).getCategoria());
        assertEquals(producto.getMarca(), result.get(0).getMarca());
        assertEquals(producto.getMarca(), result.get(0).getMarca());
    }

    @Test
    @DisplayName("Test para guardar un Producto")
    void saveTest() {
        CreateProductoDTO createProductoDTO = new CreateProductoDTO();

        createProductoDTO.setNombre("Mancuerna Precor 5 kg");
        createProductoDTO.setSku("ManNeg001");
        createProductoDTO.setPrecio(new BigDecimal("500"));
        createProductoDTO.setStock(25);
        createProductoDTO.setDescripcion("Mancuerna hexagonal negro de cinco kg");
        createProductoDTO.setCategoria("Accesorios");
        createProductoDTO.setMarca("Precor");
        createProductoDTO.setModelo("sg563");

        Producto producto = new Producto();

        producto.setId(1);
        producto.setNombre("Mancuerna Precor 5 kg");
        producto.setSku("ManNeg001");
        producto.setPrecio(new BigDecimal("500"));
        producto.setStock(25);
        producto.setDescripcion("Mancuerna hexagonal negro de cinco kg");
        producto.setCategoria("Accesorios");
        producto.setMarca("Precor");
        producto.setModelo("sg563");

        when(repository.save(any(Producto.class))).thenReturn(producto);

        ProductoDTO result = service.save(createProductoDTO);

        assertNotNull(result);
        assertEquals(producto.getId(), result.getId());
        assertEquals(producto.getNombre(), result.getNombre());
        assertEquals(producto.getSku(), result.getSku());
        assertEquals(producto.getPrecio(),result.getPrecio());
        assertEquals(producto.getStock(), result.getStock());
        assertEquals(producto.getDescripcion(), result.getDescripcion());
        assertEquals(producto.getCategoria(), result.getCategoria());
        assertEquals(producto.getMarca(), result.getMarca());
        assertEquals(producto.getMarca(), result.getMarca());

    }

    @Test
    @DisplayName("Test para actualizar un Producto")
    void updateClientExists() {
        Producto producto = new Producto();

        producto.setId(1);
        producto.setNombre("Mancuerna Precor 5 kg");
        producto.setSku("ManNeg001");
        producto.setPrecio(new BigDecimal("500"));
        producto.setStock(25);
        producto.setDescripcion("Mancuerna hexagonal negro de cinco kg");
        producto.setCategoria("Accesorios");
        producto.setMarca("Precor");
        producto.setModelo("sg563");

        UpdateProductoDTO update = new UpdateProductoDTO();

        update.setNombre("Mancuerna life fitness 5 kg");
        update.setPrecio(new BigDecimal("459"));
        update.setDescripcion("Mancuerna redonda gris de cinco kg");
        update.setStock(50);

        when(repository.findById(anyLong())).thenReturn(Optional.of(producto));

        service.update(update, 1);

        verify(repository, times(1)).save(producto);
        assertEquals(update.getNombre(), producto.getNombre());
        assertEquals(update.getPrecio(), producto.getPrecio());
        assertEquals(update.getDescripcion(), producto.getDescripcion());
        assertEquals(update.getStock(), producto.getStock());
    }

    @Test
    @DisplayName("No se actualizará un Cliente si no existe en la base de datos")
    void updateClientDoesNotExist() {
        UpdateProductoDTO dto = new UpdateProductoDTO();
        Optional<Producto> dummy = Optional.empty();

        when(repository.findById(anyLong())).thenReturn(dummy);

        assertThrows(RuntimeException.class, () -> service.update(dto, 187));
    }

    @Test
    @DisplayName("Test para eliminar un Cliente por su ID")
    void deleteTest() {
        service.delete(4345L);

        verify(repository, times(1)).deleteById(4345L);
    }
}
