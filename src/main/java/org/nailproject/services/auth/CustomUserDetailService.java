package org.nailproject.services.auth;

import lombok.RequiredArgsConstructor;
import org.nailproject.repository.ClientRepositoryJPA;
import org.nailproject.security.ClientUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final ClientRepositoryJPA clientRepositoryJPA;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return clientRepositoryJPA.getClientByEmail(email)
                .map(ClientUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User with email : " + email + " not found"));
    }
}
