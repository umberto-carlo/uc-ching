package it.ucdm.ucching.components.main;

import it.ucdm.ucching.components.divinatorio.Divinatorio;
import it.ucdm.ucching.components.divinatorio.ifaces.IDivinatorio;

public class Main {
    public static void main(String[] args) {
        IDivinatorio divinatorio = new Divinatorio();

        divinatorio.divina();
    }
}
