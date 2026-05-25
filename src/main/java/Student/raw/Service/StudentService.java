package Student.raw.Service;

import Student.raw.Model.Student;
import Student.raw.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
    this.studentRepository = studentRepository;
    }
public Student save(Student s){
        return studentRepository.save(s);
}
public List<Student> getAllStudent(Student s){
        return studentRepository.findAll();
}
public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
}
    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    public Student updateStudent(
            Long id,
            Student updatedStudent
    ) {

        Student student =
                studentRepository.findById(id)
                        .orElse(null);

        if (student != null) {

            student.setName(updatedStudent.getName());

            student.setAge(updatedStudent.getAge());

            student.setCourse(updatedStudent.getCourse());

            return studentRepository.save(student);
        }
        return null;
    }

}
