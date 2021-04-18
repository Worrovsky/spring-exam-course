package bean.method.level.beans;

public interface Reporter {
    public default void report() {
        System.out.println(getClass().getName() + ": report done!");
    }
}
