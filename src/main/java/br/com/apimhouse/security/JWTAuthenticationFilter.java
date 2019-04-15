package br.com.apimhouse.security;

import br.com.apimhouse.dto.CredentialsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JWTUseful jwtUseful;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUseful jwtUseful) {
        this.authenticationManager = authenticationManager;
        this.jwtUseful = jwtUseful;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

       try{
           CredentialsDTO credentialsDTO = new ObjectMapper()
                                            .readValue(request.getInputStream(),CredentialsDTO.class);
           UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(credentialsDTO.getUsername(),credentialsDTO.getPassword(), new ArrayList<>());

           return authenticationManager.authenticate(authenticationToken);
       }catch (IOException e){
           throw new RuntimeException(e);
       }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        String username = ((UserSS) authResult.getPrincipal()).getUsername();
        String token = jwtUseful.generateToken(username);
        response.addHeader("Authorization","Bearer " + token);

    }
}
