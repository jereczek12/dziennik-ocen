package jereczek.dziennikocen.tables.przedmiot;

import jereczek.dziennikocen.tables.kierunek.Kierunek;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;

import java.util.Collection;

public interface PrzedmiotService {
    Przedmiot addPrzedmiot(Przedmiot przedmiot);
    Collection<Przedmiot> listPrzedmioty(int limit);
    Collection<Przedmiot> listPrzedmiotyByKierunek(Kierunek kierunek, int limit);
    Collection<Przedmiot> listPrzedmiotyByProwadzacy(Prowadzacy prowadzacy, int limit);
    Przedmiot getPrzedmiotById(Long id);
    Boolean deleteById(Long id);
    Przedmiot updateById(Long id, Przedmiot przedmiot);
}
