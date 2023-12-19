package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(
        name = "getConcertiInStreaming",
        query = "SELECT c FROM Concerto c WHERE c.inStraming = :is_streaming"
)
@NamedQuery(
        name = "getConcertiPerGenre",
        query = "SELECT g FROM Concerto g WHERE g.genere = :genere"
)
public abstract class Event {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "titolo") // just to customize column name and are not necessary at all
    private String titolo;

    @Column(name="data_evento")
    private LocalDate dataEvento;

    @Column
    private String descrizione;

    @Column(name="tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventType tipoEvento;

    @Column(name="numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    @ManyToMany(mappedBy = "eventList")
    private List<Partecipazione> partecipazioneList;

    @OneToMany(mappedBy = "event")
    private List<Location> locations;



    public Event() {
    }

    public Event(String titolo, String dataEvento, String descrizione, EventType tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = LocalDate.parse(dataEvento);
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public List<Partecipazione> getPartecipazioneList() {
        return partecipazioneList;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}
