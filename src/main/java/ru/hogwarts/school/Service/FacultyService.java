package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService {
 private  final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Object add(Faculty faculty){
      return facultyRepository.save(faculty);
    }
    public Faculty get(long id){
        return facultyRepository.findById(id);
    }
    public List<Faculty> filterByColor(String color) {
        List<Faculty> filteredByColor = new ArrayList<>(facultyRepository.filterByColor(color)) ;
        return filteredByColor.stream()
                .filter(faculty ->faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
    public Faculty update(Faculty faculty){
        if(facultyRepository.findById(faculty.getId()) !=null){
            facultyRepository.save(faculty);
            return faculty;
        }
        return null;
    }

    public void remove(long id){
        facultyRepository.deleteById(id);
    }

}
