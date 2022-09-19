package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Service.FacultyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> get (@PathVariable long id){
        Optional faculty = facultyService.get(id);
        if (faculty.isEmpty()) {
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
    public Object add(@RequestBody Faculty faculty){
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
    public void remove(@RequestParam("Id") long id){
        facultyService.remove(id);
    }

}
