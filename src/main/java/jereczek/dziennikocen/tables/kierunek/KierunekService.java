package jereczek.dziennikocen.tables.kierunek;

import jereczek.dziennikocen.tables.student.Student;

import java.util.Collection;

public interface KierunekService {
    Kierunek addKierunek(Kierunek kierunek);
    Collection<Kierunek> listKierunki(int limit);
    Kierunek getKierunekById(String nazwaKier);
    Boolean deleteById(String nazwaKier);
    Kierunek updateById(String nazwaKier, Kierunek kierunek);
}
