package model;

import controller.MainController;
import controller.TrennzeichenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main extends Application {
    private Logic logic;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        logic = new Logic();
        logic.loadMain(this.primaryStage,this);

    }

    public Logic getLogic() {
        return logic;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }


}