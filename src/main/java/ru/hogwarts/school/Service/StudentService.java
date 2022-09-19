package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Models.Student;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private HashMap<Long, Student> students = new HashMap<>();
    private long id = 0;
    public Student add(Student student) {
        student.setId(++id);
        students.put(id, student);
        return student;
    }
    public Student get(long id) {
        return students.get(id);
    }
    public List<Student> filterByAge(int age) {
        List<Student> filteredByAge = new ArrayList<>(students.values()) ;
        return filteredByAge.stream()
                .filter(student ->student.getAge()==age)
                .collect(Collectors.toList());
    }
    public Student update(Student student) {
        if(students.containsKey(student.getId())){
            students.put(student.getId(), student);
            return  student;
        }
        return null;
    }

    public Student remove(long id) {
        return students.remove(id);
    }
}
