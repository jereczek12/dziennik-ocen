package jereczek.dziennikocen.student;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findStudentByNrIndeksu(int nrIndeksu);
    Student findStudentByImieAndNazwisko(String imie, String nazwisko);
}
