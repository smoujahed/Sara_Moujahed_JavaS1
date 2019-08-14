package com.company;

public class Laptop {
    private String serialNum;

    private Memory memory;
    private Processor processor;
    private OpticalDrive opticalDrive;

    public Laptop() {}
    public Laptop(String serialNum, Memory memory, Processor processor, OpticalDrive opticalDrive) {
        this.serialNum = serialNum;
        this.memory = memory;
        this.processor = processor;
        this.opticalDrive = opticalDrive;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public OpticalDrive getOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(OpticalDrive opticalDrive) {
        this.opticalDrive = opticalDrive;
    }
}
