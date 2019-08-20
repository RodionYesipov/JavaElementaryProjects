import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {

        User user = new User("Alex",22);
        System.out.println(user);
        user.changeValues("Ben",55);
        System.out.println(user);

    }
}
