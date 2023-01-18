package jereczek.dziennikocen.tables.ocena;

import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import jereczek.dziennikocen.tables.przedmiot.Przedmiot;
import jereczek.dziennikocen.tables.student.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface OcenaRepo extends JpaRepository<Ocena, Long> {
    Ocena findOcenaById(Long id);
    Collection<Ocena> findByProwadzacy(Prowadzacy prowadzacy, Pageable pageable);
    Collection<Ocena> findByPrzedmiot(Przedmiot przedmiot, Pageable pageable);
    Collection<Ocena> findByStudent(Student student, Pageable pageable);
}
