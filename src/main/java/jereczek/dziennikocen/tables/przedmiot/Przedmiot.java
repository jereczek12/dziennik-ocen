package jereczek.dziennikocen.tables.przedmiot;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jereczek.dziennikocen.tables.kierunek.Kierunek;
import jereczek.dziennikocen.tables.prowadzacy.Prowadzacy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Przedmiot {
    @Id
    @Column(name="id_przedmiotu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrzedmiotu;

    @ManyToOne()
    @JoinColumn(name = "nazwa_kier", nullable = false, referencedColumnName = "nazwa_kier")
    private Kierunek kierunek;

    @Column(nullable = false)
    private String nazwa_przedmiotu;

    @ManyToOne
    @JoinColumn(name="id_prowadz", referencedColumnName = "id_prowadz")
    private Prowadzacy prowadzacy;

}