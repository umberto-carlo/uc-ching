package it.ucdm.ucching.components.divinatorio.util;

import it.ucdm.ucching.model.Esagramma;
import it.ucdm.ucching.model.Oracolo;
import it.ucdm.ucching.model.enums.ELinea;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class OracoloGenerator {
    private static final Map<Boolean, Integer> map;

    private static final int NUM_VOLTE = 6;

    static {
        map = new HashMap<>();

        map.put(true, 2);
        map.put(false, 3);
    }

    public Oracolo generaOracolo() {
        Random randomGenerale = new Random(System.currentTimeMillis());

        ELinea[] linee = new ELinea[NUM_VOLTE];

        for (int i = linee.length - 1; i >= 0; i--) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Genera Linea " + (i + 1));
            scan.nextLine();

            long currTime = System.currentTimeMillis();

            Random rand = new Random(currTime);

            int monetaUno = map.get(rand.nextBoolean());

            for (int j = 0; j < randomGenerale.nextInt(1000); j++) {
                rand.nextBoolean();
            }

            int monetaDue = map.get(rand.nextBoolean());

            for (int j = 0; j < randomGenerale.nextInt(1000); j++) {
                rand.nextBoolean();
            }

            int monetaTre = map.get(rand.nextBoolean());

            int somma = monetaUno + monetaDue + monetaTre;

            linee[i] = ELinea.getLinea(somma);

        }

        return new Oracolo(new Esagramma(linee));
    }
}
