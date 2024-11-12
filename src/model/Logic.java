package model;

import controller.MainController;
import controller.TrennzeichenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

public class Logic {

   private MainController mainController;
   private TrennzeichenController trennzeichenController;

   private CSVReaderWriter csvReaderWriter;
   private BinaerReaderWriter binaerReaderWriter;
   private ObjectReaderWriter objectReaderWriter;

   private HashMap<String, TreeSet<Schueler>> schuelerliste = new HashMap<>();

   private String oldTrennzeichen;
   private String newTrennzeichen;

    public void loadMain(Stage primaryStage, Main main) throws IOException {
        FXMLLoader fxmlLoaderMain = new FXMLLoader();
        fxmlLoaderMain.setLocation(getClass().getResource("../view/mainView.fxml"));

        Parent rootMain = fxmlLoaderMain.load();

        mainController = fxmlLoaderMain.getController();
        mainController.setMain(main);

        primaryStage.setTitle("File Converter");
        primaryStage.setScene(new Scene(rootMain));
        primaryStage.show();
    }

    public void loadTrennzeichen(Stage primaryStage, Main main) throws IOException {
        FXMLLoader fxmlLoaderTrennzeichen = new FXMLLoader();
        fxmlLoaderTrennzeichen.setLocation(getClass().getResource("../view/trennzeichenView.fxml"));
        Parent rootTrennzeichen = fxmlLoaderTrennzeichen.load();

        trennzeichenController = fxmlLoaderTrennzeichen.getController();
        trennzeichenController.setMain(main);
        trennzeichenController.handleButtons();

        Stage stage = new Stage();
        primaryStage.setTitle("Trennzeichen");
        primaryStage = new Stage();
        primaryStage.setScene(new Scene(rootTrennzeichen));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        primaryStage.showAndWait();
    }

    public Logic() {
        binaerReaderWriter = new BinaerReaderWriter();
        objectReaderWriter = new ObjectReaderWriter();
    }

    private HashMap<String, TreeSet<Schueler>> csvRead(String chooseFile, String oldTZ) throws IOException {
        csvReaderWriter = new CSVReaderWriter(oldTZ, null);
        return csvReaderWriter.read(chooseFile);
    }

    private void csvWrite(HashMap<String, TreeSet<Schueler>> schuelerliste, String filename, String newTZ) throws IOException {
        csvReaderWriter = new CSVReaderWriter(null, newTZ);
        csvReaderWriter.write(schuelerliste, filename);
    }

    private HashMap<String, TreeSet<Schueler>> binaerRead (String filename) throws IOException {
        return binaerReaderWriter.read(filename);
    }

    private void binaerWrite(HashMap<String, TreeSet<Schueler>> schuelerliste, String filename) throws IOException {
        binaerReaderWriter.write(schuelerliste, filename);
    }

    private HashMap<String, TreeSet<Schueler>> objectRead (String filename) throws IOException, ClassNotFoundException {
        return objectReaderWriter.read(filename);
    }

    private void objectWrite (HashMap<String, TreeSet<Schueler>> schuelerliste, String filename) throws IOException {
        objectReaderWriter.write(schuelerliste, filename);
    }

    public void convert(String chooseFile,String saveFile,String trennzeichen, String newTrennzeichen) throws IOException, ClassNotFoundException {

        if (chooseFile.endsWith(".csv")) {
            schuelerliste = csvRead(chooseFile, trennzeichen);
            System.out.println(schuelerliste);
        } else if (chooseFile.endsWith(".dst")) {
            schuelerliste = binaerRead(chooseFile);
        } else if (chooseFile.endsWith(".ost")) {
            schuelerliste = objectRead(chooseFile);
        }

        if (saveFile.endsWith(".csv")) {
            csvWrite(schuelerliste, saveFile, newTrennzeichen);
            System.out.println(schuelerliste);
        } else if (saveFile.endsWith(".dst")) {
            binaerWrite(schuelerliste, saveFile);
        } else if (saveFile.endsWith(".ost")) {
            objectWrite(schuelerliste, saveFile);
        }
    }

    public void setOldTrennzeichen(String oldTrennzeichen) {
        this.oldTrennzeichen = oldTrennzeichen;
    }

    public void setNewTrennzeichen(String newTrennzeichen) {
        this.newTrennzeichen = newTrennzeichen;
    }

    public MainController getMainController() {
        return mainController;
    }

    public String getOldTrennzeichen() {
        return oldTrennzeichen;
    }

    public String getNewTrennzeichen() {
        return newTrennzeichen;
    }
}


