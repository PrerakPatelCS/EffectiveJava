package Item18;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        InstrumentedSet<Integer> set = new InstrumentedSet<>(new TreeSet<>());
        for(int i = 0; i < 100; i++){
            set.add(i);
        }
        for(int i = 0; i < 100; i++){
            set.add(i);
        }
        // 200 since there are 200 calls to set even though the set is size 100
        System.out.println(set.getAddCount());
    }
}
