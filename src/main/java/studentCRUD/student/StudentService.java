package studentCRUD.student;

import java.util.List;
import studentCRUD.student.impl.Student;

public interface StudentService {
    void add(Student student);

    List<Student> getAllStudents();

    boolean delete(Long id);

    void changeMail(Long id, String mail);
}
