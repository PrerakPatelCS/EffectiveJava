package Annotation;

//This is our annotation we will be making
//@VeryImportant
public class Cat {

    @ImportantString
    String name;
    int age;

    public Cat(String name){
        this.name = name;
    }

    @RunImmediately(times = 3)
    public void test(){
        System.out.println("test");
    }

    public void eat(){
        System.out.println("Munch");
    }
}
