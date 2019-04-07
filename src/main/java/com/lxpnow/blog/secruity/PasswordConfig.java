package com.lxpnow.blog.secruity;
//2019/3/8  9:58


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


class NoEncode implements PasswordEncoder {
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }


    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }

}