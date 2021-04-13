package com.hasib.java.advance.lambda.builderpattern;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

import java.util.function.Consumer;
import java.util.function.Function;

public class Computer {
    private final Disk disk;
    private final Processor processor;

    public Computer(Disk disk, Processor processor) {
        this.disk = disk;
        this.processor = processor;
    }

    public static void create(Consumer<ComputerBuilder> builder) {
        builder.accept(processor -> disk -> new Computer(disk, processor));
    }

    public static Computer createAndReturn(Function<ComputerBuilder, Computer> builder) {
        return builder.apply(processor -> disk -> new Computer(disk, processor));
    }

    public static void main(String[] args) {
        Computer.create(computerBuilder -> computerBuilder.with(Processor.processor().core(2).speed(2).type(Processor.Type.i386))
                .and(Disk.disk().size(512).speed(2200).type(Disk.Type.IDE)));

        System.out.println(Computer.createAndReturn(computerBuilder -> computerBuilder.with(Processor.processor().core(4).speed(3).x64())
                .and(Disk.disk().size(1024).speed(7200).sata())).toString());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "disk=" + disk +
                ", processor=" + processor +
                '}';
    }

    interface ComputerBuilder {
        ProcessorBuilder with(Processor processor);
    }

    interface ProcessorBuilder {
        Computer and(Disk disk);
    }
}

class Processor {
    private final int cores, speed;
    private final Type type;

    public Processor(int cores, int speed, Type type) {
        this.cores = cores;
        this.speed = speed;
        this.type = type;
    }

    public static ProcessorBuilder processor() {
        return core -> speed -> type -> new Processor(core, speed, type);
    }

    public int getCores() {
        return cores;
    }

    public int getSpeed() {
        return speed;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "cores=" + cores +
                ", speed=" + speed +
                ", type=" + type +
                '}';
    }

    public enum Type {
        i386, x64, x86_64
    }

    interface ProcessorBuilder {
        SpeedBuilder core(int core);
    }

    interface SpeedBuilder {
        TypeBuilder speed(int speed);
    }

    interface TypeBuilder {
        Processor type(Type type);

        default Processor x64() {
            return type(Type.i386);
        }
    }
}

class Disk {
    private final int size, speed;
    private final Type type;

    public Disk(int size, int speed, Type type) {
        this.size = size;
        this.speed = speed;
        this.type = type;
    }

    public static DiskBuilder disk() {
        return size -> speed -> type -> new Disk(size, speed, type);
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "size=" + size +
                ", speed=" + speed +
                ", type=" + type +
                '}';
    }

    public enum Type {
        SATA, PATA, SCSI, SAS, FC, IDE
    }

    interface DiskBuilder {
        SpeedBuilder size(int size);
    }

    interface SpeedBuilder {
        TypeBuilder speed(int speed);
    }

    interface TypeBuilder {
        Disk type(Type type);

        default Disk sata() {
            return type(Type.SATA);
        }
    }
}
