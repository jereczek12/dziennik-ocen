package jereczek.dziennikocen.wydzial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="wydzial")
public class Wydzial {
    @Id
    @Column(name = "nazwa_wydzialu")
    private String nazwaWydzialu;
}
