import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
/**
 1.) Есть документ со списком URL:
 https://drive.google.com/open?id=1wVBKKxpTKvWwuCzqY1cVXCQZYCsdCXTl
 Вывести топ 10 доменов которые встречаются чаще всего. В документе могут встречается пустые и недопустимые строки.
* */
public class HomeTask1 {
    private static List<Map.Entry<String, Integer>> fileToHashSet(String filePath) {
        String site;
        Map<String, Integer> myMap = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            try {
                String getLine;
                while ((getLine = br.readLine()) != null) {
                    if (getLine.indexOf("/") < 0) {
                        site = getLine.trim();
                    } else {
                        site = getLine.substring(0, getLine.indexOf("/"));
                        site = site.trim();
                    }
                    if (!myMap.containsKey(site)) {
                        myMap.put(site, 1);
                    } else {
                        myMap.put(site, myMap.get(site) + 1);
                    }
                }

            } finally {
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(myMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return (List<Map.Entry<String, Integer>>) list;
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/Rodion/IdeaProjects/JE_lesson9/src/urls.txt";
        List<Map.Entry<String, Integer>> list = fileToHashSet(filePath);

        int top = 10;
        System.out.println("Top " + top + " sites:");
        for (int i = 0; i < top; i++) {
            System.out.println(list.get(i).getKey() + "  count = " + list.get(i).getValue());
        }

    }
}
