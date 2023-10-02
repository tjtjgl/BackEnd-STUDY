package study.java8to11.interfaces;

public class PrintImpl implements Print, Show {

    String name;


    public PrintImpl(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printNameUpperCase() {
        System.out.println("재정의 name = " + getName().toUpperCase());
    }
}
