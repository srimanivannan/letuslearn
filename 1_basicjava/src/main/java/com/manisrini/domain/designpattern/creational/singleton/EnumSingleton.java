package com.manisrini.domain.designpattern.creational.singleton;

public class EnumSingleton {
    public static void main(String[] args) throws Exception {
    	
    	Class<?> c = Class.forName("com.cacheix.training.corejava.designpattern.Singleton1");
        Operation instance = Operation.class.cast(c.getEnumConstants()[0]);
        System.out.println(instance.getTHEAnswer());

        Class<?> c1 = Class.forName("com.cacheix.training.corejava.designpattern.Singleton1");
        Operation instance1 = Operation.class.cast(c1.getEnumConstants()[0]);
        System.out.println(instance1.getTHEAnswer());
        System.out.println(instance==instance1);
        
        c = Class.forName("com.cacheix.training.corejava.designpattern.Singleton2");
        instance = Operation.class.cast(c.getEnumConstants()[0]);
        System.out.println(instance.getTHEAnswer());
    	
    }
}
interface Operation {
    int getTHEAnswer();
}
enum Singleton1 implements Operation {
    INSTANCE;
    @Override
    public int getTHEAnswer() {
        return 42;
    }
}
enum Singleton2 implements Operation {
    INSTANCE;
    @Override
    public int getTHEAnswer() {
        return 84;
    }
}