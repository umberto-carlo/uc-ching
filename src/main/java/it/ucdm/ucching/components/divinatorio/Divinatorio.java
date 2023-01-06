package it.ucdm.ucching.components.divinatorio;

import it.ucdm.ucching.components.divinatorio.ifaces.IDivinatorio;
import it.ucdm.ucching.components.divinatorio.util.OracoloGenerator;
import it.ucdm.ucching.components.divinatorio.util.RicercaEsagrammiBuilder;
import it.ucdm.ucching.model.Oracolo;
import it.ucdm.ucching.util.RicercaEsagrammi;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

public class Divinatorio implements IDivinatorio {
    private OracoloGenerator oracoloGenerator;

    private RicercaEsagrammi ricercaEsagrammi;

    {
        this.oracoloGenerator = new OracoloGenerator();

        RicercaEsagrammiBuilder ricercaEsagrammiBuilder = new RicercaEsagrammiBuilder();
        this.ricercaEsagrammi = ricercaEsagrammiBuilder.build();
    }

    private void apriFile(int numeroEsagramma) {
        try {
            Desktop desktop = Desktop.getDesktop();

            Path theFile = Files.createTempFile("ching", ".pdf");
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(String.format("pdf/i ching_compressed-%1$s.pdf", numeroEsagramma));
            Files.copy(is, theFile, StandardCopyOption.REPLACE_EXISTING);
            desktop.open(theFile.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        if (Desktop.isDesktopSupported()) {
            apriFile(numeroEsagramma);
            numeroEsagrammaComplementare.ifPresent(this::apriFile);
        }
    }
}
