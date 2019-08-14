package ClassTask2;

import java.util.Arrays;

/**
 List of K sorted arrays:
 [1,2,5]
 [2,3]
 [1,3,4,7]
 create iterator:
 [1,1,2,2,3,3,4,5,7]
**/
public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,5},
                {2,3},
                {1,3,4,7}
        };



       Iterator iterator = new Iterator(arr);
       int tmp;
       //EntryList entryList = new EntryList(arr);

    //    System.out.println(Arrays.asList(iterator.getList()));

       while(iterator.hasNext()) {
           System.out.println(iterator.next());
        }
    }
}
