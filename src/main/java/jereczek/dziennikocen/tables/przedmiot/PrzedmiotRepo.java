package jereczek.dziennikocen.tables.przedmiot;

import jereczek.dziennikocen.tables.kierunek.Kierunek;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PrzedmiotRepo extends JpaRepository<Przedmiot, Long> {
    Przedmiot findByIdPrzedmiotu(Long id);
    Collection<Przedmiot> findAllByProwadzacy(Prowadzacy prowadzacy, Pageable pageable);
    Collection<Przedmiot> findAllByKierunek(Kierunek kierunek, Pageable pageable);


}
