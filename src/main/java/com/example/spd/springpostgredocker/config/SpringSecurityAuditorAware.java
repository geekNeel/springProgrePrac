package com.example.spd.springpostgredocker.config;


import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditorAware implements AuditorAware<String> {
	
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Geek");
    }
}
