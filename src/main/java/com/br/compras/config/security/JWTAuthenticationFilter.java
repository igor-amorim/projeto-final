package com.br.compras.config.security;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response)
            throws AuthenticationException {
        try {
            LoginDto login = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginDto.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getEmail(),
                            login.getSenha(),
                            new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult)
            throws IOException, ServletException {
        String username = ((UsuarioDto) authResult.getPrincipal()).getUsername();
        List<String> roles = ((UsuarioDto) authResult.getPrincipal())
                .getAuthorities()
                .stream().map(role -> role.getAuthority())
                .collect(Collectors.toList());
        String token = JWTUtils.createToken(username, roles);
        response.getWriter().write(username + ": " + SecurityConstants.TOKEN_PREFIX + " " + token);
        response.getWriter().flush();
    }

}
