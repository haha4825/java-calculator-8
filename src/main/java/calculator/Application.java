package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        String patternString = "^(//)(.)(\\\\n)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        while (matcher.find()) {
            String delimiter = matcher.group(2);
            if (delimiter.equals(".")) {
                throw new IllegalArgumentException(".은 허용되지 않는 구분자 입니다.");
            }
            delimiters.add(delimiter);
            input  = input.substring(matcher.end());
            matcher = pattern.matcher(input);
        }

        String finalDelimiter = String.join("|", delimiters);

        String[] numbers = input.split(finalDelimiter);

        double result = 0;

        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }
            try {
                double doubleValue = Double.parseDouble(number);
                if (doubleValue <= 0) {
                    throw new IllegalArgumentException();
                }
                result += doubleValue;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }
        System.out.println("결과 : " + result);
    }
}
