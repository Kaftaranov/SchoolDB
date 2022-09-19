package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Models.Student;
import java.util.List;

public interface StudentsRepository extends JpaRepository {
    List<Student> filterByAge(int age);

    boolean findById();
}
