package jereczek.dziennikocen.tables.prowadzacy;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProwadzacyServiceImpl implements ProwadzacyService {
    private final ProwadzacyRepo prowadzacyRepo;

    @Override
    public Prowadzacy addProwadzacy(Prowadzacy prowadzacy) {
        log.info("Dodawanie prowadzacego: {}", prowadzacy.getIdProwadz());
        return prowadzacyRepo.save(prowadzacy);
    }

    @Override
    public Collection<Prowadzacy> listProwadzacy(int limit) {
        log.info("Wyszukiwanie wszystkich kierunków");
        return prowadzacyRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Prowadzacy getProwadzacyById(Long id) {
        log.info("wyszukiwanie kierunku: {}", id);
        return prowadzacyRepo.findByIdProwadz(id);    }

    @Override
    public Boolean deleteById(Long id) {
        log.info("Usuwanie prowadzacego: {}", id);
        prowadzacyRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Prowadzacy updateById(Long id, Prowadzacy prowadzacy) {
        log.info("Aktualizowanie informacji o prowadzdacym: {}", id);
        Prowadzacy updatedProwadzacy = prowadzacyRepo.findByIdProwadz(id);
        if(prowadzacy.getImie()!=null) updatedProwadzacy.setImie(prowadzacy.getImie());
        if(prowadzacy.getNazwisko()!=null) updatedProwadzacy.setNazwisko(prowadzacy.getNazwisko());
        if(prowadzacy.getNrTelefonu()!=null) updatedProwadzacy.setNrTelefonu(prowadzacy.getNrTelefonu());
        if(prowadzacy.getEmailProwadzacego()!=null) updatedProwadzacy.setEmailProwadzacego(prowadzacy.getEmailProwadzacego());
        if(prowadzacy.getData_zatrudnienia()!=null) updatedProwadzacy.setData_zatrudnienia(prowadzacy.getData_zatrudnienia());
        return prowadzacyRepo.save(updatedProwadzacy);
    }
}
