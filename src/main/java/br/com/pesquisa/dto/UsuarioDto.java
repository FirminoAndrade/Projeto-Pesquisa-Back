package br.com.pesquisa.dto;

import br.com.pesquisa.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

	private Long id;
	private String nome;
	private String tipoPerfil;
	private String telefone;
	private String email;
	private String senha;
	
	public UsuarioDto (Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.tipoPerfil = usuario.getTipoPerfil();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
}
