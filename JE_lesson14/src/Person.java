public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void shout(){
        System.out.println("AAAAAaaaaa!!!!");
    }

    void run(){
        System.out.println("Run run run...");
    }

    void speak(){
        System.out.println("Bla-bla-bla...");
    }
}
