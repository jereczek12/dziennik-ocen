package jereczek.dziennikocen.tables.prowadzacy;

import jakarta.validation.Valid;
import jereczek.dziennikocen.domain.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/prowadzacy")
@RequiredArgsConstructor
public class ProwadzacyResource {
    private final ProwadzacyService prowadzacyService;

    @PostMapping("/add")
    public ResponseEntity<Response> addProwadzacy(@RequestBody @Valid Prowadzacy prowadzacy) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("prowadzacy",prowadzacyService.addProwadzacy(prowadzacy)))
                        .message("prowadzacy added")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
    @GetMapping("/list")
    public ResponseEntity<Response> getAllProwadzacy(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("prowadzacy", prowadzacyService.listProwadzacy(20)))
                        .message("prowadzacy retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProwadzacyById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Prowadzacy", prowadzacyService.getProwadzacyById(id)))
                        .message("prowadzacy retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProwadzacy(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", prowadzacyService.deleteById(id)))
                        .message("prowadzacy deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<Response> updateProwadzacy(@PathVariable("id") Long id,
                                                  @RequestBody @Valid Prowadzacy prowadzacy) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("prowadzacy", prowadzacyService.updateById(id, prowadzacy)))
                        .message("Prowadzacy updated")
                        .status(HttpStatus.ACCEPTED)
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .build()
        );
    }
}
