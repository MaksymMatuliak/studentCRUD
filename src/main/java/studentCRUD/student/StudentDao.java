package studentCRUD.student;

import org.springframework.data.jpa.repository.JpaRepository;
import studentCRUD.student.impl.Student;

public interface StudentDao extends JpaRepository<Student, Long> {
}
