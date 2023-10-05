package jereczek.dziennikocen.kierunek;

import jakarta.validation.Valid;
import jereczek.dziennikocen.domain.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/kierunek")
@RequiredArgsConstructor
public class KierunekResource {
    private final KierunekServiceImpl kierunekService;

    @PostMapping("/add")
    public ResponseEntity<Response> addKierunek(@RequestBody @Valid Kierunek kierunek) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("kierunek", kierunekService.addKierunek(kierunek)))
                        .message("Kierunek added")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
    @GetMapping("/list")
    public ResponseEntity<Response> getAllKierunki(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("kierunek", kierunekService.listKierunki(20)))
                        .message("Kierunki retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getKierunek(@PathVariable("id") String nazwaKier){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("kierunek", kierunekService.getKierunekById(nazwaKier)))
                        .message("Kierunek retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteKireunek(@PathVariable("id") String nazwaKier){

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", kierunekService.deleteById(nazwaKier)))
                        .message("Kierunek deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @PutMapping("/add/{id}")
    public ResponseEntity<Response> updateKierunek(@PathVariable("id") String nazwaKier,
                                                  @RequestBody @Valid Kierunek kierunek) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("kierunek", kierunekService.updateById(nazwaKier, kierunek)))
                        .message("Kierunek updated")
                        .status(HttpStatus.ACCEPTED)
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .build()
        );
    }
}
