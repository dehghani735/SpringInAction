package com.mdt.FunctionalAndReactive.M9_DesignPatterns.M9_8_Command;

/*
The invoker; which will invoke the command
 */
public class ACAutomationRemote {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}
