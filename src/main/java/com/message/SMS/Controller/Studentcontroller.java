package com.message.SMS.Controller;

import com.message.SMS.Model.Student;
import com.message.SMS.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class Studentcontroller {
    private final StudentService  service;

    @PostMapping
    public Student create(@RequestBody Student student){
        return service.create(student);
    }
    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student student){
        return service.update(id,student);
    }
    @DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
