package org.bedu.Cotizador.mapper;

import javax.annotation.processing.Generated;
import org.bedu.Cotizador.dto.ClienteDTO;
import org.bedu.Cotizador.dto.createDTO.CreateClienteDTO;
import org.bedu.Cotizador.dto.updateDTO.UpdateClienteDTO;
import org.bedu.Cotizador.model.Cliente;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T08:44:06-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toModel(CreateClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNombre( dto.getNombre() );
        cliente.setApellido( dto.getApellido() );
        cliente.setDireccion( dto.getDireccion() );
        cliente.setEmail( dto.getEmail() );
        cliente.setTelefono( dto.getTelefono() );

        return cliente;
    }

    @Override
    public Cliente toModel(UpdateClienteDTO dto, Cliente cliente) {
        if ( dto == null ) {
            return cliente;
        }

        if ( dto.getNombre() != null ) {
            cliente.setNombre( dto.getNombre() );
        }
        if ( dto.getApellido() != null ) {
            cliente.setApellido( dto.getApellido() );
        }
        if ( dto.getDireccion() != null ) {
            cliente.setDireccion( dto.getDireccion() );
        }
        if ( dto.getEmail() != null ) {
            cliente.setEmail( dto.getEmail() );
        }
        if ( dto.getTelefono() != null ) {
            cliente.setTelefono( dto.getTelefono() );
        }

        return cliente;
    }

    @Override
    public ClienteDTO toDTO(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( entity.getId() );
        clienteDTO.setNombre( entity.getNombre() );
        clienteDTO.setApellido( entity.getApellido() );
        clienteDTO.setDireccion( entity.getDireccion() );
        clienteDTO.setEmail( entity.getEmail() );
        clienteDTO.setTelefono( entity.getTelefono() );

        return clienteDTO;
    }
}
