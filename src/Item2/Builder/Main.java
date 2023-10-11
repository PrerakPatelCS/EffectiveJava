package Item2.Builder;

public class Main {
    public static void main(String[] args) {
        // They all return a builder and add to the builder so you can chain them
        // This is Fluent API
        // NutritionFacts is immutable and all  default values are in one place
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);
    }
}
