package net.xaviersala.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ruta d'un cobrador pel mapa.
 *
 * Created by xavier on 13/06/17.
 */
public class Ruta {

    List<Casella> caselles;

    public Ruta() {
        caselles = new ArrayList<>();
    }

    /**
     * Convarteix una cadena amb les posicions en una llista de Coordenades
     *
     * Nom: (0,0), (1,1) --> Coordenada(x=0, y=0), Coordenada(x=1,y=1)
     *
     * @param ruta Cadena amb el camí
     */
    public void creaRuta(String ruta) {
        caselles = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\((.+?),(.+?)\\)");
        Matcher matcher = pattern.matcher(ruta);
        while (matcher.find()) {
            int x = Integer.valueOf(matcher.group(1));
            int y = Integer.valueOf(matcher.group(2));
            caselles.add(new Casella(x,y));
        }
    }


    /**
     * @return retorna la llista amb la ruta feta pel cobrador.
     */
    public List<Casella> getCaselles() {
        return caselles;
    }
}
