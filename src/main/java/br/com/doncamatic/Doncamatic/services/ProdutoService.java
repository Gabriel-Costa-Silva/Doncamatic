package br.com.doncamatic.Doncamatic.services;

import br.com.doncamatic.Doncamatic.controllers.requests.ProdutoRequest;
import br.com.doncamatic.Doncamatic.controllers.responses.ProdutoResponse;
import br.com.doncamatic.Doncamatic.models.Produto;
import br.com.doncamatic.Doncamatic.repositories.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProdutoService {

    Logger LOGGER = LoggerFactory.getLogger(ProdutoService.class);


    @Autowired
    ProdutoRepository produtoRepository;

    //save - post
    public void post(ProdutoRequest produtoRequest) throws Exception{
        produtoRepository.save(new Produto(produtoRequest.titulo(),produtoRequest.descricao(),produtoRequest.imagem()));
    }
    //edit - put
    public void put(Long id, ProdutoRequest produtoRequest) throws Exception{

        Optional<Produto> optionalProduto= produtoRepository.findById(id);
        if(optionalProduto.isEmpty()) {
            LOGGER.error("Erro, produto não encontrado!");
            throw new Exception();
        }
        Produto produto = new Produto(optionalProduto.get().getId(), produtoRequest.titulo(), produtoRequest.descricao(), produtoRequest.imagem());
        produtoRepository.save(produto);

    }
    //delete
    public void delete (Long id) throws Exception{
        produtoRepository.deleteById(id);
    }


    //findById - getById
    public ProdutoResponse getById(Long id){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent())
            return new ProdutoResponse(optionalProduto.get().getId(),optionalProduto.get().getTitulo(), optionalProduto.get().getDescricao(), optionalProduto.get().getImagem());
        return null;
    }

    //findByString - getByString
    public List<ProdutoResponse> getByTitulo(String titulo){

        List<Produto> produtoList = produtoRepository.findByTitulo(titulo);
        List<ProdutoResponse> produtoResponseList = new ArrayList<>();
        if(!produtoList.isEmpty()){
            produtoList.stream().forEach(entry -> produtoResponseList.add(new ProdutoResponse(entry.getId(), entry.getTitulo(), entry.getDescricao(), entry.getImagem())));
        }
        return produtoResponseList;
    }
    //findAll - getAll

    public List<ProdutoResponse> getAll(){
        List<Produto> produtoList = produtoRepository.findAll();
        List<ProdutoResponse> produtoResponseList = new ArrayList<>();
        if(!produtoList.isEmpty()){
            produtoList.stream().forEach(entry -> produtoResponseList.add(new ProdutoResponse(entry.getId(), entry.getTitulo(), entry.getDescricao(), entry.getImagem())));
        }
        return produtoResponseList;

    }


    //exists
    public boolean exists(Long id){
        ProdutoResponse  produtoResponse = getById(id);
        if(produtoResponse != null)
            return true;
        return false;

    }



}
