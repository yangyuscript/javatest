package com.lin.DesignPatterns.builder.normal;

public class HighComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public HighComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public Computer getComputer(){
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("i9");
    }

    @Override
    public void setMemery() {
        computer.setMemery("16G");
    }

    @Override
    public void setHardDisk() {
        computer.setHardDisk("1T SSD");
    }

    @Override
    public void setGpu() {
        computer.setGpu("GTX 2060Ti");
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyBoard("机械键盘");
    }
}
