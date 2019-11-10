package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.controller.GameStartContrller;
import main.controller.WorldController;
import main.model.Map;
import main.model.Player;

import java.io.IOException;

public class Main extends Application {

    Stage primaryStage;
    WorldController controller;
    public static Map map = new Map();

    public static Player player = new Player();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("main/view/world.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        this.primaryStage = primaryStage;

        primaryStage.setTitle("咸鱼大冒险");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        gameStart();
    }

    /**
     * 开始游戏，加载信息填写页面
     */
    public void gameStart() {
        Stage dialog = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getClassLoader().getResource("main/view/gameStart.fxml"));
        AnchorPane page = null;
        try {
            page = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameStartContrller controller = loader.getController();
        controller.setWorldController(this.controller);
        controller.setThisPage(dialog);

        Scene scene = new Scene(page);
        dialog.initOwner(primaryStage);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setTitle("咸鱼大冒险");
        dialog.setScene(scene);

        dialog.setOnCloseRequest(event -> System.exit(0));

        dialog.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
