package katacalc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String war = sc.nextLine();
        Calculate.calc(war);
    }
}

class Calculate {
    static int num1 = 0;
    static int num2 = 0;


    public static String calc(String input) throws Exception {

        String s = input;
        arifMethod(s);


        return "тестовое задание выполнено";

    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void arifMethod(String string) throws Exception {

        String[] stringsSplit = string.split(" ");

        if (stringsSplit.length < 3) {
            throw new Exception("вы ввели без пробелов");

        } else if (stringsSplit.length > 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        } else if (isDigit(stringsSplit[0]) == false && isDigit(stringsSplit[2]) == false) {
            num1 = converter2(stringsSplit[0]);
            num2 = converter2(stringsSplit[2]);
            if ((10 < num1 || num1 < 0) || (10 < num2 || num2 < 0)) {
                throw new Exception("числа должны быть больше 1 и меньше 10");
            }
            if (virajenie(num1, stringsSplit[1], num2) < 1)
                throw new Exception(" в римской системе нет отрицательных чисел  и нуля");
            System.out.println(converter3(virajenie(num1, stringsSplit[1], num2)));

        } else if (isDigit(stringsSplit[0]) == true && isDigit(stringsSplit[2]) == true) {
            System.out.println(virajenie(Integer.parseInt(stringsSplit[0]), stringsSplit[1], Integer.parseInt(stringsSplit[2])));
            if ((10 < Integer.parseInt(stringsSplit[0]) || Integer.parseInt(stringsSplit[0]) < 0) || (10 < Integer.parseInt(stringsSplit[2]) || Integer.parseInt(stringsSplit[2]) < 0)) {
                throw new Exception("числа должны быть больше 1 и меньше 10");
            }

        } else throw new Exception("используются одновременно разные системы счисления");
    }

    public static int virajenie(int num1, String znak, int num2) {
        String finish = null;
        int fin = 0;
        switch (znak) {
            case "+":
                finish = "" + (num1 + num2);
                break;
            case "-":
                finish = "" + (num1 - num2);
                break;
            case "/":
                finish = "" + (num1 / num2);
                break;
            case "*":
                finish = "" + (num1 * num2);
                break;


        }
        return Integer.parseInt(finish);
    }


    public static int converter2(String s2) throws Exception {
        int index = 0;
        String[] rom = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
                "C"};
        OUTER:
        for (int i = 0; i < rom.length; i++) {
            INNER:
            for (int j = 0; j < rom.length; j++) {
                if (s2.equals(rom[j])) {
                    index = j;
                    break OUTER;
                }
            }
            if (s2.equals(rom[i]) != true)
                throw new Exception(" в римской системе нет отрицательных чисел  и нуля !");
        }
        return index;
    }

    public static String converter3(int romNumerResult) {
        String[] rom = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
                "C"};
        return rom[romNumerResult];
    }

}

