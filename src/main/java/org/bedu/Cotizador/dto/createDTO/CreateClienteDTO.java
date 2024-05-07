package org.bedu.Cotizador.dto.createDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateClienteDTO {
    @Schema(description = "Nombre del Cliente", example = "Rodrigo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    @Schema(description = "Apellido del Cliente", example = "Chavez Ramos")
    @NotBlank(message = "El apellido no puede estar en blanco")
    private String apellido;
    @Schema(description = "Direccion del Cliente", example = "Avenida Vallarta #1532")
    @NotBlank(message = "La dirección no puede estar en blanco")
    private String direccion;
    @Schema(description = "Correo electronico del Cliente", example = "ejemplo@gmail.com")
    @Email(message = "El formato del correo electrónico no es válido")
    private String email;
    @Schema(description = "Telefono del Cliente", example = "3315255110")
    @NotBlank(message = "El teléfono no puede estar en blanco")
    @Size(min = 10, max = 10, message = "El teléfono debe tener exactamente 10 caracteres")
    private String telefono;
}