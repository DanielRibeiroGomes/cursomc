package br.com.cursomc.repositories;

import br.com.cursomc.model.Categoria;
import br.com.cursomc.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
