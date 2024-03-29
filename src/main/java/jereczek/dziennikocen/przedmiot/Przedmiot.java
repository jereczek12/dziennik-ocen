package jereczek.dziennikocen.przedmiot;

import jakarta.persistence.*;
import jereczek.dziennikocen.kierunek.Kierunek;
import jereczek.dziennikocen.prowadzacy.Prowadzacy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Przedmiot {
    @Id
    @Column(name="id_przedmiotu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrzedmiotu;

    @ManyToOne
    @JoinColumn(name = "nazwa_kier", nullable = false, referencedColumnName = "nazwa_kier")
    private Kierunek kierunek;

    @Column(nullable = false, name = "nazwa_przedmiotu")
    private String nazwaPrzedmiotu;

    @ManyToOne
    @JoinColumn(name="id_prowadz", referencedColumnName = "id_prowadz")
    private Prowadzacy prowadzacy;

}