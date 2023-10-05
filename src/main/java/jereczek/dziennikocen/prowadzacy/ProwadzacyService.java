package jereczek.dziennikocen.prowadzacy;

import java.util.Collection;

public interface ProwadzacyService {
    Prowadzacy addProwadzacy(Prowadzacy prowadzacy);
    Collection<Prowadzacy> listProwadzacy(int limit);
    Prowadzacy getProwadzacyById(Long id);
    Boolean deleteById(Long id);
    Prowadzacy updateById(Long id, Prowadzacy prowadzacy);
}
