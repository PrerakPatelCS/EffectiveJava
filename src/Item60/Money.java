package Item60;

import java.math.BigDecimal;

public class Money {
    // Broken - uses floating point for monetary calculation!
    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);

        // Accurate but Slow
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought1 = 0;
        BigDecimal funds1 = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             funds1.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            funds1 = funds1.subtract(price);
            itemsBought1++;
        }
        System.out.println(itemsBought1 + " items bought.");
        System.out.println("Money left over: $" + funds1);

        // Accurate and Faster
        int itemsBought2 = 0;
        int funds2 = 100;
        for (int price = 10; funds2 >= price; price += 10) {
            funds2 -= price;
            itemsBought2++;
        }
        System.out.println(itemsBought2 + " items bought.");
        System.out.println("Cash left over: " + funds2 + " cents");
    }
}
