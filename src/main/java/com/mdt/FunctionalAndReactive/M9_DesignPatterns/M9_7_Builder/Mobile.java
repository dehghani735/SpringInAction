package com.mdt.FunctionalAndReactive.M9_DesignPatterns.M9_7_Builder;

public class Mobile {

    // To keep the class immutable, we have to define all of the parameters final
    final int ram, storage;
    final int battery;
    final int camera;
    final String processor;
    final double screenSize;

//    public Mobile(int ram, int storage, int battery, int camera, String processor, double screenSize) {
//        this.ram = ram;
//        this.storage = storage;
//        this.battery = battery;
//        this.camera = camera;
//        this.processor = processor;
//        this.screenSize = screenSize;
//    }

    public Mobile(MobileBuilder builder) {
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.battery = builder.battery;
        this.camera = builder.camera;
        this.processor = builder.processor;
        this.screenSize = builder.screenSize;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public int getBattery() {
        return battery;
    }

    public int getCamera() {
        return camera;
    }

    public String getProcessor() {
        return processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        return "Specification - Mobile{" +
                "ram=" + ram +
                ", storage=" + storage +
                ", battery=" + battery +
                ", camera=" + camera +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
