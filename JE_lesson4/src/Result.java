import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Result {

    public static void main(String[] args) {
        IntList myIntList = new IntLinkedList();
        int size = 10;
        System.out.println("new object myIntList: \n" + myIntList.toString());
        for (int i = 0; i < size; i++) {
            myIntList.add(i);
        }
        System.out.println("Added 10 elements:\n" + myIntList.toString());

        int index = 9;
        int element = 9;
        myIntList.add(index, element);
        System.out.println("Added element " + element + " in position " + index + "\n" + myIntList.toString());

        System.out.println("Get element in position " + index + "\n" + myIntList.get(index));

        index--;
        myIntList.remove(index);
        System.out.println("Remove element in position " + index + "\n" + myIntList.toString());

        myIntList.removeByValue(element);
        System.out.println("Remove element with value " + element + "\n" + myIntList.toString());

        index = 6;
        element += 3;
        myIntList.set(index, element);
        System.out.println("Set element in position " + index + " value " + element + "\n" + myIntList.toString());

        int fromIndex = 0;
        int toIndex = 6;
        System.out.println("Sublist from index = " + fromIndex + " to index = " + toIndex + "\n" + myIntList.subList(0, 6).toString());

        System.out.println("Is massive empty?\n" + myIntList.isEmpty());

        myIntList.clear();
        System.out.println("Clear massive:\n" + myIntList.toString());

        System.out.println("Is massive empty?\n" + myIntList.isEmpty());
        System.out.println("\n\n\n");

        //IntQueue

        IntQueue myIntQueue = new IntLinkedList();

        System.out.println("new object myIntQueue: \n" + myIntQueue.toString());
        for (int i = 0; i < size; i++) {
            myIntQueue.add(i);
        }
        System.out.println("Added 10 elements:\n" + myIntQueue.toString());

        System.out.println("remove() returns:\n" + myIntQueue.remove());
        System.out.println("Our array:\n" + myIntQueue.toString());
        System.out.println("element() returns:\n" + myIntQueue.element());

        //IntQueue

        IntStack myIntStack = new IntLinkedList();

        System.out.println("\n\n\nnew object myIntStack: \n" + myIntStack.toString());
        for (int i = 0; i < size; i++) {
            myIntStack.push(i);
        }
        System.out.println("Pushed 10 elements:\n" + myIntStack.toString());

        System.out.println("pop() returns:\n" + myIntStack.pop());
        System.out.println("Our array:\n" + myIntStack.toString());
        System.out.println("peek() returns:\n" + myIntStack.peek());


    }
}
