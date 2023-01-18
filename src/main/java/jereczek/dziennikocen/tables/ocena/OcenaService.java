package jereczek.dziennikocen.tables.ocena;

import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import jereczek.dziennikocen.tables.przedmiot.Przedmiot;
import jereczek.dziennikocen.tables.student.Student;

import java.util.Collection;

public interface OcenaService {
    Ocena addOcena(Ocena ocena);
    Collection<Ocena> listOcena(int limit);
    Ocena getOcenaById(Long id);
    Collection<Ocena> listOcenaByPrzedmiot(Przedmiot przedmiot, int limit);
    Collection<Ocena> listOcenaByProwadzacy(Prowadzacy prowadzacy, int limit);

    Collection<Ocena> listOcenaByStudent(Student student, int limit);

    Boolean deleteById(Long id);
    Ocena updateById(Long id, Ocena ocena);

}
