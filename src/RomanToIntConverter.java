import java.util.HashMap;
import java.util.Map;

public class RomanToIntConverter {

    public int romanToInt(String roman){
        int solution = 0;
        Map<String, Integer> romToIntMap = new HashMap<>();
        populateRomToIntMap(romToIntMap);

        char[] numeralArray = roman.toUpperCase().toCharArray();

        int previous = romToIntMap.get(String.valueOf(numeralArray[0]));
        int repeating = 0;
        int current = 0;
        
        for (int i = 0; i < numeralArray.length; i++) {
            repeating = calculateRepeating(roman.substring(i, roman.length()));
            current = romToIntMap.get(String.valueOf(numeralArray[i]));
            if (current == previous) {
                // Repetition
                solution += current*repeating;
            } else if (current < previous) {
                // Addition
                solution += current*repeating;
            } else {
                // Subtraction
                solution += current-previous*2;
            }
            i += repeating-1;
            previous = current;
        }

        return solution;
    }

    public void populateRomToIntMap(Map<String, Integer> map){
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public int calculateRepeating(String num){
        char[] arr = num.toCharArray();
        int repeatingNumeral = 0;
        char prevNum = arr[0];
        for (int i = 0; i < num.length(); i++) {
            if(prevNum == arr[i]){ repeatingNumeral++; }
            else break;
        }

        return repeatingNumeral;
    }
}
