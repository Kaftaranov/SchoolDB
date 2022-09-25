package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Models.Student;
import ru.hogwarts.school.Repository.StudentsRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentsRepository studentsRepository;

    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student add(Student student) {
        return studentsRepository.save(student);
    }
    public Student findById(long id) {
        return studentsRepository.findById(id);
    }
    public List<Student> filterByAge(int age) {
        List<Student> filteredByAge = new ArrayList<>(studentsRepository.filterByAge(age)) ;
        return filteredByAge.stream()
                .filter(student ->student.getAge()==age)
                .collect(Collectors.toList());
    }
    public Student update(Student student) {
        if(studentsRepository.findById(student.getId()) != null){
            studentsRepository.save(student);
            return  student;
        }
        return null;
    }

    public void remove(long id) {
        studentsRepository.deleteById(id);
    }
}
