package com.lin.DesignPatterns.builder.normal;

public class Director {
    private ComputerBuilder computerBuilder;

    public Director(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void createComputer(){
        computerBuilder.setCpu();
        computerBuilder.setGpu();
        computerBuilder.setHardDisk();
        computerBuilder.setKeyBoard();
        computerBuilder.setMemery();
        System.out.println(computerBuilder.getComputer());
    }

    public static void main(String[] args) {
        new Director(new LowComputerBuilder()).createComputer();
        new Director(new HighComputerBuilder()).createComputer();
    }
}
