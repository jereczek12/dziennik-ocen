package jereczek.dziennikocen.tables.wydzial;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class WydzialServiceImpl implements WydzialService {
    private final WydzialRepo wydzialRepo;

    @Override
    public Wydzial add(Wydzial wydzial) {
        log.info("Dodawanie wydzialu : {}", wydzial.getNazwaWydzialu());
        return wydzialRepo.save(wydzial);
    }

    @Override
    public Collection<Wydzial> listWydzial(int limit) {
        log.info("Wyszukiwanie wszystkich wydziałów");
        return wydzialRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Wydzial getWydzialByName(String nazwa_wydzialu) {
        log.info("wyszukiwanie wydzialu: {}", nazwa_wydzialu);
        return wydzialRepo.findByNazwaWydzialu(nazwa_wydzialu);
    }

    @Override
    public Wydzial update(Wydzial wydzial) {
        log.info("Aktualizowanie informacji o wydziale : {}", wydzial.getNazwaWydzialu());
        return wydzialRepo.save(wydzial);
    }
    @Override
    public Boolean deleteById(String nazwa) {
        log.info("Usuwanie serwera o Id: {}", nazwa);
        wydzialRepo.deleteById(nazwa);
        return Boolean.TRUE;
    }


}
