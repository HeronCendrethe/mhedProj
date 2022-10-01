package br.com.smartbot.mhedtech.entity;


import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Collection;

@Table(name = "usuario")
@Entity
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer usuarioId;

    @Column(nullable = false)
    @NotBlank(message = "O nome não pode ser vazio")
    @Length(min = 5, max = 100)
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "O setor não pode ser vazio")
    private String setor;

    private LocalDateTime dataMaq;

    @OneToOne( fetch = FetchType.LAZY)
    private MaquinaEntity maquina;









    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

