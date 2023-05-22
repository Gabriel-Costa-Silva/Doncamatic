package br.com.doncamatic.Doncamatic.repositories;

import br.com.doncamatic.Doncamatic.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    List<Produto> findByTitulo(String titulo);

}
