package net.xaviersala.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa el mapa amb les cases a on cobrar i
 * en gestiona el funcionament.
 *
 * Created by xavier on 13/06/17.
 */
public class Mapa {

    private int ample;
    private int alt;
    private List<Casella> cases;

    public Mapa() {
        cases = new ArrayList<>();
    }

    /**
     * Carrega un mapa a partir de les línies rebudes.
     *
     * @param linies línies que representen el mapa
     * @throws MafiaException per retornar errors
     */
    public void carregaMapa(String[] linies) throws MafiaException {

        // Per si ja havíen fet servir l'objecte
        cases  = new ArrayList<>();

        // Comprovem que el mapa rebut estigui bé
        if (linies == null) {
            throw new MafiaException("El mapa és incorrecte");
        }

        if (linies.length > 0) {
            alt = linies.length;
            ample = linies[0].length();
        }

        // Carregar cada línia i quedar-se només amb les coordenades
        // de les cases

        for (int fila = 0; fila < ample; fila++) {
            if (linies[fila] == null) {
                throw new MafiaException("El mapa és incorrecte");
            }
            String filaActual = linies[fila];
            for (int columna = 0; columna < filaActual.length(); columna++) {
                if (filaActual.charAt(columna) == 'X') {
                    cases.add(new Casella(columna, fila));
                }
            }
        }
    }

    /**
     * @return retorna la llista de caselles.
     */
    public List<Casella> getCases() {
        return cases;
    }

    /**
     * Entra la ruta d'un cobrador i elimina les cases per
     * on ha passat a cobrar.
     *
     * @param ruta ruta del cobrador.
     */
    public void passejaCobrador(Ruta ruta) {

        for (Casella casella : ruta.getCaselles()) {
            if (cases.contains(casella)) {
                cases.remove(casella);
            }
        }

    }
}
