package br.com.doncamatic.Doncamatic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable =  true, unique = false)
    private String username;

    @Column(nullable =  true, unique = false)
    private String password;

    @Column(nullable =  true, unique = true)
    private String email;

}
