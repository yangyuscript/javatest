package com.lin.lambda;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/6/10 16:46
 * @Modified By:
 **/
public class LambdaTest {

    public static void main(String[] args) {
        eat(new Person() {
            @Override
            public void eat() {
                System.out.println("common:person is eatting!");
            }
        });


        eat(()-> System.out.println("lambda:person is eatting!"));
    }

    public static void eat(Person person){
        person.eat();
    }
}
