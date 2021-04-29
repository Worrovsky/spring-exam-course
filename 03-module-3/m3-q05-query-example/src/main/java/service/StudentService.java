package service;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class StudentService {

    private StudentDao dao;

    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    public void doWork() {

        System.out.println("num row in DB: " + dao.getCount());

        try {
            String s = dao.runQueryForObjectButWithMultipleRows();
        } catch (DataAccessException e) {
            System.out.println("\nCatch exception for runQueryForObjectButWithMultipleRows():");
            System.out.println("\t" + e.getLocalizedMessage());
        }

        int id = 2;
        System.out.println("\nName for id= " + id + ": " + dao.getNameById(id));

        List<String> names = dao.getAllNames();
        System.out.println("\nGet all names: " + names);

        System.out.println("\nStudent with id = " + id + ": " + dao.getStudentById(id));

        System.out.println("\nAll students: " + dao.getAllStudents());

        int idOfNewStudent = dao.insertStudent("Bob", "bob@mail.de");
        System.out.println("\nAdd new student: " + dao.getAllStudents());
    }
}
