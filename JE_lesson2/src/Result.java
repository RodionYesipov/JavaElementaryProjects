public class Result {
    public static void main(String[] args) {
        IntList myList = new IntArrayList();
        int size = 10;
        System.out.println("new object myList: \n" + myList.toString());
        for (int i = 0; i < size; i++) {
            myList.add(i);
        }
        System.out.println("Added 10 elements:\n" + myList.toString());

        int index = 9;
        int element = 9;
        myList.add(index, element);
        System.out.println("Added element " + element + " in position " + index + "\n" + myList.toString());

        System.out.println("Get element in position " + index + "\n" + myList.get(index));

        index--;
        myList.remove(index);
        System.out.println("Remove element in position " + index + "\n" + myList.toString());

        myList.removeByValue(element);
        System.out.println("Remove element with value " + element + "\n" + myList.toString());

        index = 6;
        element += 3;
        myList.set(index, element);
        System.out.println("Set element in position " + index + " value " + element + "\n" + myList.toString());

        int fromIndex = 0;
        int toIndex = 6;
        System.out.println("Sublist from index = " + fromIndex + " to index = " + toIndex + "\n" + myList.subList(0, 6).toString());

        System.out.println("Is massive empty?\n" + myList.isEmpty());

        myList.clear();
        System.out.println("Clear massive:\n" + myList.toString());

        System.out.println("Is massive empty?\n" + myList.isEmpty());


    }
}
