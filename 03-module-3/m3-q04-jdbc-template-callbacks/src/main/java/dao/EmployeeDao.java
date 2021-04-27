package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void usingRowMapper() {
        System.out.println("\n---- Row mapper example");
        List<String> names = jdbcTemplate.query(
                "select employee_id, first_name from employee",
                new RowMapper<String>() {

                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        int id = rs.getInt("employee_id");
                        String name = rs.getString("first_name");
                        System.out.println("row # " + rowNum + "/ id: " + id + "/ name: " + name);
                        return name;
                    }
                }
        );

        for (String name: names) {
            System.out.println("name: " + name);
        }
    }

    public void usingRowMapperWithLambda() {
        System.out.println("\n---- Row mapper (lambda) example");
        List<String> names = jdbcTemplate.query(
                "select employee_id, first_name from employee",
                (rs, rowNum) -> {
                    int id = rs.getInt("employee_id");
                    String name = rs.getString("first_name");
                    System.out.println("row # " + rowNum + "/ id: " + id + "/ name: " + name);
                    return name;
                }
        );

        for (String name: names) {
            System.out.println("name: " + name);
        }
    }

    public void totalSalaryWithRowCallbackHandler() {
        System.out.println("\n---- Row callback handler example");

        TotalSalaryRowCallbackHandler handler = new TotalSalaryRowCallbackHandler();
        jdbcTemplate.query("select salary from employee", handler);
        handler.report();
    }

    public void totalSalaryWithResultSetExtractor() {
        System.out.println("\n---- Result set extractor example");

        //noinspection ConstantConditions
        int total = jdbcTemplate.query("select salary from employee",
                new ResultSetExtractor<Integer>() {
                    @Override
                    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                        int total = 0;
                        while (rs.next()) {
                            total = total + rs.getInt("salary");
                        }

                        return total;
                    }
                });

        System.out.println("total salary: " + total);
    }

    public void totalSalaryWithResultSetExtractorWithLambda() {
        System.out.println("\n---- Result set extractor (lambda) example");

        //noinspection ConstantConditions
        int total = jdbcTemplate.query("select salary from employee",
                rs -> {
                    int totalSalary = 0;
                    while (rs.next()) {
                        totalSalary = totalSalary + rs.getInt("salary");
                    }

                    return totalSalary;
                });

        System.out.println("total salary: " + total);
    }
}
