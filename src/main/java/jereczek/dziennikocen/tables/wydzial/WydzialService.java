package jereczek.dziennikocen.tables.wydzial;

import java.util.Collection;

public interface WydzialService {
    Wydzial add(Wydzial wydzial);
    Collection<Wydzial> listWydzial(int limit);
    Wydzial getWydzialByName(String nazwa_wydzialu);
    Boolean deleteById(String id);
    Wydzial update(Wydzial wydzial);
}
