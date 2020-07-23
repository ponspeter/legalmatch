package com.legalmatch.exam.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories("com.legalmatch.exam.repository")
@EntityScan("com.legalmatch.exam.model")
@Configuration
public class JpaConfig {
}
