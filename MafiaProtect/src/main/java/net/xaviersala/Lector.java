package net.xaviersala;

import net.xaviersala.model.MafiaException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Carrega els mapes i les rutes a memòria.
 *
 * Created by xavier on 13/06/17.
 */
public class Lector {

    public static final String SEPARADOR = "#";

    public String[] llegirRutes(String fitxer) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(
                fitxer)));
        StringBuffer sb = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line).append(SEPARADOR);
        }
        return sb.toString().split(SEPARADOR);
    }

    public String[] llegirMapa(String fitxer) throws IOException, MafiaException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(
                fitxer)));
        StringBuffer sb = new StringBuffer();
        String line;

        int linies = 0;
        int columnes = 0;

        // La primera línia conté les dimensions
        if ((line = reader.readLine()) != null) {
            String[] mides = line.split("x");
            if (mides.length != 2) {
                throw new MafiaException("Mapa " + fitxer + " mal format");
            }

            columnes = Integer.parseInt(mides[0].trim());
            linies = Integer.parseInt(mides[1].trim());

        }

        for (int i = 0; i < linies; i++) {
            if ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.length() != columnes) {
                    throw new MafiaException("Mapa mal definit");
                }
                sb.append(line).append(SEPARADOR);
            }
        }

        return sb.toString().split(SEPARADOR);
    }
}
