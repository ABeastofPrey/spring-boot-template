package com.kuka.springtemplate;

public class Demo {
    public static void main(String[] args) {
        Person p = new Student();
        p.setName("Rockie");
        System.out.println(p.hello());
        p.run();
    }
}

interface IPerson {
    public String getName();
    public void setName(String name);
    public void run();
}

abstract class Person implements IPerson {
    protected String name;

    public Person() { }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void run() { System.out.println("Person.run"); }

    public abstract String hello();
}

class Student extends Person {
    private int score;

    public Student() { super(); }

    public int getScore() {return score; }

    public void setScore(int score) { this.score = score; }

    @Override
    public String hello() { return "Hello " + name; }

    @Override 
    public void run() { System.out.println("Student.run"); }
}