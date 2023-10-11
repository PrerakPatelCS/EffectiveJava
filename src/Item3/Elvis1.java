package Item3;

// Singleton with static factory
public class Elvis1 {
    private static final Elvis1 INSTANCE = new Elvis1();
    private Elvis1() {  }
    public static Elvis1 getInstance() { return INSTANCE; }
    public void leaveTheBuilding() {  }
    /**
     * To defend against reflection attack can have the
     * constructor throw an Exception if it's asked to create a second instance
     *
     *If we use threads we will have many Elvis's so we need this
     *

    private Object readResolve() {
     * // Return the one true Elvis and let the garbage collector
     * // take care of the Elvis impersonator.
     *return INSTANCE;
     *}
     */
}