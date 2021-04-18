package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.beans.ReportType;
import spring.beans.Reporter;

@Service
public class CustomService {

    @Autowired
    @Qualifier("reporterImplNo1")
    private Reporter reporterFromQualifierWithDefaultName;

    @Autowired
    @Qualifier("custom-name-from-component-ann")
    private Reporter reporterFromQualifierWithNameFromComponentAnn;

    @Autowired
    @Qualifier("some-custom-qualifier")
    private Reporter reporterFromTwoQualifierAnnotations;

    @Autowired
    @ReportType(ReportType.ReportTypeMode.TYPE_2)
    private Reporter reporterFromCustomAnnotation;

    public void doWork() {
        reporterFromQualifierWithDefaultName.report();
        reporterFromQualifierWithNameFromComponentAnn.report();
        reporterFromTwoQualifierAnnotations.report();
        reporterFromCustomAnnotation.report();
    }
}
