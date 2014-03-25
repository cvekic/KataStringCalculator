import java.util.List;

/**
 * Created by Mladjan on 24.3.2014.
 */
public class StringCalculator {
    public int add(String numbers) {
        int sum = 0;
//        boolean negative = false;
//        List<Integer> negatives = null;
        String[] preparedString;
        if(numbers.isEmpty() || numbers.equals(null)) {
            return sum;
        }
        preparedString = numbers.split("\\D+");
        for(String digitString: preparedString ) {
            if(digitString.equals(null) || digitString.isEmpty() || Integer.parseInt(digitString) > 999) {
                continue;
            }
//            if (digitString.equals("-")){
//                negative = true;
//                continue;
//            }
//            if(negative == true) {
//                negative = false;
//                negatives.add(Integer.parseInt(digitString));
//                continue;
//            }
            sum += Integer.parseInt(digitString);
        }
//        if(negatives != null) {
//            System.out.println("Negativ numbers will not be used!");
//            for(Integer i : negatives) {
//                System.out.println(i);
//            }
//        }
        return sum;
    }
}
