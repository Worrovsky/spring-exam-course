
public class SpringBeanNo2 {

    private String field;

    public String getField() {
        return field;
    }

    public SpringBeanNo2() {
        this.field = "field from " + getClass().getName();
    }
}
