package model;

import java.io.*;
import java.util.HashMap;
import java.util.TreeSet;

public class BinaerReaderWriter implements ReaderWriter {

    @Override
    public HashMap<String, TreeSet<Schueler>> read(String filename) throws IOException {
        HashMap<String, TreeSet<Schueler>> schuelerliste = new HashMap<>();
        String key;

        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)))){

            int len = dis.readInt();
            for (int i = 0; i < len; i++) {

                Schueler schueler = new Schueler(dis.readInt(), dis.readInt(), dis.readUTF(), dis.readUTF(), dis.readUTF(),
                                                 dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readInt(), dis.readUTF(),
                                                 dis.readUTF(), dis.readUTF(), dis.readUTF());

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
        int schueleranzahl = 0;

        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));) {

            for (TreeSet<Schueler> schuelertreeset : schuelerliste.values()) {
                schueleranzahl += schuelertreeset.size();
            }

            dos.writeInt(schueleranzahl);

            for (TreeSet<Schueler> schuelertreeset : schuelerliste.values()) {
                for (Schueler schueler : schuelertreeset) {
                    dos.writeInt(schueler.getSsd_id());
                    dos.writeInt(schueler.getSsd_katnr());
                    dos.writeUTF(schueler.getSsd_zuname());
                    dos.writeUTF(schueler.getSsd_vorname());
                    dos.writeUTF(schueler.getSsd_geschlecht());
                    dos.writeUTF(schueler.getSsd_religion());
                    dos.writeUTF(schueler.getSsd_gebdatum());
                    dos.writeUTF(schueler.getSsd_str());
                    dos.writeInt(schueler.getSsd_plz());
                    dos.writeUTF(schueler.getSsd_ort());
                    dos.writeUTF(schueler.getSsd_schulformkurzbez());
                    dos.writeUTF(schueler.getSsd_kla_bezeichnung());
                    dos.writeUTF(schueler.getSsd_kv_zuname());
                }
            }
        }
    }
}