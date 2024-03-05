import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ViewTest {
    View view;
    View viewMock;
    View viewFull;
    ListsActions mockListsActions;
    ListsActions listsActions;
    Scanner scannerMock;

    @BeforeEach
    void setup (){
        mockListsActions = mock(ListsActions.class);
        listsActions = new ListsActions();
        view = new View(mockListsActions);
        viewFull = new View(listsActions);
        viewMock = mock(View.class);
        scannerMock = mock(Scanner.class);
    }

    @Test
    void startTest () {
        viewFull.setScanner(scannerMock);
        when(scannerMock.nextLine()).thenReturn("6");

        viewFull.start();

        assertThat(viewFull.getWork()).isFalse();
    }

    @Test
    void printMenuTest (){
        viewMock.printMenu();

        verify(viewMock).printMenu();
    }

    @Test
    void executeTest (){
        viewFull.setScanner(scannerMock);
        when(scannerMock.nextLine()).
                thenReturn("1").
                thenReturn("j");

        viewFull.execute();

        when(scannerMock.nextLine()).
                thenReturn("2").
                thenReturn("j");

        viewFull.execute();

        when(scannerMock.nextLine()).
                thenReturn("3").
                thenReturn("j");

        viewFull.execute();

        when(scannerMock.nextLine()).
                thenReturn("4").
                thenReturn("j");

        viewFull.execute();

        when(scannerMock.nextLine()).
                thenReturn("5").
                thenReturn("j");

        viewFull.execute();

        when(scannerMock.nextLine()).
                thenReturn("6").
                thenReturn("j");

        viewFull.execute();

        assertThat(viewFull.getWork()).isFalse();
    }

    @Test
    void checkTextForIntTrueTest (){
        String str = "2";

        boolean res = view.checkTextForInt(str);

        assertThat(res).isTrue();
    }

    @Test
    void checkTextForIntFalseTest (){
        String str = "some string";

        boolean res = view.checkTextForInt(str);

        assertThat(res).isFalse();
    }

    @Test
    void fillListTest (){
        ArrayList<Integer> list = new ArrayList<>();
        viewFull.setScanner(scannerMock);
        when(scannerMock.nextLine()).thenReturn("1").thenReturn("f");

        viewFull.fillList(list);

        assertThat(list.get(0)).isEqualTo(1);
    }

    @Test
    void finish (){
        view.finish();

        assertThat(view.getWork()).isFalse();
    }
}
