package br.com.doncamatic.Doncamatic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@Table(name = "Produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private Long id;

    @Column(nullable =  false, unique = false)
    private String titulo;

    @Column(nullable =  true, unique = false)
    private String descricao;

    @Column(nullable =  true, unique = false)
    private String imagem;

    public Produto(String titulo, String descricao, String imagem){
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
    }

}
