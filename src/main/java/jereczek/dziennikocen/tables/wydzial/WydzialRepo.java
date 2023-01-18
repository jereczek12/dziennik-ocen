package jereczek.dziennikocen.tables.wydzial;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WydzialRepo extends JpaRepository<Wydzial, String> {
    Wydzial findByNazwaWydzialu(String nazwa_wydzialu);
}
