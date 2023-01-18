package jereczek.dziennikocen.tables.przedmiot;

import java.util.Collection;

public interface PrzedmiotService {
    Przedmiot addPrzedmiot(Przedmiot przedmiot);
    Collection<Przedmiot> listPrzedmioty(int limit);
    Collection<Przedmiot> listPrzedmiotyByKierunek(String nazwa_kier, int limit);
    Collection<Przedmiot> listPrzedmiotyByProwadzacy(Long id, int limit);
    Przedmiot getPrzedmiotById(Long id);
    Boolean deleteById(Long id);
    Przedmiot updateById(Long id, Przedmiot przedmiot);
}
