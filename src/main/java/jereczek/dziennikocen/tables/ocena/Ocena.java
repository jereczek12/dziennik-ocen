package jereczek.dziennikocen.tables.ocena;

import jakarta.persistence.*;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import jereczek.dziennikocen.tables.przedmiot.Przedmiot;
import jereczek.dziennikocen.tables.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Ocena")
public class Ocena {
    @Id
    @Column(name="id_ocena")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_prowadz", referencedColumnName = "id_prowadz", nullable = false)
    private Prowadzacy prowadzacy;

    @ManyToOne()
    @JoinColumn(name = "id_przedmiotu", referencedColumnName = "id_przedmiotu", nullable = false)
    private Przedmiot przedmiot;

    @ManyToOne()
    @JoinColumn(name = "nr_indeksu", referencedColumnName = "nr_indeksu", nullable = false)
    private Student student;

    @Column(name = "ocena", nullable=false)
    private Integer ocena;

}