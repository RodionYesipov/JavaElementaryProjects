import java.util.HashMap;
import java.util.Map;

public class Result {
    public static void main(String[] args) {
        MyMap map = new MyHashMap();

        map.put("1", "asdf");
        map.put("A", "zzy");
        map.put("54", "zzz");
        map.put("2", "qwert");
        map.put("3", "zxcv");
        map.put(null, "zzz");
        System.out.println("\nOur map :\n" + map.toString());

        String key = "A";
        System.out.println("\nremove('" + key + "') returns '" + map.remove(key) + "'");
        System.out.println("\nOur map after remove():\n" + map.toString());
        System.out.println("\nSize = " + map.size());

        key = "1";
        System.out.println("\nget(" + key + ") = " + map.get(key));

        key = "2";
        System.out.println("\ncontainsKey(" + key + ") = " + map.containsKey(key));
        key = "66";
        System.out.println("\ncontainsKey(" + key + ") = " + map.containsKey(key));

        System.out.println("\nOur map:\n" + map.toString());
        System.out.println("\nisEmpty() = " + map.isEmpty());

        map.clear();
        System.out.println("\nOur map after clear():\n" + map.toString());
        System.out.println("\nisEmpty() = " + map.isEmpty());



        MySet set = new MyHashSet();
        set.add("asdf");
        set.add("qwer");
        set.add("zxcv");
        set.add("asdf");
        System.out.println("\n\n\nOur Set:\n" + set);

        String setItem = "as";
        System.out.println("\ncontains(" + setItem + ") = " + set.contains(setItem));
        setItem = "qwer";
        System.out.println("\ncontains(" + setItem + ") = " + set.contains(setItem));

        System.out.println("\nremove('" + setItem + "') returns '" + set.remove(setItem) + "'");
        System.out.println("\nOur set after remove():\n" + set.toString());
        System.out.println("\nSize = " + set.size());

        setItem = "aaa";
        System.out.println("\ncontains(" + setItem + ") = " + set.contains(setItem));
        setItem = "asdf";
        System.out.println("\ncontains(" + setItem + ") = " + set.contains(setItem));

        System.out.println("\nOur set:\n" + set.toString());
        System.out.println("\nisEmpty() = " + set.isEmpty());

        set.clear();
        System.out.println("\nOur set after clear():\n" + set.toString());
        System.out.println("\nisEmpty() = " + set.isEmpty());
    }
}
