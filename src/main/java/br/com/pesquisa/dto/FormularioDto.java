package br.com.pesquisa.dto;

import br.com.pesquisa.entidades.Formulario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormularioDto {

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

	public FormularioDto(Formulario formulario) {
		this.id = formulario.getId();
		this.nome = formulario.getNome();
		this.endereco = formulario.getEndereco();
		this.bairro = formulario.getBairro();
		this.cidade = formulario.getCidade();
		this.telefone = formulario.getTelefone();
		this.data = formulario.getData();
		this.genero = formulario.getGenero();
		this.idade = formulario.getIdade();
		this.nivelEnsino = formulario.getNivelEnsino();
		this.renda = formulario.getRenda();
		this.opcaoVoto = formulario.getOpcaoVoto();
		this.aprovacaoPresidente = formulario.getAprovacaoPresidente();
		this.aprovacaoGovernador = formulario.getAprovacaoGovernador();
		this.aprovacaoPrefeito = formulario.getAprovacaoPrefeito();
	}
}
