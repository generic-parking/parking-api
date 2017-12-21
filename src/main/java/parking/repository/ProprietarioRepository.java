package parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import parking.domain.GrupoCaronaDTO;
import parking.domain.Proprietario;

/**
 * 
 * @author gustavojotz
 *
 */
public interface ProprietarioRepository
		extends PagingAndSortingRepository<Proprietario, Long>, QueryDslPredicateExecutor<Proprietario> {

	Proprietario findByUsuarioIgnoreCase(final String usuario);

	@Query("select new parking.domain.GrupoCaronaDTO(p.id, p.nome) from Proprietario p where p.ofereceCarona = true")
	List<GrupoCaronaDTO> findGruposCarona();
}
