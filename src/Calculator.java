import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать");
        getInput();
    }
    public static void processInput(String input) {
        String[] arr = input.split(" ");
        Integer int1, int2;
        boolean isFirstNumNumeric = false, isSecondNumNumeric = false;
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

        int result = switch (arr[1]) {
            case "*" -> int1 * int2;
            case "+" -> int1 + int2;
            case "/" -> int1 / int2;
            case "-" -> int1 - int2;
            default -> 0;
        };
        String romanianResult = "";
        if (isFirstNumNumeric && !isSecondNumNumeric || !isFirstNumNumeric && isSecondNumNumeric) {
            System.out.println("Произошла ошибка");
            return;
        }
        System.out.println("======================RESULT======================");
        if (!isFirstNumNumeric && !isSecondNumNumeric) {
            romanianResult = RomanNumerals(result);
            System.out.println(romanianResult);
        } else {
            System.out.println(result);
        }
    }

    public static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
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

    public static void getInput() {
        System.out.println("Введите операцию: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            processInput(s);
        }
    }

    public static int convert(String a) {
        if (a.equals("I")) return 1;
        if (a.equals("II")) return 2;
        if (a.equals("III")) return 3;
        if (a.equals("IV")) return 4;
        if (a.equals("V")) return 5;
        if (a.equals("VI")) return 6;
        if (a.equals("VII")) return 7;
        if (a.equals("VIII")) return 8;
        if (a.equals("IX")) return 9;
        if (a.equals("X")) return 10;
        return -1;
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