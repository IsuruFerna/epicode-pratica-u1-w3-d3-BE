package epicode.entities;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String citta;

    @ManyToOne
    @JoinColumn(name = "events_id")
    private Event event;
}
