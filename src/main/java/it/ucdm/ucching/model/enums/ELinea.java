package it.ucdm.ucching.model.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ELinea {
    YIN_MOBILE(6, "-X-", "- -") {
        public ELinea getComplemento() {
            return YANG;
        }
    },
    YANG(7, "---", "---") {
        public ELinea getComplemento() {
            return YANG;
        }
    },
    YIN(8, "- -", "- -") {
        public ELinea getComplemento() {
            return YIN;
        }
    },
    YANG_MOBILE(9, "-O-", "---") {
        public ELinea getComplemento() {
            return YIN;
        }
    };

    private static final Map<Integer, ELinea> map;

    static {
        map = Stream.of(ELinea.values()).collect(Collectors.toMap(ELinea::getNumero, Function.identity()));
    }

    private int numero;

    private String codice;

    private String stampa;

    ELinea(int numero, String codice, String stampa) {
        this.numero = numero;
        this.codice = codice;
        this.stampa = stampa;
    }

    public abstract ELinea getComplemento();

    public int getNumero() {
        return numero;
    }

    public String getCodice() {
        return codice;
    }

    public String getStampa() {
        return stampa;
    }

    public static ELinea getLinea(int numero) {
        return map.get(numero);
    }
}
