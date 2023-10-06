package Item1;

public class Point {

    double x, y;
    enum Angle{
        Rad,
        Deg
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    private Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    // Polar Coordinates

    /**
     *
     * @param rho
     * @param phi
     * @param dummy : not used no reccommended
     */
    private Point(double rho, double phi, int dummy){
        this.x = rho * Math.cos(phi);
        this.y = rho * Math.sin(phi);
    }

    /**
     * Best Practice
     * @param rho
     * @param phi
     * @param unit
     */
    private Point(double rho, double phi, Angle unit){
        switch(unit){
            case Rad:
                this.x = rho * Math.cos(phi);
                this.y = rho * Math.sin(phi);
                break;
            case Deg:
                double phi1 = phi * Math.PI/180.0;
                this.x = rho * Math.cos(phi);
                this.y = rho * Math.sin(phi);
                break;
        }
    }

    /******* static Factory Methods *************/
    public static Point newCartesian(double x, double y){
        return new Point(x, y);
    }

    // Best Practice in Java
    public static Point newPolarDeg(double rho, double phi){
        return new Point(rho, phi, Angle.Deg);
    }

    public static Point newPolarRad(double rho, double phi){
        return new Point(rho, phi, Angle.Rad);
    }

}
