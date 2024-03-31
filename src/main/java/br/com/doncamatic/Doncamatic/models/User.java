package br.com.doncamatic.Doncamatic.models;

import br.com.doncamatic.Doncamatic.models.enums.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Usuario")
public class User  implements UserDetails{


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
    private Roles role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //de para dos roles da aplicação com as do spring security
        if(this.role  == Roles.ADMIN)
            return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER")
            );
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));

    }

    public User(String nome, String email,String senha){
        this.username = nome;
        this.email = email;
        this.password = senha;
    }

    public User(String nome, String email){
        this.username = nome;
        this.email = email;
    }

    @Override
    public boolean isAccountNonExpired() {
        //USUARIO NUNCA EXPIRADO
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //USUARIO NUNCA BLOQUEADO
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //USUARIO NUNCA EXPIRADO
        return true;
    }

    @Override
    public boolean isEnabled() {
        //USUARIO SEMPRE HABILITADO
        return true;
    }
}
