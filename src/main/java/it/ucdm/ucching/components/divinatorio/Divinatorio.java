package it.ucdm.ucching.components.divinatorio;

import it.ucdm.ucching.components.divinatorio.ifaces.IDivinatorio;
import it.ucdm.ucching.components.divinatorio.util.OracoloGenerator;
import it.ucdm.ucching.model.Oracolo;

public class Divinatorio implements IDivinatorio {
    private OracoloGenerator oracoloGenerator;

    {
        this.oracoloGenerator = new OracoloGenerator();
    }

    @Override
    public void divina() {
        System.out.println("Benvenuti ai ching");
        Oracolo oracolo = this.oracoloGenerator.generaOracolo();
        System.out.println("Esagramma generato");
        System.out.println(oracolo.toString());
    }
}
