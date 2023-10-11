package Item61;

import java.util.Comparator;

public class BoxedPrimitives {
    // Broken comparator - can you spot the flaw?

    public static void main(String[] args){
        /**
         * Integer constructor has been degraded this uses a
         * static factory method, unfortunately it does not create
         * a new object Integer it gets unboxed
         * so this works correctly
          */

        Comparator<Integer> naturalOrder =
                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
        int result = naturalOrder.compare(Integer.valueOf(42), Integer.valueOf(42));
        System.out.println(result);

        Integer example = null;
        try{
            if(example == 42){
                System.out.println("Unbelievable");
            }
        }
        catch(NullPointerException e){
            System.out.println("Unboxing i from null is NPE");
        }

        // Hideously slow program! Can you spot the object creation?
        // Constant boxing and unboxing Long from Long to long makes this 10x slower
        Long sum = 0L;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        System.out.println(sum);


        long sum1 = 0;
        startTime = System.currentTimeMillis();
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum1 += i;
        }
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        System.out.println(sum);

        /**
         * Elapsed time: 4629 milliseconds
         * Elapsed time: 474 milliseconds
         */
    }
}
