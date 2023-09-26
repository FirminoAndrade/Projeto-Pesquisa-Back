package br.com.pesquisa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pesquisa.entidades.Formulario;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long>{

	@Query("select obj from formulario obj where obj.pesquisa.id = :id_formulario ORDER BY genero")
	List<Formulario> findByIdFormulario(@Param(value = "id_formulario") Long id_formulario);

	@Query("select count(id) from formulario where pesquisa_id = :id and opcao_voto like (:nomeCandidato)")
	int findByQtdVotoPorCandidato(@Param(value = "id") Long id, @Param(value = "nomeCandidato") String nomeCandidato);

	@Query("select count(id) from formulario where pesquisa_id = :id and opcao_voto is null;")
	int findByQtdVotoBrancoNulloPorPesquisa(@Param(value = "id") Long id);

	@Query("select count(id) as voto_total from formulario where cidade like (:pesquisa);")
	int findByQtdVotoTotalPorPesquisa(@Param(value = "pesquisa") String pesquisa);
	
	@Query("select count(id) from formulario where pesquisa_id = :id and aprovacao_presidente like (:qualificacao);")
	int findByQtdVotoQualificacaoPresidente(@Param(value = "id") Long id, @Param(value = "qualificacao") String qualificacao);

	@Query("select count(id) from formulario where pesquisa_id = :id and aprovacao_governador like (:qualificacao);")
	int findByQtdVotoQualificacaoGovernador(@Param(value = "id") Long id, @Param(value = "qualificacao") String qualificacao);
	
	@Query("select count(id) from formulario where pesquisa_id = :id and aprovacao_prefeito like (:qualificacao);")
	int findByQtdVotoQualificacaoPrefeito(@Param(value = "id") Long id, @Param(value = "qualificacao") String qualificacao);
	
	@Query("select count(id) as total from formulario where id = id;")
	int findByQuantidadeTotal();
	
	
}
