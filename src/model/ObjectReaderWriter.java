package model;

import java.io.*;
import java.util.HashMap;
import java.util.TreeSet;

public class ObjectReaderWriter implements ReaderWriter {

    @Override
    public HashMap<String, TreeSet<Schueler>> read(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
        return (HashMap<String, TreeSet<Schueler>>) ois.readObject();
        }
    }

    @Override
    public void write(HashMap<String, TreeSet<Schueler>> schuelerliste, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
            oos.writeObject(schuelerliste);
        }
    }
}