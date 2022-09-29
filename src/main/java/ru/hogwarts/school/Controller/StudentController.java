package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Models.Student;
import ru.hogwarts.school.Service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent (@PathVariable long id){
        Student student = studentService.findById(id);
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
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping("/add")
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
    @DeleteMapping ("{id}")
    public ResponseEntity remove(@PathVariable long id){
        studentService.remove(id);
        return ResponseEntity.ok().build();
    }
}
