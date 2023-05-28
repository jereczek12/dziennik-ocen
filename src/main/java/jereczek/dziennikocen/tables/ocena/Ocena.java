package jereczek.dziennikocen.tables.ocena;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import jereczek.dziennikocen.tables.przedmiot.Przedmiot;
import jereczek.dziennikocen.tables.student.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Ocena")
public class Ocena {
    @Id
    @Column(name="id_ocena")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_prowadz", referencedColumnName = "id_prowadz", nullable = false)
    @JsonIgnoreProperties(value = "przedmiot")
    private Prowadzacy prowadzacy;

    @ManyToOne()
    @JoinColumn(name = "id_przedmiotu", referencedColumnName = "id_przedmiotu", nullable = false)
    @JsonIgnoreProperties(value = {"kierunek", "prowadzacy"})
    private Przedmiot przedmiot;

    @ManyToOne()
    @JoinColumn(name = "nr_indeksu", referencedColumnName = "nr_indeksu", nullable = false)
    private Student student;

    @Column(name = "ocena", nullable=false)
    private Integer ocena;

    @Column(name = "zdjecie")
    private String zdjecie;

    @Column
    private String kategoria;

    @Column
    private String komentarz;
}