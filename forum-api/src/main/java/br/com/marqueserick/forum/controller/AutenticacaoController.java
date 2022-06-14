package br.com.marqueserick.forum.controller;

import br.com.marqueserick.forum.config.security.TokenService;
import br.com.marqueserick.forum.controller.dto.TokenDto;
import br.com.marqueserick.forum.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
        try{
            Authentication authentication = auth.authenticate(form.converter());
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token,"Bearer"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
