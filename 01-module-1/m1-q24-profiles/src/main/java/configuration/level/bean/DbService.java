package configuration.level.bean;

public interface DbService {
    public default void save() {
        System.out.println(getClass().getName() + ": save");
    }
}
