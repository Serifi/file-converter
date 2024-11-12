package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Main;

import java.io.IOException;

public class TrennzeichenController {
    private Main main;
    Stage stage;

    @FXML
    private Button okB;

    @FXML
    private TextField oldTF;

    @FXML
    private Label trennzeichenL;

    @FXML
    private Label oldL;

    @FXML
    private TextField newTF;

    @FXML
    private Label newL;

    @FXML
    private Button closeB;

    @FXML
    void convertTZ(ActionEvent event) throws IOException, ClassNotFoundException {
        if (!(main.getLogic().getMainController().getChooseFileTF().getText().endsWith(".csv"))){
            main.getLogic().setNewTrennzeichen(newTF.getText());
            main.getLogic().convert(main.getLogic().getMainController().getChooseFileTF().getText(), main.getLogic().getMainController().getSaveFileTF().getText(),
                    null,main.getLogic().getNewTrennzeichen());
        }
        else if (!(main.getLogic().getMainController().getSaveFileTF().getText().endsWith(".csv"))){
            main.getLogic().setOldTrennzeichen(oldTF.getText());
            main.getLogic().convert(main.getLogic().getMainController().getChooseFileTF().getText(), main.getLogic().getMainController().getSaveFileTF().getText(),
                    main.getLogic().getOldTrennzeichen(),null);
        }
        else{
            main.getLogic().setOldTrennzeichen(oldTF.getText());
            main.getLogic().setNewTrennzeichen(newTF.getText());
            main.getLogic().convert(main.getLogic().getMainController().getChooseFileTF().getText(), main.getLogic().getMainController().getSaveFileTF().getText(),
                    main.getLogic().getOldTrennzeichen(),main.getLogic().getNewTrennzeichen());
        }

        stage = (Stage) newTF.getScene().getWindow();
        stage.close();
    }

    @FXML
    void close(ActionEvent event) {
        stage = (Stage) newTF.getScene().getWindow();
        stage.close();
    }

    public void handleButtons() {

        if (!(main.getLogic().getMainController().getChooseFileTF().getText().endsWith(".csv"))){
            oldTF.setVisible(false);
            oldL.setVisible(false);
        }
        else if (!(main.getLogic().getMainController().getSaveFileTF().getText().endsWith(".csv"))){
            newTF.setVisible(false);
            newL.setVisible(false);
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Main getMain(){
        return main;
    }

}