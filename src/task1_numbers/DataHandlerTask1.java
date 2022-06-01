package task1_numbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A numbers.txt fájl egész számokat tartalmaz.
 *
 * Olvasd be a fájl tartalmát, és tárold ebben az osztályban, a numbers nevű listában!
 *
 * Ezután oldd meg a NumbersTask osztályban lévő feladatokat. A feladatok megoldásában használd a numbers listát.
 *
 * Ellenőrizd a megoldásaidat a test mappában lévő tesztek futtatásával! (task1_numbers.NumbersTaskTest)
 *
 * A már megírt programkód használható, átírása nem javasolt.
 */
public class DataHandlerTask1 {

    private List<Integer> numbers;

    public DataHandlerTask1() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        if (numbers.size() == 0) {
            loadFromFile();
        }

        return numbers;
    }

    public void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\bence\\IdeaProjects\\OOPTasks\\src\\task1_numbers\\numbers.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
