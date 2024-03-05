import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Scanner scanner;
    Boolean work;
    ListsActions listsActions;

    public View (ListsActions listsActions){
        scanner = new Scanner(System.in);
        work = true;
        this.listsActions = listsActions;
    }

    public void start () {
        System.out.println("Доброго времени суток! Эта программа сравнивает средние значения двух списков чисел и выдает результат.");
        while (work) {
            printMenu();
            execute();
        }
    }

    void printMenu(){
        System.out.println("""
                1. Добавить числа в список 1
                2. Добавить числа в список 2
                3. Сравнить списки
                4. Посмотреть список чисел 1
                5. Посмотреть список чисел 2
                6. Завершить работу
                """);
    }

    void execute (){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (numCommand == 1){
                fillList(this.listsActions.getList1());
            }
            if (numCommand == 2){
                fillList(this.listsActions.getList2());
            }
            if (numCommand == 3){
                System.out.println(this.listsActions.listsCompare(this.listsActions.getList1(), this.listsActions.getList2()));
            }
            if (numCommand == 4){
                System.out.println(this.listsActions.getList1().toString());
            }
            if (numCommand == 5){
                System.out.println(this.listsActions.getList2().toString());
            }
            if (numCommand == 6){
                finish();
            }
        }
    }

    boolean checkTextForInt (String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            System.out.println("Похоже вы ввели букву");
            return false;
        }
    }

    void fillList (ArrayList<Integer> list){
        String line;
        boolean workFill = true;
        System.out.println("""
                Введите число для добавления в список.
                Если хотите завершить наполнение списка введите любую букву""");
        while (workFill){
            line = scanner.nextLine();
            if (checkTextForInt(line)){
                int num = Integer.parseInt(line);
                this.listsActions.listFill(list, num);
            }
            else workFill = false;
        }
    }

    void finish (){
        work = false;
    }

    void setScanner (Scanner scanner){
        this.scanner = scanner;
    }

    boolean getWork (){
        return work;
    }
}
