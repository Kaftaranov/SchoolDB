package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Models.Faculty;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColor(String color);
    Faculty findById(long id);
}
