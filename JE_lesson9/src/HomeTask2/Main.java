package HomeTask2;

public class Main {
    public static void main(String[] args) {
        MyTreeMap myMap = new MyTreeMap();
        System.out.println("Created treeMap:\n" + myMap);

        System.out.println("\nisEmpty? - " + myMap.isEmpty());
        System.out.println("\nAdd elements");
        myMap.add("1", "fff");
        myMap.add("0", "bbb");
        myMap.add("3", "aaa");
        myMap.add("4", "ddd");
        System.out.println(myMap);
        System.out.println("\nisEmpty? - " + myMap.isEmpty());
        System.out.println("\nsize =  " + myMap.size());

        String key = "2";
        System.out.println("\nIs treeMap contains key " + key + "? " + myMap.containsKey(key));
        key = "4";
        System.out.println("\nIs treeMap contains key " + key + "? " + myMap.containsKey(key));

        System.out.println("\nGet value of entry with key = " + key + ". Result: " + myMap.get(key));


    }

}
