package task2_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * A programming_languages.txt fájlban szereplő adatok forrása: https://programminglanguages.info/languages-by-year/
 *
 * A programming_languages.txt fájl programozási nyelvek nevét és a megjelenésük évszámát tartalmazza.
 * Az adatok egy sorban vesszővel ( , ) vannak elválasztva.
 *
 * Olvasd be a fájl tartalmát, és tárold ebben az osztályban, a languages nevű Map-ben, méghozzá az évszám szerint
 * csoportosítva a különböző programozási nyelvek nevét!
 *
 * Ezután oldd meg a ProgrammingTask osztályban lévő feladatokat. A feladatok megoldásában használd a languages Map-et.
 *
 * Ellenőrizd a megoldásaidat a test mappában lévő tesztek futtatásával! (task2_programming.ProgrammingTaskTest)
 *
 * A már megírt programkód használható, átírása nem javasolt.
 */
public class DataHandlerTask2 {

    private static final String SEPARATOR = ",";

    private Map<Integer, List<String>> languages;

    public Map<Integer, List<String>> getLanguages() {
        if (languages == null) {
            loadData();
        }

        return languages;
    }

    public void loadData() {
        languages = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\bence\\IdeaProjects\\OOPTasks\\src\\task2_programming\\programming_languages.txt"));
            String line;
            while ((line = br.readLine()) != null){
            String[] pieces = line.split(SEPARATOR);
            languages.putIfAbsent(Integer.valueOf(pieces[1]),new ArrayList<>());
            languages.get(Integer.parseInt(pieces[1])).add(pieces[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
