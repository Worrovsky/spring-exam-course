package dao;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.util.List;

public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public Integer getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from student", Integer.class);
    }

    public String runQueryForObjectButWithMultipleRows() {
        return this.jdbcTemplate.queryForObject("select name from student", String.class);
    }

    public String getNameById(int id) {
        return this.jdbcTemplate.queryForObject("select name from student where id = ?", String.class, id);
    }

    public List<String> getAllNames() {
        return this.jdbcTemplate.queryForList("select name from student", String.class);
    }

    public Student getStudentById(int id) {
        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            return student;
        };

        return this.jdbcTemplate.queryForObject("select * from student where id = ?", mapper, id);
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

    public int insertStudent(String name, String email) {
        return this.jdbcTemplate.update("insert into student(name, email) values (?, ?)", name, email);
    }

    public void test() {

    }
}
