package br.com.pesquisa.entidades;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Formulario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String endereco;
	private String bairro;
	private String cidade;
	private String telefone;
	private String data;
	private String genero;
	private String idade;
	private String nivelEnsino;
	private String renda;
	private String opcaoVoto;
	private String aprovacaoPresidente;
	private String aprovacaoGovernador;
	private String aprovacaoPrefeito;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pesquisa_id")
	private Pesquisa pesquisa;

}
