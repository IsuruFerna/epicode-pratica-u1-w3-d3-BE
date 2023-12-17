package epicode.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;
//    private String persona;
    private String evento;
    @Enumerated(EnumType.STRING)
    private PartecipazioneStato stato;

    @ManyToOne
    @JoinColumn(name= "persona_id")
    private Persona persona;

    @ManyToMany
    @JoinTable(
            name = "events_partecipazione",
            joinColumns = @JoinColumn(name="partecipazione_id"),
            inverseJoinColumns = @JoinColumn(name = "events_id")
    )
    private List<Event> eventList = new ArrayList<>();
}
