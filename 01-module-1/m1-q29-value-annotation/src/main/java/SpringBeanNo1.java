import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class SpringBeanNo1 {

    @Value("Some value from @Value")
    private String stringValue;

    @Value("314")
    private int integerValue;

    private String fieldToInjectFromMethodNo1, fieldToInjectFromMethodNo2, fieldToInjectFromMethodNo3;

    @Value("value from method")
    private void setFields(String field1
            , String field2
            , @Value("value from param") String field3) {
        this.fieldToInjectFromMethodNo1 = field1;
        this.fieldToInjectFromMethodNo2 = field2;
        this.fieldToInjectFromMethodNo3 = field3;
    }

    @Value("#{3*4-1}")
    private int spelIntValue;

    @Value("${app.some.property}")
    String appSomeProperty;

    @Value("${app.no.such.property:no-such-property-default}")
    String noSuchProperty;

    @Value("#{beanNo2.field}")
    String valueFromOtherBean;

    @Value("1, ab, 3")
    List<String> valueList;

    @Value("${app.value.list}")
    List<Integer> integerListFromProperties;

    @Override
    public String toString() {
        return "SpringBeanNo1{" +
                "stringValue='" + stringValue + '\'' +
                ", integerValue=" + integerValue +
                ", fieldToInjectFromMethodNo1='" + fieldToInjectFromMethodNo1 + '\'' +
                ", fieldToInjectFromMethodNo2='" + fieldToInjectFromMethodNo2 + '\'' +
                ", fieldToInjectFromMethodNo3='" + fieldToInjectFromMethodNo3 + '\'' +
                ", spelIntValue=" + spelIntValue +
                ", appSomeProperty='" + appSomeProperty + '\'' +
                ", noSuchProperty='" + noSuchProperty + '\'' +
                ", valueFromOtherBean='" + valueFromOtherBean + '\'' +
                ", valueList=" + valueList +
                ", integerListFromProperties=" + integerListFromProperties +
                '}';
    }

}
