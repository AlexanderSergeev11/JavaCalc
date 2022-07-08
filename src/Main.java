import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Калькулятор");
        getInput();
    }
    static void processInput(String input) {
        int[] myArray = new int[1];
        Scanner sc = new Scanner(System.in);
        String[] arr = input.split(" ");
        int int1, int2;
        int int3 = 0;
        String operation = null;
        boolean isFirstNumNumeric = false, isSecondNumNumeric = false;
        if(arr.length > 3){
            throw new IllegalArgumentException("Количество аргументов должно равно 2");
        }
        if (isNumeric(arr[0])) {
            int1 = Integer.parseInt(arr[0]);
            isFirstNumNumeric = true;
        } else {
            int1 = convert(arr[0]);
        }
        if (isNumeric(arr[2])) {
            int2 = Integer.parseInt(arr[2]);
            isSecondNumNumeric = true;
        } else {
            int2 = convert(arr[2]);
        }
        int result = 0;
        switch (arr[1]) {
            case "-":
                result = int1 - int2;
                break;
            case "+":
                result = int1 + int2;
                break;
            case "*":
                result = int1 * int2;
                break;
            case "/":
                try {
                    result = int1 / int2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception" + e);
                    throw new ArithmeticException("Деление на ноль не осуществляется");
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }

        String romanianResult = "";
        try {
            if (isFirstNumNumeric && !isSecondNumNumeric || !isFirstNumNumeric && isSecondNumNumeric) {
                System.out.println("Произошла ошибка");
                Integer.parseInt("Нет такой операции");
                return;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка,используются разные системы счисления");
        }

        while (int1 > 10 || int2 > 10) {
            System.out.println("Число больше 10. Повторите еще раз");
            getInput();
            return;

        }
        if (result < 0){
            throw new IllegalArgumentException("Римское число не может быть отрицательным");
        }
        System.out.println("======================RESULT======================");
        if (!isFirstNumNumeric && !isSecondNumNumeric) {
            romanianResult = RomanNumerals(result);
            System.out.println(romanianResult);
        } else {
            System.out.println(result);
        };
    }

    static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
            int matches = Int / entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }
    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    static void getInput() {
        try {
            System.out.println("Введите операцию: ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                processInput(s);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    static int convert(String a) {
        if (a.equals("I")) return 1;
        if (a.equals("II")) return 2;
        if (a.equals("III")) return 3;
        if (a.equals("IV")) return 4;
        if (a.equals("V")) return 5;
        if (a.equals("VI")) return 6;
        if (a.equals("VII")) return 7;
        if (a.equals("VIII")) return 8;
        if (a.equals("IX")) return 9;
        if (a.equals("X")) {
            return 10;
        } else {
            throw new NumberFormatException("Вы ввели отрицательное или больше 10 римское число");
        }
    }
    private static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}