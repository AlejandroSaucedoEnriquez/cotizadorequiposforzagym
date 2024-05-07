package org.bedu.Cotizador.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RntimeException extends Exception  {
    private final String code;
    private final Object details;

    public RntimeException(String code, String message, Object details) {
        super(message);
        this.code = code;
        this.details = details;
    }
}
