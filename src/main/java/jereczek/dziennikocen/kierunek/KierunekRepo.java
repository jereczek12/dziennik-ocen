package jereczek.dziennikocen.kierunek;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KierunekRepo extends JpaRepository<Kierunek, String> {
    Kierunek findKierunekByNazwaKier(String nazwaKier);
}
