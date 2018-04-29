package br.com.cursomc.repositories;

import br.com.cursomc.model.Categoria;
import br.com.cursomc.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
