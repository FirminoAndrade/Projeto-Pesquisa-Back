package br.com.pesquisa.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pesquisa.dto.FormularioDto;
import br.com.pesquisa.entidades.Formulario;
import br.com.pesquisa.repositories.FormularioRepository;
import br.com.pesquisa.service.FormularioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "https://projeto-pesquisa-fronte.vercel.app",  maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/formulario")
public class FormularioController {

	@Autowired
	private FormularioRepository formularioRepository;

	@Autowired
	private FormularioService formularioService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Formulário")
	public ResponseEntity<Optional<Formulario>> buscarFormulario(@PathVariable Long id) {
		Optional<Formulario> formulario = formularioRepository.findById(id);
		return ResponseEntity.ok().body(formulario);
	}

	@GetMapping("/todos")
	@Operation(summary = "Listar Todos os Formulários")
	public List<FormularioDto> listarFormularios() {
		List<Formulario> formularios = formularioRepository.findAll();
		return FormularioService.listarTodosFormularios(formularios);
	}
	
	@GetMapping("/votosCandidato/{id}/{nomeCandidato}")
	@Operation(summary = "Quantidade de votos por candidato")
	public ResponseEntity<Integer> quantidadeDeVotos(@PathVariable Long id, @PathVariable String nomeCandidato) {
	Integer qtd = formularioRepository.findByQtdVotoPorCandidato(id, nomeCandidato);
		return ResponseEntity.ok().body(qtd);
	}
	
	@GetMapping("/null/{id}")
	@Operation(summary = "Quantidade de votos por candidato")
	public ResponseEntity<Integer> quantidadeDeVotosBrancoNulloPorPesquisa(@PathVariable Long id) {
		int qtd = formularioRepository.findByQtdVotoBrancoNulloPorPesquisa(id);
		return ResponseEntity.ok().body(qtd);
	}
	
	@GetMapping("/votosPesquisa/{pesquisa}")
	@Operation(summary = "Quantidade de votos por Pesquisa")
	public ResponseEntity<Integer> quantidadeDeVotosPorPesquisa(@PathVariable String pesquisa) {
		int qtd = formularioRepository.findByQtdVotoTotalPorPesquisa(pesquisa);
		return ResponseEntity.ok().body(qtd);
	}
	
	@GetMapping("/qualificacaoPresidente/{id}/{qualificacao}")
	@Operation(summary = "Quantidade de votos por qualificação Presidente")
	public ResponseEntity<Integer> quantidadeDeVotosPorQualificacaoPresidente(@PathVariable Long id, @PathVariable String qualificacao) {
		int qtd = formularioRepository.findByQtdVotoQualificacaoPresidente(id, qualificacao);
		return ResponseEntity.ok().body(qtd);
	}
	
	@GetMapping("/qualificacaoGovernador/{id}/{qualificacao}")
	@Operation(summary = "Quantidade de votos por qualificação Governador")
	public ResponseEntity<Integer> quantidadeDeVotosPorQualificacaoGovernador(@PathVariable Long id, @PathVariable String qualificacao) {
		int qtd = formularioRepository.findByQtdVotoQualificacaoGovernador(id, qualificacao);
		return ResponseEntity.ok().body(qtd);
	}
	
	@GetMapping("/qualificacaoPrefeito/{id}/{qualificacao}")
	@Operation(summary = "Quantidade de votos por qualificação Prefeito")
	public ResponseEntity<Integer> quantidadeDeVotosPorQualificacaoPrefeito(@PathVariable Long id, @PathVariable String qualificacao) {
		int qtd = formularioRepository.findByQtdVotoQualificacaoPrefeito(id, qualificacao);
		return ResponseEntity.ok().body(qtd);
	}
	
	@GetMapping("/total")
	@Operation(summary = "Quantidade de votos")
	public int valorTotalDeVotos() {
		int valorTotal = formularioRepository.findByQuantidadeTotal();
		return valorTotal;
	}
	
	@GetMapping
	// localhost:8081/api/formulario?pesquisa=1
	@Operation(summary = "Listar Formulários Por Pesquisa passando ID")
	public ResponseEntity<List<FormularioDto>> listarFormulariosPorCidades(
			@RequestParam(value = "pesquisa", defaultValue = "0") Long id_pesquisa) {
		List<Formulario> listaFormularios = formularioService.listarFormularioPorCidade(id_pesquisa);
		List<FormularioDto> listaFormulariosDto = listaFormularios.stream().map(FormularioDto::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaFormulariosDto);
	}
	
		@PostMapping
	// localhost:8081/consultas?pesquisa=1
	@Operation(summary = "Cadastrar Formulário")
	public ResponseEntity<Formulario> cadastrarFormulario(
			@RequestParam(value = "pesquisa", defaultValue = "0") Long id_pesquisa,
			@Valid @RequestBody Formulario formulario) {
			Formulario novoFormulario = formularioService.criarFormulario(id_pesquisa, formulario);
		return ResponseEntity.ok().body(novoFormulario);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Formulário")
	public ResponseEntity<Formulario> atualizarFormulario(@PathVariable Long id, @Valid @RequestBody Formulario dados) {
		Formulario novoDados = formularioService.atualizarFormulario(id, dados);
		return ResponseEntity.ok().body(novoDados);
	}

	@PatchMapping("/{id}")
	@Operation(summary = "Atualizar Formulário Patch")
	public ResponseEntity<Formulario> atualizarFormularioPatch(@PathVariable Long id, @Valid @RequestBody Formulario dados) {
		Formulario novoDados = formularioService.atualizarFormulario(id, dados);
		return ResponseEntity.ok().body(novoDados);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Formulário")
	public ResponseEntity<?> deletarFormulario(@PathVariable Long id) {
		formularioService.deleteFormulario(id);
		return ResponseEntity.ok().build();

	}
}
