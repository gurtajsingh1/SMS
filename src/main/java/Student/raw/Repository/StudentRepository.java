package Student.raw.Repository;

import Student.raw.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public class StudentRepository extends JpaRepository<Student, Long> {
}
