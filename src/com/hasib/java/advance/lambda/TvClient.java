package com.hasib.java.advance.lambda;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a example of "Command Design Pattern" in java using Lambda expression.
 */

/**
 * Command interface
 */
@FunctionalInterface
interface Command {
    void execute();
}

/**
 * Client Class
 */
public class TvClient {
    public static void main(String[] args) {
        Tv tv = new Tv();

        /**
         * If we use Lambda Expression we can short our codes and work on our point.
         */
//        Command onCommand = new OnCommand(tv);
//        Command offCommand = new OffCommand(tv);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.press(tv::switchOn);
        remoteControl.press(tv::switchOff);
    }
}

class RemoteControl {
    private List<Command> history = new ArrayList<>();

    public void press(Command command) {
        history.add(command);
        command.execute();
    }
}

/**
 * Command class
 */
class OnCommand implements Command {
    private Tv tv;

    public OnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.switchOn();
    }
}

/**
 * Command class
 */
class OffCommand implements Command {
    private Tv tv;

    public OffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.switchOff();
    }
}

/**
 * Receiver class
 */
class Tv {
    public void switchOn() {
        System.out.println("Switching On TV");
    }

    public void switchOff() {
        System.out.println("Switching Off TV");
    }
}
