package it.ucdm.ucching.util;

import it.ucdm.ucching.model.Esagramma;
import it.ucdm.ucching.model.Trigramma;

import java.util.Map;

public class RicercaEsagrammi {
    private Map<Trigramma, Map<Trigramma, Integer>> mappaTrigrammi;

    public RicercaEsagrammi(Map<Trigramma, Map<Trigramma, Integer>> mappaTrigrammi) {
        this.mappaTrigrammi = mappaTrigrammi;
    }

    public int getNumero(Esagramma esa) {
        return mappaTrigrammi.get(esa.getTrigrammaInferiore().getNonMobile()).get(esa.getTrigrammaSuperiore().getNonMobile());
    }
}
