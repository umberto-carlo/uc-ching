package it.ucdm.ucching.model;

import it.ucdm.ucching.model.enums.ELinea;

import java.util.stream.Stream;

public class Esagramma {
    private ELinea[] linee;

    public Esagramma(ELinea[] linee) {
        this.linee = linee;
    }

    public Esagramma getComplemento() {
        ELinea[] nuovoEsa = new ELinea[this.linee.length];

        for (int i = 0; i < nuovoEsa.length; i++) {
            nuovoEsa[i] = linee[i].getComplemento();
        }

        return new Esagramma(nuovoEsa);
    }

    public boolean isComplementabile() {
        return Stream.of(this.linee).anyMatch(t -> t != t.getComplemento());
    }

    public String[] getRigheCodice() {
        String[] ret = new String[this.linee.length];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = linee[i].getCodice();
        }

        return ret;
    }

    public String[] getRigheStampa() {
        String[] ret = new String[this.linee.length];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = linee[i].getStampa();
        }

        return ret;
    }
}
