package jereczek.dziennikocen.tables.ocena;

import jereczek.dziennikocen.tables.kierunek.KierunekRepo;
import jereczek.dziennikocen.tables.prowadzacy.ProwadzacyRepo;
import jereczek.dziennikocen.tables.przedmiot.PrzedmiotRepo;
import jereczek.dziennikocen.tables.student.Student;
import jereczek.dziennikocen.tables.student.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class OcenaDTOMapper {

    @Autowired
    ProwadzacyRepo prowadzacyRepo;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    KierunekRepo kierunek;
    @Autowired
    PrzedmiotRepo przedmiot;

    public Ocena mapOcenaDtoToOcena(OcenaDTO ocenaDTO) {
        Ocena ocena = new Ocena();
        ocena.setOcena(ocenaDTO.getOcena());
        ocena.setProwadzacy(prowadzacyRepo.findByIdProwadz(1L));
        String[] imienazwisko = ocenaDTO.getStudent().split(" ");
        Student student = studentRepo.findStudentByImieAndNazwisko(imienazwisko[0],imienazwisko[1]);
        ocena.setStudent(student);
        ocena.setPrzedmiot(przedmiot.findByNazwaPrzedmiotu(ocenaDTO.getPrzedmiot()));
        ocena.setZdjecie(ocenaDTO.getZdjecie());
        ocena.setKategoria(ocenaDTO.getKategoria());
        ocena.setKomentarz(ocenaDTO.getKomentarz());
        ocena.setDataDodania(LocalDate.now());
        return ocena;
    }
}
