package com.epam.tat.venyamin.HT0.Prj01;

interface Building {
    void addRoom(String roomName, Double area, Integer windowQuantity);
    void addRoom(String roomName, Integer area, Integer windowQuantity);
    Room getRoom(String name);
    void describe();
}
