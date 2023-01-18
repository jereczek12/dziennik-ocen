package jereczek.dziennikocen.tables.kierunek;

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
public class KierunekServiceImpl implements KierunekService{
    private final KierunekRepo kierunekRepo;

//
    @Override
    public Kierunek addKierunek(Kierunek kierunek) {
        log.info("Dodawanie kierunku : {}", kierunek.getNazwaKier());
        return kierunekRepo.save(kierunek);
    }

    @Override
    public Collection<Kierunek> listKierunki(int limit) {
        log.info("Wyszukiwanie wszystkich kierunków");
        return kierunekRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Kierunek getKierunekById(String nazwaKier) {
        log.info("wyszukiwanie kierunku: {}", nazwaKier);
        return kierunekRepo.findKierunekByNazwaKier(nazwaKier);
    }

    @Override
    public Boolean deleteById(String nazwaKier) {
        log.info("Usuwanie kierunku: {}", nazwaKier);
        kierunekRepo.deleteById(nazwaKier);
        return Boolean.TRUE;
    }

    @Override
    public Kierunek updateById(String nazwaKier, Kierunek kierunek) {
        log.info("Aktualizowanie informacji o kierunku: {}", nazwaKier);
        Kierunek updatedKierunek = kierunekRepo.findKierunekByNazwaKier(nazwaKier);
        if(kierunek.getNazwaKier()!=null) updatedKierunek.setNazwaKier(kierunek.getNazwaKier());
        if(kierunek.getWydzial()!=null) updatedKierunek.setWydzial(kierunek.getWydzial());

        return kierunekRepo.save(updatedKierunek);
    }

}
