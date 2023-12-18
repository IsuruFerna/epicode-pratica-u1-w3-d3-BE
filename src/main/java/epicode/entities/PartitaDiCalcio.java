package epicode.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
@DiscriminatorValue("Partita di calcio")
public class PartitaDiCalcio extends Event{
    private String squadraDiCasa;
    private String squadraOspite;
    private String vincente; // null se pareggio
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public  PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, String dataEvento, String descrizione, EventType eventType, int numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite, int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, eventType, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;

        if (numeroGolSquadraDiCasa == numeroGolSquadraOspite) {
            this.vincente = null;
        } else if(numeroGolSquadraDiCasa > numeroGolSquadraOspite) {
            this.vincente = squadraDiCasa;
        } else {
            this.vincente = squadraOspite;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PartitaDiCalcio.class.getSimpleName() + "[", "]")
                .add("squadraDiCasa='" + squadraDiCasa + "'")
                .add("squadraOspite='" + squadraOspite + "'")
                .add("vincente='" + vincente + "'")
                .add("numeroGolSquadraDiCasa=" + numeroGolSquadraDiCasa)
                .add("numeroGolSquadraOspite=" + numeroGolSquadraOspite)
                .toString();
    }
}
