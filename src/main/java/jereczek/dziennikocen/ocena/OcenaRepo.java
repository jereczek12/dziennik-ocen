package jereczek.dziennikocen.ocena;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcenaRepo extends JpaRepository<Ocena, Long> {
    Ocena findOcenaById(Long id);
    List<Ocena> findByProwadzacy_IdProwadz(Long idProwadz, Pageable pageable);
    List<Ocena> findByPrzedmiot_IdPrzedmiotu(Long idPrzedmiot, Pageable pageable);
    List<Ocena> findByStudent_NrIndeksu(int indeks, Pageable pageable);
    List<Ocena> findByStudent_NrIndeksuAndPrzedmiot_IdPrzedmiotu(int indeks, Long idPrzedmioty, Pageable pageable);
}
