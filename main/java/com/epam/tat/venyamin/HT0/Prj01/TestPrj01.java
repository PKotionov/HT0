package com.epam.tat.venyamin.HT0.Prj01;

public class TestPrj01 {
    public static void main(String[] args) {
        Building building = new BuildingImpl("House");
        building.addRoom("Bedroom", 15, 2);
        building.getRoom("Bedroom").add(new Lamp(300));
        building.getRoom("Bedroom").add(new Lamp(2000));
        building.getRoom("Bedroom").add(new Table("Стол письменный", 3));
        building.getRoom("Bedroom").add(new Table("Стол обеденный", 2, 10));

        building.addRoom("Mainroom", 300, 4);
        building.getRoom("Mainroom").add(new Chair("Мягкое и пушистое кресло", 5));

        building.addRoom("Toilet", 10.5, 0);
        building.getRoom("Toilet").add(new Lamp(300));

        building.addRoom("Bathroom", 20, 0);
        building.getRoom("Bathroom").add(new Lamp(150));
        building.describe();
    }
}
