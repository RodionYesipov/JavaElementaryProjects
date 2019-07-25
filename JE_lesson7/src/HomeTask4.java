import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 4. Есть List объектов у каждого из которых 2 поля: int и String.
 Удалить те у которых значения int повторяются(оставить по одному из дубликатов).
* */
class ObjectFromList{
    int intField;
    String stringField;

    public ObjectFromList(int intField, String stringField) {
        this.intField = intField;
        this.stringField = stringField;
    }

    public ObjectFromList() {
    }

    public boolean equals(Object obj) {
        return  this.intField == intField;
    }

    @Override
    public String toString() {
        return "ObjectFromList{" +
                "intField=" + intField +
                ", stringField='" + stringField + '\'' +
                '}';
    }
}
//////////////////////

public class HomeTask4 {
    private static List<ObjectFromList> removeDuplicates(List<ObjectFromList> inList){
        for (int i = 0; i < inList.size(); i++) {
            for (int j = i + 1; j < inList.size() - 1; j++) {
                if(inList.get(i).equals(inList.get(j))){
                    inList.remove(j);
                    j--;
                }
            }
        }
        return inList;
    }

    public static void main(String[] args) {
        List<ObjectFromList> objectList = new ArrayList<>();
        //fill mylist with objects
        objectList.add(new ObjectFromList(1,"aaa"));
        objectList.add(new ObjectFromList(1,"bbb"));
        objectList.add(new ObjectFromList(2,"ccc"));
        objectList.add(new ObjectFromList(2,"ddd"));

        System.out.println("Out object list:\n" + objectList.toString());

        removeDuplicates(objectList);

        System.out.println("Object list after remove duplicates:\n" + objectList.toString());
    }
}
