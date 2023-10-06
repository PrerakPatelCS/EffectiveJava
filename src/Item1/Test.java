package Item1;

public class Test {
    public static void main(String[] args){
        var p1 = Point.newCartesian(3.0, 4.0);
        System.out.println(p1);
        var p2 = Point.newPolarDeg(5.0, Math.atan2(4.0, 3.0));
        System.out.println(p2);
        var p3 = Point.newPolarDeg(5.0, Math.atan2(4.0, 3.0));
        System.out.println(p3);
    }
}
