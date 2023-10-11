package Item2.Hierarchy;

import static Item2.Hierarchy.NyPizza.Size.*;
import static Item2.Hierarchy.Pizza.Topping.*;

public class Main {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        System.out.println(pizza);
        System.out.println(calzone);
    }
}
