package bean.method.level.services;

import bean.method.level.beans.Reporter;

public class CustomService {

    private final Reporter reporter;

    public CustomService(Reporter reporter) {
        this.reporter = reporter;
    }

    public void doWork() {
        reporter.report();
    }
}
