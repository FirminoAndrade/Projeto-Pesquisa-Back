package br.com.pesquisa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pesquisa.entidades.Formulario;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long>{

	@Query("SELECT obj FROM Formulario obj WHERE obj.pesquisa.id = :id_formulario ORDER BY genero")
	List<Formulario> findByIdFormulario(@Param(value = "id_formulario") Long id_formulario);

	@Query(nativeQuery = true, value = "SELECT count(id) FROM FORMULARIO WHERE  PESQUISA_ID = :id and OPCAO_VOTO like (:nomeCandidato);")
	Integer findByQtdVotoPorCandidato(@Param(value = "id") Long id, @Param(value = "nomeCandidato") String nomeCandidato);

	@Query(nativeQuery = true, value = "SELECT count(id) FROM FORMULARIO WHERE  PESQUISA_ID = :id and OPCAO_VOTO is null;")
	int findByQtdVotoBrancoNulloPorPesquisa(@Param(value = "id") Long id);

	@Query(nativeQuery = true, value = "select count(id) as voto_total from formulario where cidade like (:pesquisa);")
	int findByQtdVotoTotalPorPesquisa(@Param(value = "pesquisa") String pesquisa);
	
	@Query(nativeQuery = true, value = "SELECT count(id) FROM FORMULARIO WHERE  PESQUISA_ID = :id and APROVACAO_PRESIDENTE like (:qualificacao);")
	int findByQtdVotoQualificacaoPresidente(@Param(value = "id") Long id, @Param(value = "qualificacao") String qualificacao);

	@Query(nativeQuery = true, value = "SELECT count(id) FROM FORMULARIO WHERE  PESQUISA_ID = :id and APROVACAO_GOVERNADOR like (:qualificacao);")
	int findByQtdVotoQualificacaoGovernador(@Param(value = "id") Long id, @Param(value = "qualificacao") String qualificacao);
	
	@Query(nativeQuery = true, value = "SELECT count(id) FROM FORMULARIO WHERE  PESQUISA_ID = :id and APROVACAO_PREFEITO like (:qualificacao);")
	int findByQtdVotoQualificacaoPrefeito(@Param(value = "id") Long id, @Param(value = "qualificacao") String qualificacao);
	
	@Query(nativeQuery = true, value = "SELECT count(id) as total FROM formulario WHERE id = id;")
	int findByQuantidadeTotal();
	
	
}
