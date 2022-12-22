package me.boujdi.metier;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("me.boujdi")
@EnableAspectJAutoProxy
public class Config {
}
