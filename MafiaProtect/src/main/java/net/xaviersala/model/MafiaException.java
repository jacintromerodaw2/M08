package net.xaviersala.model;

/**
 * Error en la lectura de mapes o rutes.
 *
 * Created by xavier on 13/06/17.
 */
public class MafiaException extends Throwable {
    public MafiaException(String error) {
        super(error);
    }
}
