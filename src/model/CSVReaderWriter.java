package model;

import java.io.*;
import java.util.*;

public class CSVReaderWriter implements ReaderWriter {
    String oldTrennzeichen;
    String newTrennzeichen;

    public CSVReaderWriter(String oldTrennzeichen, String newTrennzeichen) {
        this.oldTrennzeichen = oldTrennzeichen;
        this.newTrennzeichen = newTrennzeichen;
    }

    @Override
    public HashMap<String, TreeSet<Schueler>> read(String filename) throws IOException {
            HashMap<String, TreeSet<Schueler>> schuelerliste = new HashMap<>();
            Schueler schueler = null;
            String[] data;
            String line;
            String key;

            try (BufferedReader br = new BufferedReader(new FileReader(filename));) {

                br.readLine();

                while ((line = br.readLine()) != null){
                    data = line.split(oldTrennzeichen);
                    System.out.println("iwos"+oldTrennzeichen+"iwos");
                    schueler = new Schueler(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], data[4], data[5], data[6], data[7], Integer.parseInt(data[8]), data[9], data[10], data[11], data[12]);

                    key = schueler.getSsd_kla_bezeichnung() + schueler.getSsd_schulformkurzbez();

                    if (schuelerliste.containsKey(key)){
                        schuelerliste.get(key).add(schueler);
                    }
                    else {
                        TreeSet<Schueler> treeset = new TreeSet<>();
                        treeset.add(schueler);
                        schuelerliste.put(key, treeset);
                    }
                }
                return schuelerliste;
            }
    }

    @Override
    public void write(HashMap<String, TreeSet<Schueler>> schuelerliste, String filename) throws IOException {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));){
            String headline = "ssd_id" + newTrennzeichen + "ssd_katnr" + newTrennzeichen + "ssd_zuname" + newTrennzeichen +
                              "ssd_vorname" + newTrennzeichen + "ssd_geschlecht" + newTrennzeichen + "ssd_religion" + newTrennzeichen +
                              "ssd_gebdatum" + newTrennzeichen + "ssd_str" + newTrennzeichen + "ssd_plz" + newTrennzeichen +
                              "ssd_ort" + newTrennzeichen + "ssd_schulformkurzbez" + newTrennzeichen + "ssd_kla_bezeichnung" + newTrennzeichen + "ssd_kv_zuname";

            pw.println(headline);

            for(TreeSet<Schueler> schuelertreeset : schuelerliste.values())
            {
                for (Schueler schueler : schuelertreeset) {
                    pw.println(schueler.getSsd_id() + newTrennzeichen + schueler.getSsd_katnr() + newTrennzeichen + schueler.getSsd_zuname() + newTrennzeichen +
                            schueler.getSsd_vorname() + newTrennzeichen + schueler.getSsd_geschlecht() + newTrennzeichen + schueler.getSsd_religion() + newTrennzeichen +
                            schueler.getSsd_gebdatum() + newTrennzeichen + schueler.getSsd_str() + newTrennzeichen + schueler.getSsd_plz() + newTrennzeichen +
                            schueler.getSsd_ort() + newTrennzeichen + schueler.getSsd_schulformkurzbez() + newTrennzeichen + schueler.getSsd_kla_bezeichnung() + newTrennzeichen + schueler.getSsd_kv_zuname());
                }
            }
        }
    }

    public String getOldTrennzeichen() {
        return oldTrennzeichen;
    }

    public String getNewTrennzeichen() {
        return newTrennzeichen;
    }
}