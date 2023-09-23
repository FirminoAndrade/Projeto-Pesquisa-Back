package br.com.pesquisa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pesquisa.dto.FormularioDto;
import br.com.pesquisa.entidades.Formulario;
import br.com.pesquisa.entidades.Pesquisa;
import br.com.pesquisa.repositories.FormularioRepository;

@Service
public class FormularioService {

	@Autowired
	private FormularioRepository formularioRepository;

	@Autowired
	private PesquisaService cidadeService;

	// buscar por id
	private Formulario findById(Long id) {
		Optional<Formulario> formulario = formularioRepository.findById(id);
		return formulario.get();
	}

	public List<Formulario> listarFormularioPorCidade(Long id_cidade) {
		cidadeService.findById(id_cidade);
		return formularioRepository.findByIdFormulario(id_cidade);
	}

	// listar
	public static List<FormularioDto> listarTodosFormularios(List<Formulario> formulario) {
		return formulario.stream().map(FormularioDto::new).collect(Collectors.toList());
	}

	// criar
	public Formulario criarFormulario(Long id_pesquisa, Formulario formulario) {
		formulario.setId(null);
		Pesquisa pesquisa = cidadeService.findById(id_pesquisa);
		formulario.setPesquisa(pesquisa);
		return formularioRepository.save(formulario);
	}

	// atualizar
	public Formulario atualizarFormulario(Long id, Formulario dados) {
		Formulario novoDados = findById(id);
		atualizarDadosDoFormulario(novoDados, dados);
		return formularioRepository.save(novoDados);
	}

	// atualizar dados do Formulario
	private void atualizarDadosDoFormulario(Formulario novoDados, Formulario formulario) {
		novoDados.setNome(formulario.getNome());
		novoDados.setEndereco(formulario.getEndereco());
		novoDados.setBairro(formulario.getBairro());
		novoDados.setCidade(formulario.getCidade());
		novoDados.setTelefone(formulario.getTelefone());
		novoDados.setData(formulario.getData());
		novoDados.setGenero(formulario.getGenero());
		novoDados.setIdade(formulario.getIdade());
		novoDados.setNivelEnsino(formulario.getNivelEnsino());
		novoDados.setRenda(formulario.getRenda());
		novoDados.setOpcaoVoto(formulario.getOpcaoVoto());
		novoDados.setAprovacaoPresidente(formulario.getAprovacaoPresidente());
		novoDados.setAprovacaoGovernador(formulario.getAprovacaoGovernador());
		novoDados.setAprovacaoPrefeito(formulario.getAprovacaoPrefeito());
	}

	// deletar
	public void deleteFormulario(Long id) {
		findById(id);
		formularioRepository.deleteById(id);
	}
}
