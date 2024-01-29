package br.com.doncamatic.Doncamatic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Usuario")
public class User  {

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

    @Column(nullable =  true, unique = false)
    private List<Role> roles;


}
