package net.xaviersala.model;

/**
 * Classe que representa una casella dins del mapa.
 *
 * Created by xavier on 13/06/17.
 */
public class Casella {
    int x;
    int y;

    public Casella(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }

    /**
     * Per comprovar si dues caselles són iguales.
     * @param obj Objecte a comprovar
     * @return  si són iguals o no
     */
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Casella)) {
            return false;
        }
        Casella altre = (Casella) obj;

        return (this.x == altre.getX() && this.y == altre.getY());
    }
}
