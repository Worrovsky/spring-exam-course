package service;

import dao.StudentDao;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentService {

    private StudentDao dao;

    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void addWithTransaction() {
        System.out.println("\nAdd with transaction...");
        addStudents();
    }

    public void addWithoutTransaction() {
        System.out.println("\nAdd without transaction...");
        addStudents();
    }

    private void addStudents() {
        dao.save("student1", "email1");
        dao.save("student2", "email2");
        dao.saveWithWrongStatment("student3", "email3");
    }

    public void printStudents() {
        List<Student> students = dao.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void clear() {
        dao.clearStudents();
    }

}
