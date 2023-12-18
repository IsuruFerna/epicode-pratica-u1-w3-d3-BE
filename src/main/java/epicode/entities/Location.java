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

	public Location() {
	}
	public Location(String nome, String citta, Event event) {
		this.nome = nome;
		this.citta = citta;
		this.event = event;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
