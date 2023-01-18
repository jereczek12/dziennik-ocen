package jereczek.dziennikocen.tables.prowadzacy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prowadzacy {
    @Id
    @Column(name="id_prowadz")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProwadz;


    private String imie;
    private String nazwisko;
    @Column(name = "email_prowadzacego")
    private String emailProwadzacego;
    @Column(name = "nr_telefonu")
    private String nrTelefonu;
    @Column(name = "data_zatrudnienia")
    private LocalDate data_zatrudnienia;

}