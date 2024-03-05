import java.util.ArrayList;

public class ListsActions {
    ArrayList<Integer> list1;
    ArrayList<Integer> list2;

    public ListsActions(){
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
    }

    void listFill(ArrayList<Integer> list, Integer num){
        list.add(num);
    }

    ArrayList<Integer> getList1(){
        return list1;
    }

    ArrayList<Integer> getList2(){
        return list2;
    }

    double findListAverageValue (ArrayList<Integer> list){
        double res = 0.0;
        for (Integer integer : list) {
            res = res + integer;
        }
        res = res / list.size();
        return res;
    }

    String listsCompare (ArrayList<Integer> list1, ArrayList<Integer> list2){
        if (list1.isEmpty()) return "Список 1 пуст";
        if (list2.isEmpty()) return "Список 2 пуст";
        if (findListAverageValue(list1) > findListAverageValue(list2)) return "Первый список имеет большее среднее значение";
        if (findListAverageValue(list1) < findListAverageValue(list2)) return "Второй список имеет большее среднее значение";
        else return "Средние значения равны";
    }
}
