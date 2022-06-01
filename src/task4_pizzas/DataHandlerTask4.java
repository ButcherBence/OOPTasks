package task4_pizzas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A pizzas.txt fájl pizzák adatait tartalmazza. Az adatok pontosvesszővel vannak elválasztva ( ; )
 * - kivéve a feltéteket: azok vesszővel ( , ).
 * A fájl az alábbi adatokat tartalmazza egy-egy pizzáról:
 *      név
 *      feltétek (vesszővel elválasztva)
 *      elkészítési idő (percben)
 *      méret
 *          enum, értéke lehet: SMALL, MEDIUM, LARGE, EXTRA_LARGE
 *
 * Valósítsd meg a Pizza osztályt! Hozd létre a megfelelő fieldeket, konstruktorokat, gettereket és settereket,
 * hogy a fájlban lévő sorokat objektumként tudd kezelni.
 *
 * Valósítsd meg a PizzaSize enumot is!
 *
 * Olvasd be a fájl tartalmát, és a fájl soraiból létrehozott Pizza objektumokat tárold ebben az osztályban, a pizzas nevű listában!
 *
 * Ezután oldd meg a PizzaTask osztályban lévő feladatokat. A feladatok megoldásában használd a pizzas listát.
 *
 * Ellenőrizd a megoldásaidat a test mappában lévő tesztek futtatásával! (task4_pizzas.PizzaTaskTest)
 *
 * A már megírt programkód használható, átírása nem javasolt.
 */
public class DataHandlerTask4 {

    private static final String MAIN_SEPARATOR = ";";
    private static final String SECONDARY_SEPARATOR = ",";

    private List<Pizza> pizzas;

    public DataHandlerTask4() {
        pizzas = new ArrayList<>();
    }

    public List<Pizza> getPizzas() {
        if (pizzas.size() == 0) {
            loadData();
        }

        return pizzas;
    }

    public void loadData() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\bence\\IdeaProjects\\OOPTasks\\src\\task4_pizzas\\pizzas.txt"));
            String line;
            while ((line = br.readLine()) != null){
                Pizza pizza = new Pizza(line);
                pizzas.add(pizza);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
