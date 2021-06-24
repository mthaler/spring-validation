package com.mthaler.springvalidation.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@Configuration
@ComponentScan(basePackages = ["com.mthaler.springvalidation"])
class AppConfig {

    @Bean
    fun validator(): LocalValidatorFactoryBean? {
        return LocalValidatorFactoryBean()
    }
}