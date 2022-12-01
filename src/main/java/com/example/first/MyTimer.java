package com.example.first;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer extends App{

    Timer myTimer = new Timer();
    TimerTask task;

    MyTimer () {
        super();
    }

    MyTimer (Schedule schedule, Music music) {
        this.task = new TimerTask() {
            public void run() {
                playMus(schedule,music, schedule.startLessArr, schedule.endLessArr);
            }
        };
    }

    void start () {
        myTimer.scheduleAtFixedRate(task, 0, 1000L);
    }
    void stop () {
        myTimer.cancel();
    }
}
