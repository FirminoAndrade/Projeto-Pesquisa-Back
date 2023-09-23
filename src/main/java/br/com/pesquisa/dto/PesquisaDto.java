package br.com.pesquisa.dto;

import br.com.pesquisa.entidades.Pesquisa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaDto {

	private Long id;
	private String nomeCidade;
	private String estado;
	private String tipoPesquisa;
	private String candidato1;
	private String candidato2;
	private String candidato3;
	private String candidato4;

	public PesquisaDto (Pesquisa pesquisa) {
		this.id = pesquisa.getId();
		this.nomeCidade = pesquisa.getNomeCidade();
		this.estado = pesquisa.getEstado();
		this.tipoPesquisa = pesquisa.getTipoPesquisa();
		this.candidato1 = pesquisa.getCandidato1();
		this.candidato2 = pesquisa.getCandidato2();
		this.candidato3 = pesquisa.getCandidato3();
		this.candidato4 = pesquisa.getCandidato4();
	}
}
