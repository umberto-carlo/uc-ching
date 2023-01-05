package it.ucdm.ucching.components.divinatorio.util;

import com.google.gson.Gson;
import it.ucdm.ucching.model.Trigramma;
import it.ucdm.ucching.model.enums.ELinea;
import it.ucdm.ucching.model.json.Ricerca;
import it.ucdm.ucching.util.RicercaEsagrammi;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RicercaEsagrammiBuilder {
    private Trigramma getTrigramma(List<Integer> linee) {
        ELinea[] lineeList = new ELinea[linee.size()];

        for (int i = 0, k = linee.size() - 1; i < linee.size(); i++, k--) {
            lineeList[i] = ELinea.getLinea(linee.get(k));
        }

        return new Trigramma(lineeList);
    }

    public RicercaEsagrammi build() {
        InputStream ricercaJSon = this.getClass().getClassLoader().getResourceAsStream("ricerca.json");

        Gson gson = new Gson();

        Ricerca ricerca = gson.fromJson(new InputStreamReader(ricercaJSon, Charset.defaultCharset()), Ricerca.class);

        Map<Trigramma, Map<Trigramma, Integer>> mappaTrigrammi = new HashMap<>();

        ricerca.getRicerca().forEach(elem -> {
            Trigramma trigrammaInferiore = this.getTrigramma(elem.getInferiore());

            Map<Trigramma, Integer> mapSup = mappaTrigrammi.get(trigrammaInferiore);

            if (mapSup == null) {
                mapSup = new HashMap<>();

                mappaTrigrammi.put(trigrammaInferiore, mapSup);
            }

            Trigramma trigrammaSuperiore = this.getTrigramma(elem.getSuperiore());

            mapSup.put(trigrammaSuperiore, elem.getNumero());
        });

        return new RicercaEsagrammi(mappaTrigrammi);
    }
}
