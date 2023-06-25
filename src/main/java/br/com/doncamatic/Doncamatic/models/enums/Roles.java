package br.com.doncamatic.Doncamatic.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return getAuthority();
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
