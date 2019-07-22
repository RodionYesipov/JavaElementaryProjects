import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class schoolTask1 {
    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));
        List<Integer> list = new ArrayList<>();
        //List<Integer> list2 = new IntArrayList<>();
        IntList myList = new IntArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
