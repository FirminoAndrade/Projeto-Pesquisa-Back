package br.com.pesquisa.entidades;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Campo NOME é requerido!")
	@Length(min = 3, max = 50, message = "O Campo NOME deve ter entre 3 e 50 caracteres.")
	private String nome;

	@NotEmpty(message = "Campo TIPO DE PERFIL é requerido!")
	private String tipoPerfil;

	@NotEmpty(message = "Campo TELEFONE é requerido!")
	private String telefone;
	
	@NotEmpty(message = "Campo EMAIL é requerido!")
	@Column(unique = true)
	private String email;

	@NotEmpty(message = "Campo SENHA é requerido!")
	private String senha;

}
