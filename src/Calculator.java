import java.util.Scanner;
import java.util.HashMap;

public class Calculator {
    static HashMap<String, Integer> romanianToInteger = new HashMap<String, Integer>();
    public static void main(String[] args) {
        fillMap();
        System.out.println("Добро пожаловать");
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("Результат: "+result);
    }
    public static void fillMap() {
        romanianToInteger.put("I", 1);
        romanianToInteger.put("II", 2);
        romanianToInteger.put("III", 3);
        romanianToInteger.put("IV", 4);
        romanianToInteger.put("V", 5);
        romanianToInteger.put("VI", 6);
        romanianToInteger.put("VII", 7);
        romanianToInteger.put("VIII", 8);
        romanianToInteger.put("IX", 9);
        romanianToInteger.put("X", 10);
    }
    public static int getInt(){
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int num;
        if(scanner.hasNextLine()){
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                num = convert(scanner.nextLine());
            }
        } else {
            System.out.println("Вы допустили ошибку. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }
    public static int convert(String a) {
        Integer num = romanianToInteger.get(a);
        return num;
    }
    public static char getOperation() {
        System.out.println("Введите операцию:");
        Scanner scanner = new Scanner(System.in);
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
            }

        }
        return result;
    }
}
