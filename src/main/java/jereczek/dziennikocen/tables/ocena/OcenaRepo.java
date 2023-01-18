package jereczek.dziennikocen.tables.ocena;

import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import jereczek.dziennikocen.tables.przedmiot.Przedmiot;
import jereczek.dziennikocen.tables.student.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface OcenaRepo extends JpaRepository<Ocena, Long> {
    Ocena findOcenaById(Long id);
    List<Ocena> findByProwadzacy(Prowadzacy prowadzacy, Pageable pageable);
    List<Ocena> findByPrzedmiot(Przedmiot przedmiot, Pageable pageable);
    List<Ocena> findByStudent(Student student, Pageable pageable);
}
