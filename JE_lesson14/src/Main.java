import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        Person person = new Person();
        String methodName;
        System.out.println("Call all the methods of class " + personClass.getName());
        for (int i = 0; i < methods.length; i++) {
            methodName = methods[i].getName();
            System.out.println("Call method " + methodName + ": ");
            methods[i].invoke(person);
        }
    }
}
