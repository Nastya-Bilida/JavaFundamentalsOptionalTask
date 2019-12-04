import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int getCountsOfDigits(long number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    static int getDifferentDigitsCount(long number) {
        int differentDigitsCount = 0;
        int[] digitsCount = new int[10];
        while (number != 0) {
            digitsCount[(int) (number % 10)]++;
            number /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (digitsCount[i] > 0) differentDigitsCount++;
        }
        return differentDigitsCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Add size array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Add array number:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int minNumber = array[0];
        int maxNumber = array[0];
        int bigLength = getCountsOfDigits(array[0]);
        int smallLength = getCountsOfDigits(array[0]);
        int countDifferentDigits = getDifferentDigitsCount(array[0]);
        int minNumberWithDifferentDigitsCount = array[0];
        System.out.println("Your array number: " + Arrays.toString(array));

        for (int i = 1; i < size; i++) {
            if (countDifferentDigits > getDifferentDigitsCount(array[i])) {
                countDifferentDigits = getDifferentDigitsCount(array[i]);
                minNumberWithDifferentDigitsCount = array[i];
            }
        }
        System.out.println("Minimum  number with different digits - " + minNumberWithDifferentDigitsCount + " count: " + countDifferentDigits);

        for (int i = 1; i < size; i++) {
            if (bigLength < getCountsOfDigits(array[i])) {
                bigLength = getCountsOfDigits(array[i]);
                maxNumber = array[i];
            } else {
                smallLength = getCountsOfDigits(array[i]);
                minNumber = array[i];
            }
        }

        System.out.println("Max lenght number - " + bigLength + " , and number -  " + maxNumber);
        System.out.println("Min lenght number - " + smallLength + " , and number -  " + minNumber);
    }
}