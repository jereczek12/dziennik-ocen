package jereczek.dziennikocen.tables.wydzial;

import jakarta.validation.Valid;
import jereczek.dziennikocen.domain.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/wydzial")
@RequiredArgsConstructor
public class WydzialResource {
    private final WydzialServiceImpl wydzialServiceImpl;


    @PostMapping("/add")
    public ResponseEntity<Response> addWydzial(@RequestBody @Valid Wydzial wydzial) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("wydzial", wydzialServiceImpl.add(wydzial)))
                        .message("Wydzial added")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }


    @GetMapping("/list")
    public ResponseEntity<Response> getAllWydzial(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("wydzialy", wydzialServiceImpl.listWydzial(30)))
                        .message("Wydzialy retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getWydzial(@PathVariable("id") String nazwaWydzialu){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("wydzial", wydzialServiceImpl.getWydzialByName(nazwaWydzialu)))
                        .message("Wydzialy retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteWydzial(@PathVariable("id")String nazwaWydzialu){

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", wydzialServiceImpl.deleteById(nazwaWydzialu)))
                        .message("Wydzial deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
