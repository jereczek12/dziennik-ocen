package jereczek.dziennikocen.student;

import java.util.Collection;

public interface StudentService {
    Student addStudent(Student student);
    Collection<Student> listStudents(int limit);
    Student getStudentById(int nrIndeksu);
    Boolean deleteById(int nrIndeksu);
    Student updateById(int nrIndeksu, Student student);
}
