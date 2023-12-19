package epicode.entities;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Set;
@Entity
public class GaraDiAtletica extends Event{
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "garaDiAtletica")
    private Set<Persona> setAtleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;
}
