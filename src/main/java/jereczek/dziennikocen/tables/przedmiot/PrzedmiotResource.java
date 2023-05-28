package jereczek.dziennikocen.tables.przedmiot;

import jakarta.validation.Valid;
import jereczek.dziennikocen.domain.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/przedmioty")
@CrossOrigin
@RequiredArgsConstructor
public class PrzedmiotResource {
    private final PrzedmiotServiceImpl przedmiotService;

    @PostMapping()
    public ResponseEntity<Response> addPrzedmiot(@RequestBody @Valid Przedmiot przedmiot) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przedmiot",przedmiotService.addPrzedmiot(przedmiot)))
                        .message("przedmiot added")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping()
    public ResponseEntity<Response> getPrzedmioty(@RequestParam(name="nazwa-kierunku",required = false) String nazwaKier,
                                                  @RequestParam(name="id-prowadz", required = false)Long idProwadz){
        if (nazwaKier!=null && idProwadz!=null)
            return getPrzedmiotByKierunekAndProwadzacy(nazwaKier, idProwadz);
        if (nazwaKier!=null)
            return getPrzedmiotyByKierunek(nazwaKier);
        if (idProwadz!=null)
            return getPrzedmiotyByProwadzacy(idProwadz);
        else return getAllPrzedmioty();
    }
    public ResponseEntity<Response> getPrzedmiotyByKierunek(String nazwaKierunku){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przedmiot", przedmiotService.listPrzedmiotyByKierunek(nazwaKierunku,50)))
                        .message("przedmioty retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getPrzedmiot(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przemdiot", przedmiotService.getPrzedmiotById(id)))
                        .message("przedmiot retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteOcena(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", przedmiotService.deleteById(id)))
                        .message("przedmiot deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateStudent(@PathVariable("id") Long id,
                                                  @RequestBody @Valid Przedmiot przedmiot ) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przemdiot", przedmiotService.updateById(id, przedmiot)))
                        .message("przzemdiot updated")
                        .status(HttpStatus.ACCEPTED)
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .build()
        );
    }

    public ResponseEntity<Response> getPrzedmiotByKierunekAndProwadzacy(String nazwaKier, Long idProwadz){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przedmioty", przedmiotService.listPrzedmiotyByKierunekAndProwadzacy(nazwaKier, idProwadz,20)))
                        .message("przedmioty retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    public ResponseEntity<Response> getPrzedmiotyByProwadzacy(Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przedmiot", przedmiotService.listPrzedmiotyByProwadzacy(id,50)))
                        .message("przedmioty retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    public ResponseEntity<Response> getAllPrzedmioty(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przedmioty", przedmiotService.listPrzedmioty(20)))
                        .message("przedmioty retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
