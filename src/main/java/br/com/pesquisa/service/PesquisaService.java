package br.com.pesquisa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pesquisa.dto.PesquisaDto;
import br.com.pesquisa.entidades.Pesquisa;
import br.com.pesquisa.repositories.PesquisaRepository;

@Service
public class PesquisaService {

	@Autowired
	private PesquisaRepository pesquisaRepository;

	// buscar por id
	public Pesquisa findById(Long id) {
		Optional<Pesquisa> pesquisa = pesquisaRepository.findById(id);
		return pesquisa.get();
	}

	// listar
	public static List<PesquisaDto> listarPesquisas(List<Pesquisa> pesquisa) {
		return pesquisa.stream().map(PesquisaDto::new).collect(Collectors.toList());
	}

	// criar
	public Pesquisa criarPesquisa(Pesquisa pesquisa) {
		pesquisa.setId(null);
		return pesquisaRepository.save(pesquisa);
	}

	// atualizar
	public Pesquisa atualizarPesquisa(Long id, PesquisaDto pesquisaDto) {
		Pesquisa pesquisa = findById(id);
		pesquisa.setNomeCidade(pesquisaDto.getNomeCidade());
		pesquisa.setEstado(pesquisaDto.getEstado());
		pesquisa.setTipoPesquisa(pesquisaDto.getTipoPesquisa());
		pesquisa.setCandidato1(pesquisaDto.getCandidato1());
		pesquisa.setCandidato2(pesquisaDto.getCandidato2());
		pesquisa.setCandidato3(pesquisaDto.getCandidato3());
		pesquisa.setCandidato4(pesquisaDto.getCandidato4());

		return pesquisaRepository.save(pesquisa);
	}

	// deletar
	public void deletePesquisa(Long id) {
		findById(id);
		pesquisaRepository.deleteById(id);
	}
}
