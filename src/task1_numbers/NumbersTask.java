package task1_numbers;

import java.util.*;

public class NumbersTask {

    private DataHandlerTask1 dataHandler;

    public NumbersTask() {
        dataHandler = new DataHandlerTask1();
    }

    /**
     * Példafeladat.
     * A fájl beolvasását végző metódus helyes megírása után a beolvasott adatok így érhetőek el.
     * A dataHandler.getNumbers() elvégzi a beolvasást, ha a lista még üres - lásd ott.
     */
    public void numbersFromFile() {
        List<Integer> numbers = dataHandler.getNumbers();

        System.out.println("A fájl tartalma:");

        int i = 0;
        for (; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }

        System.out.println(numbers.get(i));
    }

    /**
     * Add össze a fájlból beolvasott számokat!
     */
    public int sum() {
        List<Integer> numbers = dataHandler.getNumbers();
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    /**
     * Mekkora a fájlból beolvasott számok átlaga? Számítsd ki!
     */
    public double avg() {
        List<Integer> numbers = dataHandler.getNumbers();
        return (double) sum() / numbers.size();
    }

    /**
     * Hány különböző számjegyből áll az a szám, amely a beolvasott számokat tartalmazó lista adott indexén szerepel?
     * Számold össze, és térj vissza a megoldással!
     */
    public int countDifferentDigits(int index) {
        List<Integer> numbers = dataHandler.getNumbers();
        int num = numbers.get(index);
        Set<Integer> digits = new HashSet<>();
        if (num < 0) {
            num = Math.abs(num);
        }
        if (num != 0) {
            while (num > 0) {
                digits.add(num % 10);
                num = num / 10;
            }
        } else {
            return 1;
        }
        return digits.size();
    }

    /**
     * Hányszor szerepel az adott számjegy az összes számban?
     * Számold össze, és térj vissza a megoldással!
     */
    public int countDigit(int digit) {

        List<Integer> numbers = dataHandler.getNumbers();
        String digitAsString = Integer.toString(digit);
        int counter = 0;
        for (Integer number : numbers) {
            if (number < 0) {
                number = Math.abs(number);
            }
            String num = number.toString();
            int[] xs = new int[num.length()];
            for (int i = 0; i < xs.length; i++) {
                xs[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
            }
            for (int x : xs) {
                if (x == digit) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Hányszor szerepel az összes számjegy az összes számban?
     * Számold össze, és térj vissza a megoldással!
     */
    public Map<Integer, Integer> countAllDigits() {
        List<Integer> numbers = dataHandler.getNumbers();
        Map<Integer, Integer> counterMap = new HashMap<>();
        counterMap.put(0, 0);
        counterMap.put(1, 0);
        counterMap.put(2, 0);
        counterMap.put(3, 0);
        counterMap.put(4, 0);
        counterMap.put(5, 0);
        counterMap.put(6, 0);
        counterMap.put(7, 0);
        counterMap.put(8, 0);
        counterMap.put(9, 0);
        int counter = 0;
        for (int j = 0; j <= 10; j++) {
            for (Integer number : numbers) {
                if (number < 0) {
                    number = Math.abs(number);
                }
                String num = number.toString();
                int[] xs = new int[num.length()];
                for (int i = 0; i < xs.length; i++) {
                    xs[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
                }
                for (int x : xs) {
                    if (x == j) {
                        counter++;
                    }
                }
            }
            counterMap.put(j, counter);
            counter = 0;
        }

        return counterMap;
    }

}
