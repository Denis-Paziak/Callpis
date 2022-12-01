package com.example.first;

import javafx.scene.control.ListView;

public class ListLess {
    ListView<Integer> list;

    ListLess (  ListView<Integer> listView) {
        list = listView;
        for (int i = 1; i <= 8; i++) {
            list.getItems().add(i);
        }
        listView.getSelectionModel().select(0);
    }

    void setActiveLess (int index) {
        list.getSelectionModel().select(index);
    }
}
