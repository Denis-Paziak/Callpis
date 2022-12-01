package com.example.first;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Music {
    String name;
    MediaPlayer player;

    Music (String name) {
        this.name = name;
        File file = new File("src/music/"+ name +".mp3");
        String path = file.toURI().toString();
        Media media = new Media(path);
        this.player = new MediaPlayer(media);
    }

    void play () {
        this.player.play();
    }

    void stop () {
        this.player.stop();
    }
}
