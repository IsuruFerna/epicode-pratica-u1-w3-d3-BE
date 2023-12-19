package epicode.entities;

import com.sun.istack.Nullable;

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
	private String sesso;

	@OneToMany(mappedBy = "persona")
	private List<Partecipazione> partecipazioneList;

	@ManyToOne
	@JoinColumn(name="gara_di_atlatica_id")
	private GaraDiAtletica garaDiAtletica;

	public Persona() {}

	public Persona(String nome, String cognome, String email, LocalDate dataNascita, String sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazione> getPartecipazioneList() {
		return partecipazioneList;
	}

}
