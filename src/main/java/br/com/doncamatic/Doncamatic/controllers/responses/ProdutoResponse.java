package br.com.doncamatic.Doncamatic.controllers.responses;

import br.com.doncamatic.Doncamatic.models.Produto;

public record ProdutoResponse(Long id, String titulo, String descricao, String imagem) {
    public ProdutoResponse(Long id,String titulo, String descricao, String imagem)
    {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;

    }

}
