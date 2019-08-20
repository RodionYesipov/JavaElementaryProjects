import java.lang.reflect.Field;

public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void changeValues(String newName, int newAge){
        Class userClass = this.getClass();
        Field[] fields = userClass.getDeclaredFields();
        Field field;


        for (int i = 0; i < fields.length; i++) {
            if(fields[i].getName().equals("name")){
                try {
                    fields[i].set(this,newName);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if(fields[i].getName().equals("age"))
                try {
                    fields[i].set(this,newAge);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
