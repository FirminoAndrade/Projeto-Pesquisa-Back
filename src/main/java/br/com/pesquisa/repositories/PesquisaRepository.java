package br.com.pesquisa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pesquisa.entidades.Pesquisa;

@Repository
public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {

	@Query(nativeQuery = true, value = "SELECT count(id) as soma FROM pesquisa WHERE id = id;")
	int findByQuantidadePesquisas();

	@Query(nativeQuery = true, value = "Select * from pesquisa order by id desc;")
	List<Pesquisa> findAllDesc();
}
