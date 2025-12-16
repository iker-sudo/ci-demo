package com.ejercicio.cidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador REST para endpoints de demostración
 * 
 * Proporciona tres endpoints básicos:
 * - GET /hello - Saludo simple
 * - GET /status - Estado de la aplicación
 * - GET /version - Versión de la aplicación
 */
@RestController
public class GreetingController {

    /**
     * Endpoint que devuelve un saludo
     * @return String con el mensaje de saludo
     */
    @GetMapping("/hello")
    public String hello() {
        return "¡Hola desde Spring Boot!";
    }

    /**
     * Endpoint que devuelve el estado de la aplicación
     * @return String con mensaje de estado
     */
    @GetMapping("/status")
    public String status() {
        return "La aplicación está funcionando correctamente";
    }

    /**
     * Endpoint que devuelve la versión actual
     * @return String con el número de versión
     */
    @GetMapping("/version")
    public String version() {
        return "Versión 1.0.0";
    }

    /**
     * Endpoint que devuelve información en formato JSON
     * @return ResponseEntity con información de la aplicación
     */
    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> info() {
        Map<String, String> info = new HashMap<>();
        info.put("appName", "CI Demo");
        info.put("version", "1.0.0");
        info.put("status", "running");
        info.put("framework", "Spring Boot 3.4");
        return ResponseEntity.ok(info);
    }
}
