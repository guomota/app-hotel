package br.com.fatec.apphotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.fatec.apphotel.modelo.Funcionario;
import br.com.fatec.apphotel.repository.FuncionarioRepository;

@Component
public class CustomerUserDetailService implements UserDetailsService {
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public CustomerUserDetailService (FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
       Optional<Funcionario> funcionario = Optional.ofNullable (funcionarioRepository.findByUsuario ( usuario ) )
                .orElseThrow ( ()-> new UsernameNotFoundException ("Usuario não encontrado") );
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList ( "ROLE_USER","ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList ( "ROLE_USER");
        return new org.springframework.security.core.userdetails.User ( funcionario.get ().getUsuario (), funcionario.get ().getSenha (),
                funcionario.get ().getPermissao ().equals ( "ADMIN" )? authorityListAdmin : authorityListUser  );
    }
}
