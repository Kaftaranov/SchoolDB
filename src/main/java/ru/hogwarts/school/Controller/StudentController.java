package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Models.Student;
import ru.hogwarts.school.Service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent (@PathVariable long id){
        Student student = studentService.get(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @GetMapping("/age")
    public ResponseEntity<List<Student>> filterByAge(@RequestParam int age){
        List<Student> ageCollection = studentService.filterByAge(age);
        if (ageCollection.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ageCollection);
    }

    @PostMapping
    public Student add(@RequestBody Student student){
        return  studentService.add(student);
    }
    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student){
        Student updatedstudent = studentService.update(student);
        if (updatedstudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedstudent);
    }
    @DeleteMapping ("/remove")
    public Student remove(@RequestParam("Id") long id){
        return studentService.remove(id);
    }
}
