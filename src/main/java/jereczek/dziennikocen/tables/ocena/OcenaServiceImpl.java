package jereczek.dziennikocen.tables.ocena;

import jakarta.transaction.Transactional;
import jereczek.dziennikocen.tables.kierunek.Kierunek;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import jereczek.dziennikocen.tables.przedmiot.Przedmiot;
import jereczek.dziennikocen.tables.student.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class OcenaServiceImpl implements OcenaService{
    private final OcenaRepo ocenaRepo;
    @Override
    public Ocena addOcena(Ocena ocena) {
        log.info("Dodawanie oceny : {}", ocena.getId());
        return ocenaRepo.save(ocena);
    }

    @Override
    public Collection<Ocena> listOcena(int limit) {
        log.info("Wyszukiwanie wszystkich ocen");
        return ocenaRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Ocena getOcenaById(Long id) {
        log.info("wyszukiwanie oceny: {}",id);
        return ocenaRepo.findOcenaById(id);
    }

    @Override
    public Collection<Ocena> listOcenaByPrzedmiot(Przedmiot przedmiot, int limit) {
        log.info("Wyszukiwanie wszystkich ocen z przedmiotu: {}", przedmiot);
        return ocenaRepo.findByPrzedmiot(przedmiot,PageRequest.of(0, limit));
    }

    @Override
    public Collection<Ocena> listOcenaByProwadzacy(Prowadzacy prowadzacy, int limit) {
        log.info("Wyszukiwanie wszystkich ocen prowadzacego: {}", prowadzacy);
        return ocenaRepo.findByProwadzacy(prowadzacy,PageRequest.of(0, limit));
    }

    @Override
    public Collection<Ocena> listOcenaByStudent(Student student, int limit) {
        log.info("Wyszukiwanie wszystkich ocen studenta: {}", student.getImie() + " " + student.getNazwisko());
        return ocenaRepo.findByStudent(student,PageRequest.of(0, limit));
    }

    @Override
    public Boolean deleteById(Long id) {
        log.info("Usuwanie oceny: {}", id);
        ocenaRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Ocena updateById(Long id, Ocena ocena) {
        log.info("Aktualizowanie informacji o ocenie: {}", id);
        Ocena updatedOcena = ocenaRepo.findOcenaById(id);
        if(ocena.getOcena()!=null) updatedOcena.setOcena(ocena.getOcena());
        if(ocena.getStudent()!=null) updatedOcena.setStudent(ocena.getStudent());
        if(ocena.getProwadzacy()!=null) updatedOcena.setProwadzacy(ocena.getProwadzacy());
        if(ocena.getPrzedmiot()!=null) updatedOcena.setPrzedmiot(ocena.getPrzedmiot());

        return ocenaRepo.save(updatedOcena);
    }
}
