package studentCRUD.student.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentCRUD.student.StudentDao;
import studentCRUD.student.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    public void add(Student student) {
        studentDao.save(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public boolean delete(Long id) {
        if (studentDao.existsById(id)) {
            studentDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void changeMail(Long id, String mail) {
        Student student = studentDao.findById(id).orElseThrow();
        student.setMail(mail);
    }
}
