package br.com.doncamatic.Doncamatic.controllers.requests;

public record CreateUserRequest(String nome, String email, String senha) {
}
