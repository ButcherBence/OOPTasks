package task4_pizzas;

import java.util.Arrays;

public class Pizza {
    private String name;
    private String[] topping;
    private int preparationTime;
    private PizzaSize pizzaSize;

    public Pizza() {
    }

    public Pizza(String name, String[] topping, int preparationTime, PizzaSize pizzaSize) {
        this.name = name;
        this.topping = topping;
        this.preparationTime = preparationTime;
        this.pizzaSize = pizzaSize;
    }

    public Pizza(String line) {
        String[] pieces = line.split(";");
        this.name = pieces[0];
        this.topping = pieces[1].split(",");
        this.preparationTime = Integer.parseInt(pieces[2]);
        this.pizzaSize = PizzaSize.valueOf(pieces[3]);
    }

    public String getName() {
        return name;
    }

    public String[] getTopping() {
        return topping;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopping(String[] topping) {
        this.topping = topping;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", topping=" + Arrays.toString(topping) +
                ", preparationTime=" + preparationTime +
                ", pizzaSize=" + pizzaSize +
                '}';
    }
}
