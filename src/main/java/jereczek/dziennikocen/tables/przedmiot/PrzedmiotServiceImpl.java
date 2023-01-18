package jereczek.dziennikocen.tables.przedmiot;

import jakarta.transaction.Transactional;
import jereczek.dziennikocen.tables.kierunek.Kierunek;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PrzedmiotServiceImpl implements PrzedmiotService{
    private final PrzedmiotRepo przedmiotRepo;
    @Override
    public Przedmiot addPrzedmiot(Przedmiot przedmiot) {
        log.info("Dodawanie przedmiotu : {}", przedmiot.getNazwa_przedmiotu());
        return przedmiotRepo.save(przedmiot);
    }

    @Override
    public Collection<Przedmiot> listPrzedmioty(int limit) {
        log.info("Wyszukiwanie wszystkich przedmiotów");
        return przedmiotRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Collection<Przedmiot> listPrzedmiotyByKierunek(Kierunek kierunek, int limit) {
        log.info("Wyszukiwanie wszystkich przedmiotów na kierunku: {}", kierunek);
        return przedmiotRepo.findAllByKierunek(kierunek,PageRequest.of(0, limit));
    }

    @Override
    public Collection<Przedmiot> listPrzedmiotyByProwadzacy(Prowadzacy prowadzacy, int limit) {
        log.info("Wyszukiwanie wszystkich przedmiotów prowadzacego: {}", prowadzacy);
        return przedmiotRepo.findAllByProwadzacy(prowadzacy,PageRequest.of(0, limit));
    }

    @Override
    public Przedmiot getPrzedmiotById(Long id) {
        log.info("wyszukiwanie przedmiotu: {}",id);
        return przedmiotRepo.findByIdPrzedmiotu(id);    }

    @Override
    public Boolean deleteById(Long id) {
        log.info("Usuwanie przedmiotu: {}", id);
        przedmiotRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Przedmiot updateById(Long id, Przedmiot przedmiot) {
        log.info("Aktualizowanie informacji o przedmiocie: {}", id);
        Przedmiot updatedPrzedmiot = przedmiotRepo.findByIdPrzedmiotu(id);
        if(przedmiot.getNazwa_przedmiotu()!=null)
            updatedPrzedmiot.setNazwa_przedmiotu(przedmiot.getNazwa_przedmiotu());
        if(przedmiot.getKierunek()!=null)
            updatedPrzedmiot.setKierunek(przedmiot.getKierunek());
        if(przedmiot.getProwadzacy()!=null)
            updatedPrzedmiot.setProwadzacy(przedmiot.getProwadzacy());

        return przedmiotRepo.save(updatedPrzedmiot);
    }
}
