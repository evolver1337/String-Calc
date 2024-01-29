import java.util.Scanner;

public class StringCalc {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        char action;
        String[] data;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (data[0].length() > 10 || data[0].length() < 1 || data[1].length() > 10 || data[1].length() < 1) {
            throw new Exception("Введите от 1 до 10 символов");
        }
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            if (multiplier < 1 || multiplier > 10){
                throw new Exception("Введите значение от 1 до 10");
            }
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            printInQuotes(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                throw new Exception("Введите значение от 1 до 10");
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printInQuotes(result);
            }
        } else {
            int x = Integer.parseInt(data[1]);
            if (x < 1 || x > 10){
                throw new Exception("Введите значение от 1 до 10");
            }
            else {
                int newLen = data[0].length() / x;
                String result = data[0].substring(0, newLen);
                printInQuotes(result);
            }
        }

    }

    static void printInQuotes(String text) {
        if (text.length() > 40) {
            String rez = text.substring(0, 40);
            System.out.println("\"" + rez + "...\"");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }
}
