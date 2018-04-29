package br.com.cursomc.resources;

import br.com.cursomc.dto.ProdutoDTO;
import br.com.cursomc.model.Pedido;
import br.com.cursomc.model.Produto;
import br.com.cursomc.resources.utils.URL;
import br.com.cursomc.services.PedidoService;
import br.com.cursomc.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        Produto obj = produtoService.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<ProdutoDTO>> findPage(@RequestParam(value = "nome", defaultValue = "") String nome,
                                                     @RequestParam(value = "categorias", defaultValue = "") String categorias,
                                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                     @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                                     @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        String nomeDecoded = URL.decodeParam(nome);
        List<Integer> ids = URL.decodeIntList(categorias);
        Page<Produto> list = produtoService.search(nomeDecoded, ids, page,  linesPerPage,  orderBy,  direction);
        Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));

        return ResponseEntity.ok().body(listDTO);
    }

}
