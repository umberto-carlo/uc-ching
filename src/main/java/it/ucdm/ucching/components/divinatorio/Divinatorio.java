package it.ucdm.ucching.components.divinatorio;

import it.ucdm.ucching.components.divinatorio.ifaces.IDivinatorio;
import it.ucdm.ucching.components.divinatorio.util.OracoloGenerator;
import it.ucdm.ucching.components.divinatorio.util.RicercaEsagrammiBuilder;
import it.ucdm.ucching.model.Oracolo;
import it.ucdm.ucching.util.RicercaEsagrammi;

import java.util.Optional;

public class Divinatorio implements IDivinatorio {
    private OracoloGenerator oracoloGenerator;

    private RicercaEsagrammi ricercaEsagrammi;

    {
        this.oracoloGenerator = new OracoloGenerator();

        RicercaEsagrammiBuilder ricercaEsagrammiBuilder = new RicercaEsagrammiBuilder();
        this.ricercaEsagrammi = ricercaEsagrammiBuilder.build();
    }

    @Override
    public void divina() {
        System.out.println("Benvenuti ai ching");
        Oracolo oracolo = this.oracoloGenerator.generaOracolo();
        System.out.println("Esagramma generato");
        System.out.println(oracolo.toString());
        int numeroEsagramma = this.ricercaEsagrammi.getNumero(oracolo.getEsagramma());
        Optional<Integer> numeroEsagrammaComplementare = oracolo.getEsagrammaComplementare().map(this.ricercaEsagrammi::getNumero);
        System.out.println(String.valueOf(numeroEsagramma) + numeroEsagrammaComplementare.map(String::valueOf).map(n -> " + " + n).orElse(""));
    }
}
