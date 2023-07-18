package com.mdt.FunctionalAndReactive.M9_DesignPatterns.M9_7_Builder;

import java.util.function.Consumer;

public class MobileBuilder {

    int ram, storage;
    int battery;
    int camera;
    String processor;
    double screenSize;

    public MobileBuilder with(Consumer<MobileBuilder> buildFields) {
        buildFields.accept(this);
        return this;
    }

    public Mobile createMobile() {
        return new Mobile(this);
    }
}
