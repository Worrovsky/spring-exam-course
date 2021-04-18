package component.level.bean;

public interface ServiceInterface {
    public default void doWork() {
        System.out.println(getClass().getName() + ": work done!");
    }
}
