package jereczek.dziennikocen.tables.ocena;

import jereczek.dziennikocen.tables.student.Student;
import lombok.Data;

import java.io.File;
@Data
public class OcenaDTO {

    private String student;
    private Integer ocena;
    private String przedmiot;
    private String zdjecie;
    private String kategoria;
    private String komentarz;

}

