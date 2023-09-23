package br.com.pesquisa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Pesquisa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Campo NOME é requerido!")
	private String nomeCidade;

	@NotEmpty(message = "Campo ESTADO é requerido!")
	private String estado;

	@NotEmpty(message = "Campo TIPO PESQUISA é requerido!")
	private String tipoPesquisa;
	
	private String candidato1;
	private String candidato2;
	private String candidato3;
	private String candidato4;

	@OneToMany(mappedBy = "pesquisa")
	private List<Formulario> formularios = new ArrayList<>();

	public Pesquisa(Long id, String nomeCidade, String estado, String tipoPesquisa, String candidato1,
			String candidato2, String candidato3, String candidato4) {
		this.id = id;
		this.nomeCidade = nomeCidade;
		this.estado = estado;
		this.tipoPesquisa = tipoPesquisa;
		this.candidato1 = candidato1;
		this.candidato2 = candidato2;
		this.candidato3 = candidato3;
		this.candidato4 = candidato4;
	}
}
