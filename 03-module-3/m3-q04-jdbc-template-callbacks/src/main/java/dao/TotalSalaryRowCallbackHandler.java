package dao;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalSalaryRowCallbackHandler implements RowCallbackHandler {

    private int totalSalary;

    @Override
    public void processRow(ResultSet rs) throws SQLException {

        int currentSalary = rs.getInt("salary");
        totalSalary = totalSalary + currentSalary;

    }

    public void report() {
        System.out.println("total salary: " + totalSalary);
    }
}
