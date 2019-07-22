package classTask1;

public class Client implements CallBack {
    public void callback(int p){
        System.out.println("callback called with " + p);
    }

    public void doit(){
        System.out.println("doit");
    }
}
