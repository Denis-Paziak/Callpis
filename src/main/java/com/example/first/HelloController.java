package com.example.first;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.*;

public class HelloController {
    App app;

    String nameMusic = "music";

    boolean appIsStart = false;

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField littleBreak;

    @FXML
    private Button startButton;

    @FXML
    private TextField startLess;

    @FXML
    private TextField timeLess;
    @FXML
    private TextField bigBreak;

    @FXML
    private TextField startBigBreak;
    @FXML
    private TextField countLess;

    @FXML
    private ListView<String> musicList;


    @FXML
    void initialize() {

        File dir = new File("src/music");
        File[] files = dir.listFiles();

        for (File el: files) {
            String [] name = el.getName().split("\\.");
            musicList.getItems().add(name[0]);
        }







        Map<String,String> arr = new HashMap<>();
        arr.put("startLess", "08:30");
        arr.put("timeLess", "40");
        arr.put("littleBreak", "10");
        arr.put("bigBreak", "20");
        arr.put("startBigBreak", "4");
        arr.put("countLess", "8");


        startLess.setPromptText(arr.get("startLess"));
        littleBreak.setPromptText(arr.get("littleBreak"));
        timeLess.setPromptText(arr.get("timeLess"));
        bigBreak.setPromptText(arr.get("bigBreak"));
        startBigBreak.setPromptText(arr.get("startBigBreak"));
        countLess.setPromptText(arr.get("countLess"));

        musicList.setOnMouseClicked(event -> {
            nameMusic = musicList.getSelectionModel().getSelectedItem();
            if (appIsStart == true) {
                app.stop();
            }
            appIsStart = false;

            startButton.setStyle("-fx-background-color: #5be55b");
            startButton.setText("Старт");
        });

        if(musicList.getSelectionModel().getSelectedItem() == null) {
            nameMusic = musicList.getItems().get(0);
            musicList.getSelectionModel().select(0);
        }


        startButton.setOnAction(event -> {
            if (!startLess.getText().isEmpty()) {
                try {
                    String [] s = startLess.getText().split(":");
                    Integer.parseInt(s[0]);

                    arr.put("startLess", startLess.getText());
                    startLess.setText( arr.get("startLess"));
                }catch (Exception e) {
                    System.out.println("Не тупимо");
                }


            }else {
                startLess.setText( arr.get("startLess"));
            }

            if (!littleBreak.getText().isEmpty()) {
                arr.put("littleBreak", littleBreak.getText());
            }else {
                littleBreak.setText( arr.get("littleBreak"));
            }

            if (!timeLess.getText().isEmpty()) {
                arr.put("timeLess", timeLess.getText());
            }else {
                timeLess.setText( arr.get("timeLess"));
            }

            if (!bigBreak.getText().isEmpty()) {
                arr.put("bigBreak", bigBreak.getText());
            }else {
                bigBreak.setText( arr.get("bigBreak"));
            }
            if (!startBigBreak.getText().isEmpty()) {
                arr.put("startBigBreak", startBigBreak.getText());
            }else {
                startBigBreak.setText( arr.get("startBigBreak"));
            }
            if (!countLess.getText().isEmpty()) {
                arr.put("countLess", countLess.getText());
            }else {
                countLess.setText( arr.get("countLess"));
            }

            if (!appIsStart) {
                app = new App(arr, listView, nameMusic);
                appIsStart = true;

                startButton.setStyle("-fx-background-color: #d24949");
                startButton.setText("Стоп");
            }else {
                app.stop();
                appIsStart = false;

                startButton.setStyle("-fx-background-color: #5be55b");
                startButton.setText("Старт");
            }

        });
    }
}
