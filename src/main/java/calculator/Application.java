package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] split = input.split("[:|,]");

        for (String s : split) {
            System.out.println(s);
        }
    }
}
