package springboot.beans;

public interface Recorder {
    public default void record() {
        System.out.println(getClass().getName() + ": record done");
    }
}
