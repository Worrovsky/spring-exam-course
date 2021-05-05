package dao;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<String> getAllNames() {
        return jdbcTemplate.queryForList("select name from student", String.class);
    }

    public void save(String name, String email) {
        jdbcTemplate.update("insert into student (name, email) values(?, ?)", name, email);
    }

    public void saveWithWrongStatment(String name, String email) {
        jdbcTemplate.update("some wrong sql here", name, email);
    }

    public List<Student> getAllStudents() {
        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            return student;
        };

        return this.jdbcTemplate.query("select * from student", mapper);
    }

    public void clearStudents() {
        this.jdbcTemplate.update("delete from student");
    }

}
