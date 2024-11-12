package model;


import java.io.IOException;
import java.util.*;

public interface ReaderWriter {

    HashMap<String, TreeSet<Schueler>> read(String filename) throws IOException, ClassNotFoundException;
    void write(HashMap<String, TreeSet<Schueler>> schuelerliste, String filename) throws IOException;
}