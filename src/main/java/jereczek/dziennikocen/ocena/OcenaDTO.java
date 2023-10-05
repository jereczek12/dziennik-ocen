package jereczek.dziennikocen.ocena;

import lombok.Data;

@Data
public class OcenaDTO {

    private String student;
    private Integer ocena;
    private String przedmiot;
    private String zdjecie;
    private String kategoria;
    private String komentarz;

}

