package com.ejercicio.cidemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

/**
 * Tests unitarios para el GreetingController
 * 
 * Usa @WebMvcTest para cargar solo el contexto necesario de Spring MVC
 * MockMvc permite simular requests HTTP sin arrancar el servidor completo
 */
@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test para verificar que el endpoint /hello devuelve el saludo correcto
     * 
     * Verificaciones:
     * 1. Status HTTP 200 (OK)
     * 2. Contenido exacto: "¡Hola desde Spring Boot!"
     */
    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("¡Hola desde Spring Boot!"));
    }

    /**
     * Test para verificar que el endpoint /status devuelve el estado correcto
     * 
     * Verificaciones:
     * 1. Status HTTP 200 (OK)
     * 2. Contenido exacto: "La aplicación está funcionando correctamente"
     */
    @Test
    void testStatusEndpoint() throws Exception {
        mockMvc.perform(get("/status"))
                .andExpect(status().isOk())
                .andExpect(content().string("La aplicación está funcionando correctamente"));
    }

    /**
     * Test para verificar que el endpoint /version devuelve la versión correcta
     * 
     * Verificaciones:
     * 1. Status HTTP 200 (OK)
     * 2. Contenido exacto: "Versión 1.0.0"
     */
    @Test
    void testVersionEndpoint() throws Exception {
        mockMvc.perform(get("/version"))
                .andExpect(status().isOk())
                .andExpect(content().string("Versión 1.0.0"));
    }

    /**
     * Test para verificar que el endpoint /info devuelve JSON con datos correctos
     * 
     * Verificaciones:
     * 1. Status HTTP 200 (OK)
     * 2. Content-Type es application/json
     * 3. El JSON contiene las claves esperadas
     */
    @Test
    void testInfoEndpoint() throws Exception {
        mockMvc.perform(get("/info"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("appName")))
                .andExpect(content().string(containsString("CI Demo")))
                .andExpect(content().string(containsString("version")))
                .andExpect(content().string(containsString("1.0.0")));
    }

    /**
     * Test para verificar que un endpoint inexistente devuelve 404
     * 
     * Verificaciones:
     * 1. Status HTTP 404 (Not Found) para ruta que no existe
     */
    @Test
    void testNotFoundEndpoint() throws Exception {
        mockMvc.perform(get("/endpoint-inexistente"))
                .andExpect(status().isNotFound());
    }
}
