package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Repository.FacultyRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService {
 private  final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty faculty){
      return facultyRepository.save(faculty);
    }
    public Faculty findById(long id){
        return facultyRepository.findById(id);
    }
    public List<Faculty> filterByColor(String color) {
        List<Faculty> filteredByColor = new ArrayList<>(facultyRepository.findByColor(color)) ;
        return filteredByColor.stream()
                .filter(faculty ->faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
    public Faculty update(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void remove(long id){
        facultyRepository.deleteById(id);
    }
    public List<Faculty> getAll(){return facultyRepository.findAll();}

}
