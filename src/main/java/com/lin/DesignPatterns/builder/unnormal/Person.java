package com.lin.DesignPatterns.builder.unnormal;

public class Person {
    /*名字（必须）*/
    private final String name;
    /*性别（必须）*/
    private final String gender;
    /*年龄（非必须）*/
    private final String age;
    /*鞋子（非必须）*/
    private final String shoes;
    /*衣服（非必须）*/
    private final String clothes;
    /*钱（非必须）*/
    private final String money;
    /*房子（非必须）*/
    private final String house;
    /*汽车（非必须）*/
    private final String car;
    /*职业（非必须）*/
    private final String career;


    public Person(Builder builder){
        name = builder.getName();
        gender = builder.getGender();
        age = builder.getAge();
        shoes = builder.getShoes();
        clothes = builder.getClothes();
        money = builder.getMoeny();
        house = builder.getHouse();
        car = builder.getCar();
        career = builder.getCareer();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", shoes='" + shoes + '\'' +
                ", clothes='" + clothes + '\'' +
                ", money='" + money + '\'' +
                ", house='" + house + '\'' +
                ", car='" + car + '\'' +
                ", career='" + career + '\'' +
                '}';
    }

    public static class Builder {
        private final String name;
        private final String gender;
        private String age;
        private String shoes;
        private String clothes;
        private String moeny;
        private String house;
        private String car;
        private String career;

        public Builder(String name,String gender){
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public String getAge() {
            return age;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public String getShoes() {
            return shoes;
        }

        public Builder setShoes(String shoes) {
            this.shoes = shoes;
            return this;
        }

        public String getClothes() {
            return clothes;
        }

        public Builder setClothes(String clothes) {
            this.clothes = clothes;
            return this;
        }

        public String getMoeny() {
            return moeny;
        }

        public Builder setMoeny(String moeny) {
            this.moeny = moeny;
            return this;
        }

        public String getHouse() {
            return house;
        }

        public Builder setHouse(String house) {
            this.house = house;
            return this;
        }

        public String getCar() {
            return car;
        }

        public Builder setCar(String car) {
            this.car = car;
            return this;
        }

        public String getCareer() {
            return career;
        }

        public Builder setCareer(String career) {
            this.career = career;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person person = new Person.Builder("lin","M").setAge("20").build();
        System.out.println(person);
    }

}
