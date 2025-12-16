package com.ejercicio.cidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot CI Demo
 * 
 * Esta aplicación demuestra:
 * - Creación de controladores REST
 * - Implementación de tests unitarios
 * - Configuración de CI/CD con GitHub Actions
 */
@SpringBootApplication
public class CiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CiDemoApplication.class, args);
    }

}
