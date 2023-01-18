package jereczek.dziennikocen.tables.student;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findStudentByNrIndeksu(int nrIndeksu);
}
