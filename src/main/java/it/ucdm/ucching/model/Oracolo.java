package it.ucdm.ucching.model;

import java.util.Optional;
import java.util.function.Predicate;

public class Oracolo {
    private Esagramma esagramma;

    private Optional<Esagramma> esagrammaComplementare;

    public Oracolo(Esagramma esa) {
        this.esagramma = esa;
        this.esagrammaComplementare = this.esagramma.isComplementabile() ? Optional.of(this.esagramma.getComplemento()) : Optional.empty();
    }

    public Esagramma getEsagramma() {
        return esagramma;
    }

    public Optional<Esagramma> getEsagrammaComplementare() {
        return esagrammaComplementare;
    }

    @Override
    public String toString() {
        String ret = "";

        if (this.esagrammaComplementare.isPresent()) {
            String[] codice = this.esagramma.getRigheCodice();
            String[] lineeEsa = this.esagramma.getRigheStampa();
            String[] lineeCompl = this.esagrammaComplementare.get().getRigheStampa();

            for (int i = 0; i < codice.length; i++) {
                switch (i) {
                    case 2: {
                        ret+= codice[i] + " -\\  " + lineeEsa[i] + "   " + lineeCompl[i] + "\n";
                        break;
                    }
                    case 3: {
                        ret+= codice[i] + " -/  " + lineeEsa[i] + " + " + lineeCompl[i]+ "\n";
                        break;
                    }
                    default: {
                        ret+= codice[i] + "     " + lineeEsa[i] + "   " + lineeCompl[i]+ "\n";
                    }
                }
            }
        } else {
            String[] leLinee = this.esagramma.getRigheStampa();

            for (int i = 0; i < leLinee.length; i++) {
                ret += leLinee + "\n";
            }
        }
        return ret;
    }
}
