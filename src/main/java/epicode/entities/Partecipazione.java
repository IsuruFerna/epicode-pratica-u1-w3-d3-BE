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
    @Enumerated(EnumType.STRING)
    private PartecipazioneStato stato;

    @ManyToOne
    @JoinColumn(name= "persona_id", nullable = false)
    private Persona persona;

    @ManyToMany
    @JoinTable(
            name = "events_partecipazione",
            joinColumns = @JoinColumn(name="partecipazione_id"),
            inverseJoinColumns = @JoinColumn(name = "events_id")
    )
    private List<Event> eventList = new ArrayList<>();

    public Partecipazione(){
    }

    public Partecipazione(PartecipazioneStato stato, Persona persona, Event event) {
        this.stato = stato;
        this.persona = persona;
        this.eventList.add(event);
    }

    public PartecipazioneStato getStato() {
        return stato;
    }

    public void setStato(PartecipazioneStato stato) {
        this.stato = stato;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public void addEvent(Event event) {
        this.eventList.add(event);
    }
}
