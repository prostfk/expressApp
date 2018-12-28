package by.bntu.fitr.povt.maxpeep.sevice;

import by.bntu.fitr.povt.maxpeep.model.entity.User;
import by.bntu.fitr.povt.maxpeep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        if (user.getUsername().equals("admin")){
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else{
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        System.out.println(roles);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);

    }
}
