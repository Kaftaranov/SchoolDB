package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Service.FacultyService;

import java.util.List;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty (@PathVariable long id){
        Faculty faculty = facultyService.findById(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("/color")
    public ResponseEntity<List<Faculty>> filterByColor(@RequestParam String color){
        List<Faculty> colorCollection = facultyService.filterByColor(color);
        if (colorCollection.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(colorCollection);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Faculty>> getAllFaculties(){
        return ResponseEntity.ok(facultyService.getAll());
    }

    @PostMapping("/add")
    public Object add(@RequestBody Faculty faculty){
        return  facultyService.add(faculty);
    }

    @PutMapping("/update")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty){
        Faculty updatedfaculty = facultyService.update(faculty);
        if (updatedfaculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedfaculty);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity remove(@PathVariable long id){
        facultyService.remove(id);
        return ResponseEntity.ok().build();
    }

}
