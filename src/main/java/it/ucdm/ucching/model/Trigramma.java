package it.ucdm.ucching.model;

import it.ucdm.ucching.model.enums.ELinea;

import java.util.stream.Stream;

public class Trigramma {
    private ELinea[] linee;

    public Trigramma(ELinea[] linee) {
        this.linee = linee;
    }

    public ELinea[] getLinee() {
        return linee;
    }

    public Trigramma getNonMobile() {
        if (Stream.of(this.linee).anyMatch(l -> !l.equals(l.getNonMobile()))) {
            ELinea[] lineeRet = new ELinea[this.linee.length];

            for (int i = 0; i < lineeRet.length; i++) {
                lineeRet[i] = this.linee[i].getNonMobile();
            }

            return new Trigramma(lineeRet);
        } else {
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            for (int i = 0; i < this.linee.length; i++) {
                if (!this.linee[i].equals(Trigramma.class.cast(o).linee[i])) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int ret = 0;

        for (int i = 0; i < this.linee.length; i++) {
            ret += (31 * i) + this.linee[i].hashCode();
        }

        return ret;
    }
}
