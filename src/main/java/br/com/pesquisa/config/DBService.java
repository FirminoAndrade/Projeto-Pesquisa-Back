package br.com.pesquisa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.pesquisa.entidades.Pesquisa;
import br.com.pesquisa.entidades.Formulario;
import br.com.pesquisa.entidades.Usuario;
import br.com.pesquisa.repositories.PesquisaRepository;
import br.com.pesquisa.repositories.FormularioRepository;
import br.com.pesquisa.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PesquisaRepository cidadeRepository;

	@Autowired
	private FormularioRepository formularioRepository;
	
	@Autowired
	private PasswordEncoder encoder; 

	public void instaciaBaseDeDados() {

		String senha = "admin";
		Usuario usuario = new Usuario(null, "Cleuber Ramos", "ADMINISTRADOR", "6481298154", "admin", senha);
		usuario.setSenha(encoder.encode(senha));
		usuarioRepository.save(usuario);

		Pesquisa pesquisa1 = new Pesquisa(null, "Lagoa do Carro", "Pernambuco", "Pesquisa para prefeito", "Lula", "Bosolnaro","Temer", "Dilma");
		Pesquisa pesquisa2 = new Pesquisa(null, "Cachoeira Dourada", "Goias", "Pesquisa para Vereador", "Fernando Henrique","Tranquedo Neves", "Siro Gomes", "Simone Tebet");
		Pesquisa pesquisa3 = new Pesquisa(null, "São Paulo", "São Paulo", "Pesquisa para prefeito", "Jose Sarnei","Juselino Kubthech", "Jack Sparrow", "Barbossa");
		cidadeRepository.saveAll(Arrays.asList(pesquisa1, pesquisa2, pesquisa3));

	//	for(int i =0; i<100 ; i++) {			
		Formulario formulario0 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Lagoa do Carro", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Lula", "Otimo", "Otimo", "Otimo", pesquisa1);
		Formulario formulario1 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Cachoeira Dourada", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Fernando Henrique", "Ruim", "Ruim", "Regular", pesquisa2);
		Formulario formulario2 = new Formulario(null, "Jose Firmino", "rua b", "centro", "São Paulo", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Jack Sparrow", "Otimo", "Ruim", "Ruim", pesquisa3);
		Formulario formulario3 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Lagoa do Carro", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Lula", "Ruim", "Pessimo", "Pessimo", pesquisa1);
		Formulario formulario4 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Cachoeira Dourada", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Fernando Henrique", "Otimo", "Regular", "Otimo", pesquisa2);
		Formulario formulario5 = new Formulario(null, "Jose Firmino", "rua b", "centro", "São Paulo", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Jack Sparrow", "Regular", "Regular", "Regular", pesquisa3);
		Formulario formulario6 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Lagoa do Carro", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Temer", "Ruim", "Ruim", "Ruim", pesquisa1);
		Formulario formulario7 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Cachoeira Dourada", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Tranquedo Neves", "Pessimo", "Pessimo", "Pessimo", pesquisa2);
		Formulario formulario8 = new Formulario(null, "Jose Firmino", "rua b", "centro", "São Paulo", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Juselino Kubthech", "Regular", "Otimo", "Otimo", pesquisa3);
		Formulario formulario9 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Lagoa do Carro", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", null, "Regular", "Regular", "Regular", pesquisa1);
		Formulario formulario10 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Cachoeira Dourada", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Simone Tebet", "Ruim", "Ruim", "Regular", pesquisa2);
		Formulario formulario11 = new Formulario(null, "Jose Firmino", "rua b", "centro", "São Paulo", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Barbossa", "Pessimo", "Pessimo", "Ruim", pesquisa3);
		Formulario formulario12 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Lagoa do Carro", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Dilma", "Otimo", "Otimo", "Otimo", pesquisa1);
		Formulario formulario13 = new Formulario(null, "Jose Firmino", "rua b", "centro", "Cachoeira Dourada", "81984661549", "2023-06-25", "Masculino", "34", "Superior", "Minimo", "Simone Tebet", "Regular", "Regular", "Regular", pesquisa2);
		formularioRepository.saveAll(Arrays.asList(formulario0, formulario1, formulario2, formulario3, formulario4, formulario5, formulario6, formulario7, formulario8, formulario9, formulario10, formulario11, formulario12, formulario13));
		// i = i+1;
			//	 }
	}
}
