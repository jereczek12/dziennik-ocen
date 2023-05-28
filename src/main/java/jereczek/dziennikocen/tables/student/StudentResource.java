package jereczek.dziennikocen.tables.student;

import jakarta.validation.Valid;
import jereczek.dziennikocen.domain.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@CrossOrigin
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentResource {
    private final StudentServiceImpl studentService;

    @PostMapping("/add")
    public ResponseEntity<Response> addStudent(@RequestBody @Valid Student student) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("student", studentService.addStudent(student)))
                        .message("Student added")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getAllStudents(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("students", studentService.listStudents(50)))
                        .message("Students retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getWydzial(@PathVariable("id") int nrIndeksu){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("student", studentService.getStudentById(nrIndeksu)))
                        .message("Student retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable("id") int nrIndeksu){

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", studentService.deleteById(nrIndeksu)))
                        .message("Student deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @PutMapping("/add/{id}")
    public ResponseEntity<Response> updateStudent(@PathVariable("id") int nrIndeksu,
                                                      @RequestBody @Valid Student student) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("student", studentService.updateById(nrIndeksu, student)))
                        .message("Student added")
                        .status(HttpStatus.ACCEPTED)
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .build()
        );
    }

}
