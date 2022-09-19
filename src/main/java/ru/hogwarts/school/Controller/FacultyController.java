package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Models.Student;
import ru.hogwarts.school.Service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> get (@PathVariable long id){
        Faculty faculty = facultyService.get(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/color")
    public ResponseEntity<List<Faculty>> filterByColor(@RequestParam String color){
        List<Faculty> colorCollection = facultyService.filterByColor(color);
        if (colorCollection.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(colorCollection);
    }

    @PostMapping
    public Faculty add(@RequestBody Faculty faculty){
        return  facultyService.add(faculty);
    }

    @PutMapping("/update")
    public ResponseEntity<Faculty> update(Faculty faculty){
        Faculty updatedfaculty = facultyService.update(faculty);
        if (updatedfaculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/remove")
    public Faculty remove(@RequestParam("Id") long id){
        return facultyService.remove(id);
    }
    //@GetMapping("/findbycolor")
    //public String findByColor(String color){
    //    return facultyService.findByColor(color);
    //}
}
