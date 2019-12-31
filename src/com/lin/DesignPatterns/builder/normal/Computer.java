package com.lin.DesignPatterns.builder.normal;

public class Computer {
    private String cpu;
    private String memery;
    private String hardDisk;
    private String gpu;
    private String keyBoard;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemery() {
        return memery;
    }

    public void setMemery(String memery) {
        this.memery = memery;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memery='" + memery + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", gpu='" + gpu + '\'' +
                ", keyBoard='" + keyBoard + '\'' +
                '}';
    }
}
