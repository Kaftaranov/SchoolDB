package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Models.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    HashMap<Long, Faculty> faculties = new HashMap<>();
    long id = 0;

    public Faculty add(Faculty faculty){
        faculty.setId(++id);
        faculties.put(id, faculty);
        return faculty;
    }
    public Faculty get(long id){
        return faculties.get(id);
    }
    public List<Faculty> filterByColor(String color) {
        List<Faculty> filteredByColor = new ArrayList<>(faculties.values()) ;
        return filteredByColor.stream()
                .filter(faculty ->faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
    public Faculty update(Faculty faculty){
        if(faculties.containsKey(id)){
            faculties.put(faculty.getId(),faculty);
            return faculty;
        }
        return null;
    }

    public Faculty remove(long id){
        return faculties.remove(id);
    }

}
