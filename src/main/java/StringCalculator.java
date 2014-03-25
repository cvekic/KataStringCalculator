import java.util.ArrayList;
import java.util.List;
/**
 * Created by Mladjan on 24.3.2014.
 */
public class StringCalculator {

    public int add(String stringToParse) {
        if(stringToParse.isEmpty() || stringToParse.equals(null)) {
            return 0;
        }
       List<Integer> numbers = parseNumbers(stringToParse);

       return sum(numbers);
    }

    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

    private List<Integer> parseNumbers(String stringToParse) {
        stringToParse = normalizeString(stringToParse);
        List<Integer> numbers = new ArrayList<Integer>();
        for(String number: stringToParse.split(",")) {
            if(number.isEmpty()){
                continue;
            }
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private String normalizeString(String numbers) {
        if(numbers.startsWith("//")) {
            String delimiter = "" + numbers.charAt(2);
            numbers = numbers.substring(4);
            numbers = numbers.replaceAll(delimiter, ",");
        }
        numbers = numbers.replace("\\n", ",");
        return numbers;
    }
}
