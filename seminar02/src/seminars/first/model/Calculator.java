package seminars.first.model;

import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int firstOperand = getOperand();
//        int secondOperand = getOperand();
//        char operator = getOperator();
//        int result = calculation(firstOperand, secondOperand, operator);
//        System.out.println("Operation result is: " + result);

//        System.out.println(calculatingDiscount(-100, 25));

    }

    public static char getOperator() {
        System.out.println("Enter operation: ");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public static int getOperand() {
        System.out.println("Enter operand: ");
        int operand;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("You have mistaken, try again");
            if (scanner.hasNext()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Input error");
            }
        }
        return operand;
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double number) {
        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        }
        while ((t - squareRoot) != 0);
        return squareRoot;
    }

    /**
     * Дз 1
     * Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
     * Примерная сигнатура и тело метода:
     *
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return результат
     */

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        double discountedAmount = 0;

        if (purchaseAmount >= 0) {

            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
            } else {
                throw new ArithmeticException("Скидка должна быть в диапазоне от 0 до 100%");
            }
        } else {
            throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        }

        return discountedAmount;
    }

    /**
     * Задание 2 лекции: Добавьте функцию возведения в степень в калькулятор и протестируйте
     */
    public static int pow(int value, int powValue) {
        int result = 1;

        for (int a = 1; a <= powValue; a++) {
            if (a == 0) return 1;
            result = result * value;

        }
        return result;
    }
}