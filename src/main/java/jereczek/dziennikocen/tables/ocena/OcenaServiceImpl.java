package jereczek.dziennikocen.tables.ocena;

import jakarta.transaction.Transactional;
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
    public Collection<Ocena> listOcenaByPrzedmiot(Long id, int limit) {
        log.info("Wyszukiwanie wszystkich ocen z przedmiotu: {}", id);
        return ocenaRepo.findByPrzedmiot_IdPrzedmiotu(id,PageRequest.of(0, limit));
    }

    @Override
    public Collection<Ocena> listOcenaByProwadzacy(Long idProwadz, int limit) {
        log.info("Wyszukiwanie wszystkich ocen prowadzacego: {}", idProwadz);
        return ocenaRepo.findByProwadzacy_IdProwadz(idProwadz,PageRequest.of(0, limit));
    }

    @Override
    public Collection<Ocena> listOcenaByStudent(int id, int limit) {
        log.info("Wyszukiwanie wszystkich ocen studenta: {}", id);
        return ocenaRepo.findByStudent_NrIndeksu(id,PageRequest.of(0, limit));
    }

    @Override
    public Collection<Ocena> listOcenaByStudentAndPrzedmiot(int idStudent, Long idPrzedmiot, int limit) {
        log.info("Wyszukiwanie wszystkich ocen studenta: {} z przedmiotu: {}", idStudent, idPrzedmiot);
        return ocenaRepo.findByStudent_NrIndeksuAndPrzedmiot_IdPrzedmiotu(idStudent, idPrzedmiot,PageRequest.of(0, limit));
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
