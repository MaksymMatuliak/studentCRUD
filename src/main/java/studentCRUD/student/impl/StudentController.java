package studentCRUD.student.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createStudent(@RequestBody Student student) {
        studentService.add(student);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @DeleteMapping(path = "/{studentId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("studentId") Long id) {
        if (!studentService.delete(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student is not found"
            );
        }
    }

    @PutMapping(path = "/{studentId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("studentId") Long id,
                              @RequestParam("mail") String mail) {
        studentService.changeMail(id, mail);
    }
}
