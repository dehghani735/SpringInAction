package com.mdt.ocp.chapter2.DesignPatterns.Singleton;

// Instantiation using a static block
public class StaffRegister {

    private static final StaffRegister instance;

    static {
        instance = new StaffRegister();
        // Perform additional steps
    }

    private StaffRegister() {
    }

    public static StaffRegister getInstance() {
        return instance;
    }
}
