package com.message.SMS.Service;

import com.message.SMS.Model.Student;
import com.message.SMS.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
     private final StudentRepository repository;

     public Student create(Student student){
         return repository.save(student);
     }
     public List<Student> getAll(){
         return repository.findAll();
     }

     public Student update(Long id , Student updated){
         Student student  = repository.findById(id).orElseThrow();
         student.setName(updated.getName());
         student.setEmail(updated.getEmail());
         student.setCource(updated.getCource());
         student.setfee(updated.getfee());
         return repository.save(student);
     }
     public void delete(Long id){
         repository.deleteById(id);
     }
}
