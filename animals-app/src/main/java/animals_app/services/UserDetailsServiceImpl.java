package animals_app.services;/*package com.github.naut92.animals_app.services;


import Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private CustomerServiceOld customerService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String customerEmail) throws UsernameNotFoundException {

        Customer customer = customerService.findByEmail(customerEmail);
        System.out.println("email is: " + customerEmail);

        for (RolesEntity role : customer.getRoles()){
            System.out.println(role.toString());
        }

*//*test
        String p = "12A34";
        BCryptPasswordEncoder pe= new BCryptPasswordEncoder();
        String encPassword =pe.encode(p);
        System.out.println("HELLB  ---->  " + encPassword);
*/
        //load returns null, saw in debug mode
        /*
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RolesEntity role : customer.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoles()));
        }

        return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPass(), grantedAuthorities);*//*

        List<GrantedAuthority> authorities = buildUserAuthority(customer.getRoles());
        return buildUserForAuthentication(customer, authorities);
    }

    private UserDetails buildUserForAuthentication(Customer customer,
                                                   List<GrantedAuthority> authorities) {
        return new User(customer.getEmail(), customer.getPass(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<RolesEntity> roles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        for (RolesEntity role : roles){
            setAuths.add(new SimpleGrantedAuthority(role.getRoles()));
        }
        List<GrantedAuthority> result = new ArrayList<>(setAuths);

        return result;
    }
}*/