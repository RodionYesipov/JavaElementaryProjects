package enumLesson;

public class Test {
    public  static  void main (String[] args){
        Runnable rabbit = new Runnable() {
            @Override
            public void run() {
                System.out.println("I ");
            }
        };

        Rabbit rabbit2 = new Rabbit() {
            @Override
            public boolean eat(int food) {
                System.out.println("eaten "+food);
                return false;
            }
        };

        Rabbit rabbit3 = new Rabbit() {
            @Override
            public boolean eat(int food) {
                System.out.println("eaten "+food);
                return false;
            }
        };
    }

}
