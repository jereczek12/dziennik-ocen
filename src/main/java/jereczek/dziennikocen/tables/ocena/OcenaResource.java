package jereczek.dziennikocen.tables.ocena;

import jakarta.validation.Valid;
import jereczek.dziennikocen.domain.Response;
import jereczek.dziennikocen.tables.kierunek.Kierunek;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import jereczek.dziennikocen.tables.przedmiot.Przedmiot;
import jereczek.dziennikocen.tables.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/ocena")
@RequiredArgsConstructor
public class OcenaResource {
    private final OcenaServiceImpl ocenaService;

    @PostMapping("/add")
    public ResponseEntity<Response> addOcena(@RequestBody @Valid Ocena ocena) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.addOcena(ocena)))
                        .message("ocena added")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
    @GetMapping("/list")
    public ResponseEntity<Response> getAllOceny(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.listOcena(20)))
                        .message("oceny retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/list")
    public ResponseEntity<Response> getOcenyByProwadzacy(@RequestBody @Valid Prowadzacy prowadzacy){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.listOcenaByProwadzacy(prowadzacy,50)))
                        .message("oceny retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/list")
    public ResponseEntity<Response> getOcenyByPrzedmiot(@RequestBody @Valid Przedmiot przedmiot){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.listOcenaByPrzedmiot(przedmiot,50)))
                        .message("oceny retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/list")
    public ResponseEntity<Response> getOcenyByStudent(@RequestBody @Valid Student student){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.listOcenaByStudent(student,50)))
                        .message("oceny retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOcena(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.getOcenaById(id)))
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
                        .data(Map.of("deleted", ocenaService.deleteById(id)))
                        .message("Kierunek deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @PutMapping("/add/{id}")
    public ResponseEntity<Response> updateStudent(@PathVariable("id") Long id,
                                                  @RequestBody @Valid Ocena ocena) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.updateById(id, ocena)))
                        .message("Ocena updated")
                        .status(HttpStatus.ACCEPTED)
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .build()
        );
    }

}
