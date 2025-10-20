package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String patternString = "^(//)(.)(\\\\n)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        List<Character> delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(':');

        while (matcher.find()) {
            String delimiter = matcher.group(2);
            delimiters.add(delimiter.charAt(0));
            input  = input.substring(matcher.end());
            matcher = pattern.matcher(input);
        }

        for (char delimiter : delimiters) {
            System.out.println(delimiter);
        }
        System.out.println("계산할 문자열: " + input);
    }
}
