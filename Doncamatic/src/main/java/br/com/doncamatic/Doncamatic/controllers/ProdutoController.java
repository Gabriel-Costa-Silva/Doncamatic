package br.com.doncamatic.Doncamatic.controllers;

import br.com.doncamatic.Doncamatic.controllers.requests.ProdutoRequest;
import br.com.doncamatic.Doncamatic.controllers.responses.ProdutoResponse;
import br.com.doncamatic.Doncamatic.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    //insert - post - save
    @PostMapping
    public ResponseEntity<String> postProduto(@RequestBody ProdutoRequest produtoRequest) {
        try{
            produtoService.post(produtoRequest);
            return new ResponseEntity<>("Produto salvo com sucesso", HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Produto não salvo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update - put
    @PutMapping(value="/{id}")
    public ResponseEntity<String>putProduto(@PathVariable("id") Long id,@RequestBody ProdutoRequest produtoRequest) {
        if (produtoService.exists(id)) {
            try {
                produtoService.put(id, produtoRequest);
                return new ResponseEntity<>("produto salvo com sucesso", HttpStatus.ACCEPTED);

            } catch (Exception e) {
                return new ResponseEntity<>("Erro, produto não salvo", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);

    }

    //delete - excluir
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String >deleteFuncao(@RequestParam Long id){
        try{
            produtoService.delete(id);
            return new ResponseEntity<>("Deletado com sucesso!",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Não foi possível deletar a postagem",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //get one - findById
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<ProdutoResponse> getById(@RequestParam Long id){
        ProdutoResponse produtoResponse = produtoService.getById(id);
        if(produtoResponse.equals(null)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtoResponse,HttpStatus.ACCEPTED);
    }

    //getByString
    @RequestMapping(value="/{titulo}",method = RequestMethod.GET)
    public ResponseEntity<List<ProdutoResponse>> findByTitulo(@RequestParam String titulo){
        List<ProdutoResponse> listaProdutos = produtoService.getByTitulo(titulo);
        if(listaProdutos.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaProdutos,HttpStatus.ACCEPTED);
    }


    //get all
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> getAllSolicitacaoResponse(){
        List<ProdutoResponse> listaProdutos = produtoService.getAll();
        if(listaProdutos.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaProdutos, HttpStatus.ACCEPTED);
    }





}
