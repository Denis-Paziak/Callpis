package com.example.first;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

public class Schedule {
    private Calendar StartLessCalendar = new GregorianCalendar();
    int countLess;
    String [] startLessArr;
    String [] endLessArr;

    int timeLess;
    int littleBreak;
    int bigBreak;
    int startBigBreak;

    Schedule (String startTime) {
        setStartTime(startTime);
        generateArr();
    }

    Schedule (Map<String,String> arr) {
        setStartTime(arr.get("startLess"));
        this.timeLess = Integer.parseInt(arr.get("timeLess"));
        this.littleBreak = Integer.parseInt(arr.get("littleBreak"));
        this.bigBreak = Integer.parseInt(arr.get("bigBreak"));
        this.startBigBreak = Integer.parseInt(arr.get("startBigBreak"));
        this.countLess = Integer.parseInt(arr.get("countLess"));
        this.startLessArr = new String[countLess];
        this.endLessArr = new String[countLess];
        generateArr();
    }

    void generateArr () {
        for (int i = 0; i < countLess; i++) {
            startLessArr[i] = formatTime(StartLessCalendar);
            StartLessCalendar.add(Calendar.MINUTE, timeLess);
            endLessArr[i] = formatTime(StartLessCalendar);

            // pererva
            if (i == startBigBreak - 1) {
                StartLessCalendar.add(Calendar.MINUTE, bigBreak);
            }else {
                StartLessCalendar.add(Calendar.MINUTE, littleBreak);
            }
        }
    }

    String formatTime (Calendar cal) {
        SimpleDateFormat myFormatTime = new SimpleDateFormat("HH:mm");
        return myFormatTime.format(cal.getTime());
    }

    String getTime () {
        SimpleDateFormat myFormatTime = new SimpleDateFormat("HH:mm");
        Calendar calendar = new GregorianCalendar();
        return myFormatTime.format(calendar.getTime());
    }

    void setStartTime (String startTime) {
        String [] initTime = startTime.split(":");
        StartLessCalendar.set(Calendar.AM_PM, 0);
        StartLessCalendar.set(Calendar.HOUR, Integer.parseInt(initTime[0]));
        StartLessCalendar.set(Calendar.MINUTE, Integer.parseInt(initTime[1]));
        StartLessCalendar.set(Calendar.SECOND, 0);
    }

}
