package Item58;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Numbers {

    public static List<Integer> getNumbers(){
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++){
            numbers.add(i);
        }
        return numbers;
    }

    public static void main(String[] args){

        // ConcurrentModificationException
        List<Integer> nums = getNumbers();
        try{
            for(int num : nums){
                if(num % 2 == 0){
                    nums.remove(num);
                }
            }
        }
        catch(ConcurrentModificationException e){
            System.out.println(nums);
        }

        
        /**
         * removeIf
         * Method was created for this
         * define the name of the variable in the for each loop
         * then have the predicate for what to remove
         */
        List<Integer> nums1 = getNumbers();
        nums1.removeIf(num -> num % 2 == 0);
        System.out.println(nums1);

        //Explicit Implementation
        List<Integer> nums2 = getNumbers();
        Iterator<Integer> iterator = nums2.iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            if(num % 2 == 0){
                iterator.remove();
            }
        }
        System.out.println(nums2);
    }
}
