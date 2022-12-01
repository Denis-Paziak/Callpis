package com.example.first;

import javafx.scene.control.ListView;

import java.util.Map;

public class App {
    Schedule schedule;
    MyTimer timer;
    Music music;

    static ListView<String> list;

    App () {}


    App (Map<String,String> arr, ListView<String> listView, String nameMusic) {
        this.music = new Music(nameMusic);
        this.schedule = new Schedule(arr);
        this.timer = new MyTimer(this.schedule, music);
        list = listView;
        generateList();
        timer.start();

    }

    void stop () {
        timer.stop();
        System.out.println("stop app");
    }

    void generateList () {
        list.getItems().clear();
        for (int i = 0; i < schedule.startLessArr.length; i++) {
            list.getItems().add("Start: " + schedule.startLessArr[i] + " -------- End: " + schedule.endLessArr[i]);
            list.getSelectionModel().select(0);
        }
    }


    void playMus(Schedule schedule,Music music, String[] startTimeLess, String[] endTimeLess) {
        String time = schedule.getTime();
        for (int i = 0; i < schedule.countLess; i++) {

            // Хвилина мовачання

            if (time.equals("09:00")) {
                Music musTime = new Music("2");
                musTime.play();
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            if (time.equals(startTimeLess[i]) ||  time.equals(endTimeLess[i])) {
                System.out.println("play");
                music.play();
                list.getSelectionModel().select(i);
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                music.stop();
            }
        }
    }
}
