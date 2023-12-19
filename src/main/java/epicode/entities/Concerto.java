package epicode.entities;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class Concerto extends Event{
    @Enumerated(EnumType.STRING)
    private GenreMusic genere;

    @Column(name = "is_streaming")
    private boolean inStraming;

    public Concerto() {}
    public Concerto(GenreMusic genere, boolean inStraming) {
        this.genere = genere;
        this.inStraming = inStraming;
    }

    public Concerto(String titolo, String dataEvento, String descrizione, EventType tipoEvento, int numeroMassimoPartecipanti, GenreMusic genere, boolean inStraming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStraming = inStraming;
    }

    public GenreMusic getGenere() {
        return genere;
    }

    public boolean isInStraming() {
        return inStraming;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Concerto.class.getSimpleName() + "[", "]")
                .add("genere=" + genere)
                .add("inStraming=" + inStraming)
                .toString();
    }
}
