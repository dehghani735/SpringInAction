package com.mdt.FunctionalAndReactive.M9_DesignPatterns.M9_8_Command;

public class CommandDesingDemo {

    public static void main(String[] args) {

        AC ac1 = new AC();
        AC ac2 = new AC();

        ACAutomationRemote remote = new ACAutomationRemote();
        remote.setCommand(() -> ac2.turnOn());
        remote.buttonPressed();

        // we can add any number of new action methods to the receiver without changing the client code
    }
}
