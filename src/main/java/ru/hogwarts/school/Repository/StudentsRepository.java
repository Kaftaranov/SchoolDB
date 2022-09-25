package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Models.Student;
import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Student, Long> {
    List<Student> filterByAge(int age);

    Student findById(long id);
}
