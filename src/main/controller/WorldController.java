package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Main;
import main.model.ThePoint;

/**
 * 世界
 *
 * @author YMS
 * @date 2019/11/9
 */
public class WorldController {
    private ThePoint thePoint;
    Integer order = 1;

    @FXML
    private Pane life;

    @FXML
    private Label people;
    @FXML
    private Label communication;

    @FXML
    public ImageView woman;
    @FXML
    public ImageView man;
    @FXML
    public Label name;
    @FXML
    public Label work;
    @FXML
    public Label sex;
    @FXML
    public Label power;
    @FXML
    public Label speed;
    @FXML
    public Label wisdom;

    @FXML
    private void initialize() {
        //初始化
        man.setOpacity(0);

        Main.player.nameProperty().addListener(((observable, oldValue, newValue) -> {
            name.setText(newValue);
        }));
        Main.player.sexProperty().addListener(((observable, oldValue, newValue) -> {
            sex.setText(newValue);
        }));
        Main.player.workProperty().addListener(((observable, oldValue, newValue) -> {
            work.setText(newValue);
        }));
        Main.player.powerProperty().addListener(((observable, oldValue, newValue) -> {
            power.setText(String.valueOf(newValue));
            if (newValue.intValue() <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("力量过低，扣减3生命");
                Main.player.setLife(Main.player.getLife() - 6);
                alert.showAndWait();
            }
        }));
        Main.player.speedProperty().addListener(((observable, oldValue, newValue) -> {
            speed.setText(String.valueOf(newValue));
            if (newValue.intValue() <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("力量过低，扣减2生命");
                Main.player.setLife(Main.player.getLife() - 4);
                alert.showAndWait();
            }
        }));
        Main.player.wisdomProperty().addListener(((observable, oldValue, newValue) -> {
            wisdom.setText(String.valueOf(newValue));
            if (newValue.intValue() <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("力量过低，扣减1生命");
                Main.player.setLife(Main.player.getLife() - 2);
                alert.showAndWait();
            }
        }));
        Main.player.lifeProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > 200) {
                Main.player.setLife(200);
                life.setPrefHeight(200);
            }
            if (newValue.intValue() <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("你死了！");
                alert.setOnCloseRequest(event -> System.exit(0));
                alert.showAndWait();
            }
            life.setPrefHeight(newValue.doubleValue());
            life.setLayoutY(200 - newValue.doubleValue());

            thePoint = Main.map.getPoint();
            order = 1;

        });
        thePoint = Main.map.getPoint();
        show();
    }

    @FXML
    private void communication() {
        if (thePoint.getDesc().length <= order) {
            showDialog();
            thePoint.op(Main.player);
            thePoint = Main.map.getPoint();
            order = 1;
        } else {
            order++;
        }
        show();
    }

    public void show() {
        people.setText(thePoint.getMan() + ": ");
        communication.setText(thePoint.getDesc()[order - 1]);
    }

    public void showDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(thePoint.getOp());
        alert.showAndWait();
    }

    /**
     * 战斗
     */
    public void battle() {
        communication.setText("我跟你拼了!!!");
        Main.player.setLife(Main.player.getLife() - 10);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("你赢了！");
        alert.setOnCloseRequest(event -> show());
        alert.showAndWait();
    }

    /**
     * 跑路
     */
    public void goOut() {
        int i = (int) (Math.random() * 2);
        if ((i & 1) == 0) {
            communication.setText("还敢跑？看我不打断你的腿!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("没跑掉!");
            alert.setOnCloseRequest(event -> show());
            Main.player.setLife(Main.player.getLife() - 20);
            alert.showAndWait();
        } else {
            communication.setText("哼！别让我再碰见你!!!!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("溜之大吉!!");
            alert.setOnCloseRequest(event -> show());
            alert.showAndWait();
        }
    }
}
