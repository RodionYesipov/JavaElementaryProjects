package ClassTask2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Iterator {

    private final int[][] arr;
    private int index = -1;
    private List<Integer> list;

    public Iterator(int[][] arr) {
        List<Integer> fullList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                fullList.add(arr[i][j]);
            }
        }

        Collections.sort(fullList);
        this.list = fullList;
        this.arr = arr;
    }

    public boolean hasNext() {
        if(index >= list.size() - 1){
            return false;
        } else {
            index++;
            return true;
        }
    }

    public int next() {
        if(index >= list.size()){
            return -1;
        } else {
            //index++;
            return list.get(index);
        }
    }

    public List<Integer> getList() {
        return list;
    }
}