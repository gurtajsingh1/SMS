package Student.raw.Controller;
import java.util.List;
import Student.raw.Model.Student;
import Student.raw.Repository.StudentRepository;
import Student.raw.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;


    public StudentController(
            StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public Student addStudent(
            @RequestBody Student student
    ) {

        return studentService.save(student);
    }

    // READ ALL

    @GetMapping
    public List<Student> getStudents() {

        return studentService.getAllStudent();
    }

    // READ BY ID

    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Long id
    ) {

        return studentService.getStudentById(id);
    }

    // UPDATE

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student
    ) {

        return studentService.updateStudent(id, student);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id
    ) {

        studentService.deleteStudent(id);

        return "Student deleted successfully";
    }
}
