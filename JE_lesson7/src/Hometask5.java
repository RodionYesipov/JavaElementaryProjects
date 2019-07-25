import java.util.ArrayList;
import java.util.List;
/**
 * 5. Есть фрагмент кода, который при запуске выдает ошибку NullPointerException. Найдите и исправьте ошибку:
 * **/


public class Hometask5 {
    private static class Ball {
    }

    private static class Board {
        private List balls;


        public Board() {
            List balls = new ArrayList<>();
            balls.add(new Ball());
            balls.add(new Ball());
            balls.add(new Ball());

            this.balls = balls;
        }

        public int count() {
            return balls.size();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.count());
    }
}