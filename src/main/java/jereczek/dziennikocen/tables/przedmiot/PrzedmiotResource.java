package jereczek.dziennikocen.tables.przedmiot;

import jakarta.validation.Valid;
import jereczek.dziennikocen.domain.Response;
import jereczek.dziennikocen.tables.kierunek.Kierunek;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/przedmiot")
@RequiredArgsConstructor
public class PrzedmiotResource {
    private final PrzedmiotServiceImpl przedmiotService;

    @PostMapping("/add")
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

    @GetMapping("/list")
    public ResponseEntity<Response> getAllPrzedmioty(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", przedmiotService.listPrzedmioty(20)))
                        .message("oceny retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/list?prowadzacy")
    public ResponseEntity<Response> getPrzedmiotyByProwadzacy(@RequestBody @Valid Prowadzacy prowadzacy){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przedmiot", przedmiotService.listPrzedmiotyByProwadzacy(prowadzacy,50)))
                        .message("przedmioty retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/list?kierunek")
    public ResponseEntity<Response> getPrzedmiotyByKierunek(@RequestBody @Valid Kierunek kierunek){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("przedmiot", przedmiotService.listPrzedmiotyByKierunek(kierunek,50)))
                        .message("przedmioty retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
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
    @DeleteMapping("/delete/{id}")
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
    @PutMapping("/add/{id}")
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

}
