package com.example.metaversebackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Metaverse API", version = "1.0.0.0"),
        servers = {
                @Server(url = "http://localhost:8080/api/", description = "Local Server"),
                @Server(url = "https://facebook.com", description = "Bardagul Server"),
        }
)
public class MetaverseBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetaverseBackendApplication.class, args);
    }
}
