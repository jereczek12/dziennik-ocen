package jereczek.dziennikocen.tables.przedmiot;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrzedmiotRepo extends JpaRepository<Przedmiot, Long> {
    Przedmiot findByIdPrzedmiotu(Long id);
    List<Przedmiot> findAllByProwadzacy_IdProwadz(Long id, Pageable pageable);
    List<Przedmiot> findAllByKierunek_NazwaKier(String nazwa_kier, Pageable pageable);


}
