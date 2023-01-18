package jereczek.dziennikocen.tables.student;

import jakarta.persistence.*;
import jereczek.dziennikocen.tables.kierunek.Kierunek;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_indeksu")
    private int nrIndeksu;

    private String imie;
    private String nazwisko;
    private String email;
    @Column(name = "nr_telefonu")
    private String nrTelefonu;
    private LocalDate data_rozpoczecia;
    private LocalDate data_zakonczenia;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name="student_kierunek",
    joinColumns = {
            @JoinColumn(name = "nr_indeksu", referencedColumnName = "nr_indeksu"),

    },
    inverseJoinColumns = {
            @JoinColumn(name = "nazwa_kier", referencedColumnName = "nazwa_kier")
    })
    private Set<Kierunek> kierunekSet;
}