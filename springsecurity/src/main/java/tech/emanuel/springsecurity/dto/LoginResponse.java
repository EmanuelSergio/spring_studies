package tech.emanuel.springsecurity.dto;

public record LoginResponse(String acessToken, Long expiresIn) {
}
