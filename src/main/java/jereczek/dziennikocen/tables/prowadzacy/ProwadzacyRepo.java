package jereczek.dziennikocen.tables.prowadzacy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProwadzacyRepo extends JpaRepository<Prowadzacy, Long> {
    Prowadzacy findByIdProwadz(Long id);

}
