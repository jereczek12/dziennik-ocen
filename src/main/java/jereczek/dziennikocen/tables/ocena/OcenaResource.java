package jereczek.dziennikocen.tables.ocena;

import jakarta.validation.Valid;
import jereczek.dziennikocen.domain.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/ocena")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class OcenaResource {
    private final OcenaServiceImpl ocenaService;
    private final OcenaDTOMapper ocenaDTOMapper;

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Response> addOcena(@RequestBody OcenaDTO ocenaDTO) {
        log.info("endpoint dodania oceny");
        Ocena ocena;
            ocena = ocenaDTOMapper.mapOcenaDtoToOcena(ocenaDTO);
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
    @GetMapping("/list/prowadzacy")
    public ResponseEntity<Response> getOcenyByProwadzacy(@RequestParam("id") Long idProwadz){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.listOcenaByProwadzacy(idProwadz,50)))
                        .message("oceny retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/list/przedmiot")
    public ResponseEntity<Response> getOcenyByPrzedmiot(@RequestParam("id") Long idPrzedmiotu){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.listOcenaByPrzedmiot(idPrzedmiotu,50)))
                        .message("oceny retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/list/student")
    public ResponseEntity<Response> getOcenyByStudent(@RequestParam("id") int id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.listOcenaByStudent(id,1000)))
                        .message("oceny retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/list/studentAndPrzedmiot")
    public ResponseEntity<Response> getOcenyByStudentAndPrzedmiot(@RequestParam("id") int idStudneta,
                                                                  @RequestParam("przedmiot") Long idPrzedmiotu){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ocena", ocenaService.listOcenaByStudentAndPrzedmiot(idStudneta, idPrzedmiotu,1000)))
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
    @PutMapping("/update/{id}")
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
