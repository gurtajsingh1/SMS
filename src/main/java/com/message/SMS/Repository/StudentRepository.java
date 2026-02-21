package com.message.SMS.Repository;

import com.message.SMS.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
