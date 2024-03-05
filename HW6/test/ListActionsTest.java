import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

class ListActionsTest {
    ListsActions listsActions;
    ArrayList<Integer> smallerList;
    ArrayList<Integer> biggerList;
    ArrayList<Integer> emptyList;

    @BeforeEach
    void setup (){
        listsActions = new ListsActions();
        smallerList = new ArrayList<>();
        smallerList.add(2);
        smallerList.add(6);
        biggerList = new ArrayList<>();
        biggerList.add(2);
        biggerList.add(8);
        emptyList = new ArrayList<>();
    }

    @Test
    void getList1Test (){
        assertThat(listsActions.getList1()).isInstanceOf(ArrayList.class);
    }

    @Test
    void getList2Test (){
        assertThat(listsActions.getList2()).isInstanceOf(ArrayList.class);
    }

    @Test
    void findListAverageValueTest (){
        double res = listsActions.findListAverageValue(smallerList);

        assertThat(res).isEqualTo(4);
    }

    @Test
    void listsCompareReturnList1IsNullTest (){
        String str = listsActions.listsCompare(emptyList, biggerList);

        assertThat(str).isEqualTo("Список 1 пуст");
    }

    @Test
    void listsCompareReturnList2IsNullTest (){
        String str = listsActions.listsCompare(smallerList, emptyList);

        assertThat(str).isEqualTo("Список 2 пуст");
    }

    @Test
    void listsCompareReturnList1AverageIsMoreTest (){
        String str = listsActions.listsCompare(biggerList, smallerList);

        assertThat(str).isEqualTo("Первый список имеет большее среднее значение");
    }

    @Test
    void listsCompareReturnList2AverageIsMoreTest (){
        String str = listsActions.listsCompare(smallerList, biggerList);

        assertThat(str).isEqualTo("Второй список имеет большее среднее значение");
    }

    @Test
    void listsCompareReturnListsAverageAreEqualsTest (){
        String str = listsActions.listsCompare(smallerList, smallerList);

        assertThat(str).isEqualTo("Средние значения равны");
    }

    @Test
    void listFillTest (){
        listsActions.listFill(emptyList, 10);

        assertThat(emptyList.remove(0)).isEqualTo(10);
    }
}
