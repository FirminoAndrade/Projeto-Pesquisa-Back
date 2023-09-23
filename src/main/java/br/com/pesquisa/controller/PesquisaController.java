package br.com.pesquisa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pesquisa.dto.PesquisaDto;
import br.com.pesquisa.entidades.Pesquisa;
import br.com.pesquisa.repositories.PesquisaRepository;
import br.com.pesquisa.service.PesquisaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "https://projeto-pesquisa-fronte.vercel.app",  maxAge = 3600)
@RequestMapping("/api/pesquisa")
public class PesquisaController {

	@Autowired
	private PesquisaRepository pesquisaRepository;

	@Autowired
	private PesquisaService pesquisaService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Pesquisa por ID")
	public ResponseEntity<Optional<Pesquisa>> buscarPesquisaPorId(@PathVariable Long id) {
		Optional<Pesquisa> pesquisa = pesquisaRepository.findById(id);
		return ResponseEntity.ok().body(pesquisa);
	}

	@GetMapping
	@Operation(summary = "Listar Pesquisas")
	public List<PesquisaDto> listarPesquisas() {
		List<Pesquisa> pesquisas = pesquisaRepository.findAllDesc();
		return PesquisaService.listarPesquisas(pesquisas);
	}

	@PostMapping
	@Operation(summary = "Cadastrar Pesquisa")
	public ResponseEntity<Pesquisa> cadastrarPesquisa(@Valid @RequestBody Pesquisa pesquisa) {
		pesquisa = pesquisaService.criarPesquisa(pesquisa);
		return ResponseEntity.ok().body(pesquisa);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Pesquisa")
	public ResponseEntity<PesquisaDto> atualizarPesquisa(@Valid @PathVariable Long id,
			@RequestBody PesquisaDto pesquisaDto) {
		Pesquisa pesquisa = pesquisaService.atualizarPesquisa(id, pesquisaDto);
		return ResponseEntity.ok(new PesquisaDto(pesquisa));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Pesquisa")
	public ResponseEntity<?> deletarCidade(@PathVariable Long id) {
		pesquisaService.deletePesquisa(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/quantidade")
	@Operation(summary = "Quantidade de Pesquisa")
	public int valorTotalPesquisas() {
		int valorTotal = pesquisaRepository.findByQuantidadePesquisas();
		return valorTotal;
	}
}
