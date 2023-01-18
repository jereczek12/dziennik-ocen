package jereczek.dziennikocen.tables.kierunek;

import jakarta.persistence.*;
import jereczek.dziennikocen.tables.student.Student;
import jereczek.dziennikocen.tables.wydzial.Wydzial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="kierunek")
public class Kierunek {
    @Id
    @Column(name = "nazwa_kier")
    private String nazwaKier;

    @ManyToOne
    @JoinColumn(name = "nazwa_wydzialu", nullable = false, referencedColumnName = "nazwa_wydzialu")
    private Wydzial wydzial;

    @ManyToMany(mappedBy = "kierunekSet", fetch = FetchType.LAZY)
    private Set<Student> students;
}