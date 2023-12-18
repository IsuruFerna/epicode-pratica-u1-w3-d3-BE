package epicode.entities;

import javax.persistence.*;
import java.util.Set;
@Entity
public class GaraDiAtletica extends Event{
    @Id
    @GeneratedValue
    private long id;

    @Column(name="set_atleti")
    @OneToMany(mappedBy = "atleti")
    private Set<Persona> setAtleti;

    private Persona vincitore;
}
