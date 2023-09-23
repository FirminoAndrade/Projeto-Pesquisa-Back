package br.com.pesquisa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pesquisa.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(nativeQuery = true, value = "Select * from usuario order by id desc;")
	List<Usuario> findAllDesc();

	Optional<Usuario> findByEmail(String email);
}
