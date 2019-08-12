package ClassTask2;
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
                {1,3,4,7},
                {1,3,4,7}
        };


        System.out.println(arr[1].length);
       /* Iterator iterator = new Iterator(arr);
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

    }
}
