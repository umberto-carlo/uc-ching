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
            ret[i] = linee[i].getNumero() + ". " + linee[i].getCodice();
        }

        return ret;
    }

    public String[] getRigheStampa() {
        String[] ret = new String[this.linee.length];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = linee[i].getNonMobile().getCodice();
        }

        return ret;
    }

    public Trigramma getTrigrammaInferiore()
    {
        ELinea[] trigr = new ELinea[3];

        trigr[0] = linee[3];
        trigr[1] = linee[4];
        trigr[2] = linee[5];

        return new Trigramma(trigr);
    }

    public Trigramma getTrigrammaSuperiore()
    {
        ELinea[] trigr = new ELinea[3];

        trigr[0] = linee[0];
        trigr[1] = linee[1];
        trigr[2] = linee[2];

        return new Trigramma(trigr);
    }
}
