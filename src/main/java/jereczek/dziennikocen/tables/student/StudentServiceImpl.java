package jereczek.dziennikocen.tables.student;

import jakarta.transaction.Transactional;

import jereczek.dziennikocen.tables.kierunek.KierunekRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final KierunekRepo kierunekRepo;

    @Override
    public Student addStudent(Student student) {
        log.info("Dodawanie Studenta : {}", student.getImie()+" "+student.getNazwisko());
        return studentRepo.save(student);
    }

    @Override
    public Collection<Student> listStudents(int limit) {
        log.info("Wyszukiwanie wszystkich studentów");
        return studentRepo.findAll(PageRequest.of(0, limit)).toList();    }

    @Override
    public Student getStudentById(int nrIndeksu) {
        log.info("wyszukiwanie studenta: {}", nrIndeksu);
        return studentRepo.findStudentByNrIndeksu(nrIndeksu);
    }

    @Override
    public Boolean deleteById(int nrIndeksu) {
        log.info("Usuwanie studenta o Indeksie: {}", nrIndeksu);
        studentRepo.deleteById(nrIndeksu);
        return Boolean.TRUE;
    }

    @Override
    public Student updateById(int nrIndeksu, Student student) {
        log.info("Aktualizowanie informacji o studencie: {}", nrIndeksu);
        Student updatedStudent = studentRepo.findStudentByNrIndeksu(nrIndeksu);
        if(student.getImie()!=null) updatedStudent.setImie(student.getImie());
        if(student.getNazwisko()!=null) updatedStudent.setNazwisko(student.getNazwisko());
        if(student.getEmail()!=null) updatedStudent.setEmail(student.getEmail());
        if(student.getNrTelefonu()!=null) updatedStudent.setNrTelefonu(student.getNrTelefonu());
        if(student.getKierunekSet()!=null) updatedStudent.setKierunekSet(student.getKierunekSet());
        return studentRepo.save(updatedStudent);
    }
}
