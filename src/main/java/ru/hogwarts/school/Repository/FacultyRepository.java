package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Models.Faculty;
import java.util.List;

public interface FacultyRepository extends JpaRepository {
    List<Faculty> filterByColor(String color);

    boolean findById();
}
