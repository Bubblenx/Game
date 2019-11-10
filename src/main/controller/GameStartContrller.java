package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;


/**
 * 初始信息填写
 *
 * @author YMS
 */
public class GameStartContrller {

    Stage thisPage;

    WorldController worldController;

    @FXML
    private TextField name;
    @FXML
    private ComboBox<String> sex;
    @FXML
    private ComboBox<String> work;

    /**
     * 默认调用,类似构造器
     */
    @FXML
    private void initialize() {
        ObservableList<String> sexs = FXCollections.observableArrayList("男", "女");
        ObservableList<String> works = FXCollections.observableArrayList("战士", "法师", "刺客");

        sex.setItems(sexs);
        work.setItems(works);
    }

    /**
     * 开始游戏
     */
    @FXML
    private void start() {
        if (name.getText() == null || name.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("咸鱼也要有个名字嘛");
            alert.showAndWait();
        } else {
            Main.player.setName(name.getText());
            if (sex.getSelectionModel().getSelectedItem() != null && !"".equals(sex.getSelectionModel().getSelectedItem())) {
                Main.player.setSex(sex.getSelectionModel().getSelectedItem());
            } else {
                Main.player.setSex("不可见");
            }
            if (work.getSelectionModel().getSelectedItem() != null && !"".equals(work.getSelectionModel().getSelectedItem())) {
                Main.player.setWork(work.getSelectionModel().getSelectedItem());
            }else{
                Main.player.setWork("平民");
            }

            //设置图片
            if (Main.player.getSex().equals("男")) {
                worldController.woman.setOpacity(0);
                worldController.man.setOpacity(1);
            }

            thisPage.close();
        }
    }

    /**
     * 退出游戏
     */
    @FXML
    private void exit() {
        System.exit(0);
    }

    public void setWorldController(WorldController worldController) {
        this.worldController = worldController;
    }

    public void setThisPage(Stage thisPage) {
        this.thisPage = thisPage;
    }
}
