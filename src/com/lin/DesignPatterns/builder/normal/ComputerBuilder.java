package com.lin.DesignPatterns.builder.normal;

public interface ComputerBuilder {
    void setCpu();
    void setMemery();
    void setHardDisk();
    void setGpu();
    void setKeyBoard();
    Computer getComputer();
}
