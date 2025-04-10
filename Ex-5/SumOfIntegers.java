// File: SumOfIntegers.java
import java.util.*;

public class SumOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers separated by spaces: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        ArrayList<Integer> intList = new ArrayList<>();

        for (String num : numbers) {
            intList.add(Integer.parseInt(num)); // Autoboxing
        }

        int sum = 0;
        for (Integer i : intList) {
            sum += i; // Unboxing
        }

        System.out.println("Sum of numbers: " + sum);
    }
}
