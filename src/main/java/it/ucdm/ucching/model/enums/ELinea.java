package it.ucdm.ucching.model.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ELinea {
    YIN_MOBILE(6, "--XX--") {
        public ELinea getComplemento() {
            return YANG;
        }

        public ELinea getNonMobile() {
            return YIN;
        }
    },
    YANG(7, "------") {
        public ELinea getComplemento() {
            return YANG;
        }

        public ELinea getNonMobile() {
            return YANG;
        }
    },
    YIN(8, "--  --") {
        public ELinea getComplemento() {
            return YIN;
        }

        public ELinea getNonMobile() {
            return YIN;
        }
    },
    YANG_MOBILE(9, "--OO--") {
        public ELinea getComplemento() {
            return YIN;
        }

        public ELinea getNonMobile() {
            return YANG;
        }
    };

    private static final Map<Integer, ELinea> map;

    static {
        map = Stream.of(ELinea.values()).collect(Collectors.toMap(ELinea::getNumero, Function.identity()));
    }

    private int numero;

    private String codice;

    ELinea(int numero, String codice) {
        this.numero = numero;
        this.codice = codice;
    }

    public abstract ELinea getComplemento();

    public abstract ELinea getNonMobile();

    public int getNumero() {
        return numero;
    }

    public String getCodice() {
        return codice;
    }

    public static ELinea getLinea(int numero) {
        return map.get(numero);
    }
}
