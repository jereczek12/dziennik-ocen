package jereczek.dziennikocen.tables.ocena;

import java.util.Collection;

public interface OcenaService {
    Ocena addOcena(Ocena ocena);
    Collection<Ocena> listOcena(int limit);
    Ocena getOcenaById(Long id);
    Collection<Ocena> listOcenaByPrzedmiot(Long id, int limit);
    Collection<Ocena> listOcenaByProwadzacy(Long idProwadz, int limit);

    Collection<Ocena> listOcenaByStudent(int id, int limit);

    Boolean deleteById(Long id);
    Ocena updateById(Long id, Ocena ocena);

}
