package task4_pizzas;

import java.util.ArrayList;
import java.util.List;

public class PizzaTask {

    private DataHandlerTask4 dataHandler;

    public PizzaTask() {
        dataHandler = new DataHandlerTask4();
    }

    /**
     * Példafeladat.
     * A fájl beolvasását végző metódus helyes megírása után a beolvasott adatok így érhetőek el.
     * A dataHandler.getPizzas() elvégzi a beolvasást, ha a lista hossza 0 - lásd ott.
     */
    public void dataFromFile() {
        List<Pizza> pizzas = dataHandler.getPizzas();

        System.out.println("A fájl tartalma:");

        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
    }

    /**
     * Hány percig tartana elkészíteni adott pizzákat?
     * Add össze a bemeneti paraméterként kapott pizzák elkészítési idejét,
     * és térj vissza az eredménnyel!
     */
    public int sumPreparationTime(String... pizzaNames) {
        int sum = 0;
        List<Pizza> pizzas = dataHandler.getPizzas();
        for (Pizza pizza : pizzas){
         for (String pizzaName : pizzaNames){
             if (pizza.getName().equalsIgnoreCase(pizzaName)){
                 sum += pizza.getPreparationTime();
             }
         }
        }
        return sum;
    }

    /**
     * Gyűjtsd össze azokat a pizzákat, amelyek rendelhetőek az adott méretben!
     */
    public List<Pizza> findPizzasBySize(PizzaSize size) {
        List<Pizza> pizzas = dataHandler.getPizzas();
        List<Pizza> pizzaBySize = new ArrayList<>();
        for (Pizza pizza : pizzas){
            if (pizza.getPizzaSize().equals(size)){
                pizzaBySize.add(pizza);
            }
        }
        return pizzaBySize;
    }

    /**
     * Gyűjtsd össze azokat a pizzákat, amelyeken megtalálható az adott feltét!
     *
     * A feltétnél teljes egyezés szükséges.
     * Például van hagyma és lilahagyma. Ha a keresett feltét a "hagyma",
     * akkor a lilahagymás feltétű pizza NE kerüljön bele a listába.
     */
    public List<Pizza> findPizzasWithTopping(String topping) {
        List<Pizza> pizzas = dataHandler.getPizzas();
        List<Pizza> pizzaByTopping = new ArrayList<>();
        for (Pizza pizza : pizzas){
            String[] pizzatops = pizza.getTopping();
            for (String pizzatop : pizzatops){
                if (pizzatop.equalsIgnoreCase(topping)){
                    pizzaByTopping.add(pizza);
                }
            }
        }
        return pizzaByTopping;
    }

}
