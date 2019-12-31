package com.lin.DesignPatterns.builder.normal;

public class LowComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public LowComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public Computer getComputer(){
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("i3");
    }

    @Override
    public void setMemery() {
        computer.setMemery("4G");
    }

    @Override
    public void setHardDisk() {
        computer.setHardDisk("500G 机械");
    }

    @Override
    public void setGpu() {
        computer.setGpu("集显");
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyBoard("普通键盘");
    }
}
