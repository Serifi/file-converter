package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Main;

import java.io.File;
import java.io.IOException;

public class MainController {
    private Main main;

    @FXML
    private Button convertB;

    @FXML
    private Button chooseFileB;

    @FXML
    private Button saveFileB;

    @FXML
    private TextField chooseFileTF;

    @FXML
    private TextField saveFileTF;

    @FXML
    private Label fileConverterL;

    @FXML
    void chooseFile(ActionEvent event) {
        Stage stage = (Stage) chooseFileTF.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Alle Dateien","*.csv","*.dst","*.ost"),
                new FileChooser.ExtensionFilter(".csv", "*.csv"),
                new FileChooser.ExtensionFilter(".dst", "*.dst"),
                new FileChooser.ExtensionFilter(".ost", "*.ost"));

        File selectedFileFrom = fileChooser.showOpenDialog(stage);
        chooseFileTF.setText(selectedFileFrom.getName());
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void convert(ActionEvent event) throws IOException, ClassNotFoundException {

        if (chooseFileTF.getText().endsWith(".csv") || saveFileTF.getText().endsWith(".csv")){
            main.getLogic().loadTrennzeichen(main.getPrimaryStage(), main);
        }else{
            main.getLogic().convert(chooseFileTF.getText(), saveFileTF.getText(), main.getLogic().getOldTrennzeichen(), main.getLogic().getNewTrennzeichen());
        }

        alert();
    }

    @FXML
    void saveFile(ActionEvent event) {
        Stage stage = (Stage) chooseFileTF.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(".csv", "*.csv"),
                new FileChooser.ExtensionFilter(".dst", "*.dst"),
                new FileChooser.ExtensionFilter(".ost", "*.ost"));

        File selectedFileTo = fileChooser.showSaveDialog(stage);
        saveFileTF.setText(selectedFileTo.getName());
    }

    public void alert(){
        if(chooseFileTF.getText().isEmpty() || saveFileTF.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Fill up the gapes!");
            alert.showAndWait();
        }
        else{
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Convert Successful");
            alert2.showAndWait();
        }
    }

    public TextField getChooseFileTF() {
        return chooseFileTF;
    }

    public TextField getSaveFileTF() {
        return saveFileTF;
    }
}