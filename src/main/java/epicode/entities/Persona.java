package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private char sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> partecipazioneList = new ArrayList<>();

}
