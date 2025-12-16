# CI Demo - Proyecto Spring Boot con GitHub Actions

[![CI Pipeline](https://github.com/iker-sudo/ci-demo/actions/workflows/ci.yml/badge.svg)](https://github.com/iker-sudo/ci-demo/actions)

## 📋 Descripción

Proyecto educativo de **Integración Continua (CI)** con Spring Boot 3.4 y GitHub Actions. Demuestra:

- ✅ Creación de un proyecto Spring Boot con Maven
- ✅ Desarrollo de controladores REST
- ✅ Tests unitarios con JUnit 5
- ✅ Pipeline automático de CI/CD con GitHub Actions
- ✅ Empaquetado y distribución de artefactos

## 🛠 Tecnologías

- **Spring Boot** 3.4.0
- **Java** 21
- **Maven** (gestión de dependencias)
- **JUnit 5** (tests unitarios)
- **GitHub Actions** (CI/CD)
- **MockMvc** (testing de controladores)

## 📁 Estructura del Proyecto

```
ci-demo/
├── .github/
│   └── workflows/
│       └── ci.yml                    # Pipeline de GitHub Actions
├── src/
│   ├── main/
│   │   ├── java/com/ejercicio/cidemo/
│   │   │   ├── CiDemoApplication.java
│   │   │   └── controller/
│   │   │       └── GreetingController.java  # Controlador REST
│   │   └── resources/
│   │       └── application.properties       # Configuración
│   └── test/
│       └── java/com/ejercicio/cidemo/
│           └── controller/
│               └── GreetingControllerTest.java # Tests
├── pom.xml                           # Configuración Maven
├── .gitignore
└── README.md
```

## 🚀 Endpoints REST

### GET /hello
```bash
curl http://localhost:8080/hello
```
**Respuesta:**
```
¡Hola desde Spring Boot!
```

### GET /status
```bash
curl http://localhost:8080/status
```
**Respuesta:**
```
La aplicación está funcionando correctamente
```

### GET /version
```bash
curl http://localhost:8080/version
```
**Respuesta:**
```
Versión 1.0.0
```

### GET /info
```bash
curl http://localhost:8080/info
```
**Respuesta:**
```json
{
  "appName": "CI Demo",
  "version": "1.0.0",
  "status": "running",
  "framework": "Spring Boot 3.4"
}
```

## 🧪 Tests

Los tests verifican que cada endpoint:
1. Devuelve status HTTP 200
2. Retorna el contenido exacto esperado
3. Maneja correctamente requests 404

### Ejecutar tests localmente

```bash
mvn test
```

### Ejecutar un test específico

```bash
mvn test -Dtest=GreetingControllerTest#testHelloEndpoint
```

## 🔧 Compilación y Ejecución Local

### Prerequisitos

- **Java 21** (o superior)
- **Maven 3.8+**

### Compilar

```bash
mvn clean compile
```

### Empaquetar

```bash
mvn package
```

Esto genera: `target/ci-demo-1.0.0.jar`

### Ejecutar la aplicación

```bash
# Opción 1: Con Maven
mvn spring-boot:run

# Opción 2: Directamente con Java
java -jar target/ci-demo-1.0.0.jar
```

La aplicación estará disponible en: `http://localhost:8080`

## 🔄 Pipeline de GitHub Actions

### Flujo de CI

Cada `push` a `main` o `develop`, y cada `pull_request` a `main` dispara:

1. **Checkout** - Descarga el código
2. **Setup Java 21** - Configura JDK y cachea dependencias
3. **Build** - Compila con `mvn clean compile`
4. **Tests** - Ejecuta `mvn test`
5. **Package** - Genera JAR con `mvn package`
6. **Upload Artifacts** - Guarda el JAR por 30 días
7. **Summary** - Muestra resumen de la ejecución

### Ver el Pipeline

En GitHub:
1. Ir a `Actions` en el repositorio
2. Seleccionar el workflow `CI Pipeline`
3. Ver detalles de cada ejecución

### Descargar Artefactos

1. En `Actions`, seleccionar la ejecución exitosa
2. En la sección "Artifacts", descargar `ci-demo-jar`
3. El JAR estará disponible durante 30 días

## 📊 Estados del Pipeline

| Estado | Significado |
|--------|-------------|
| 🟢 Verde | Todos los tests pasaron, JAR generado |
| 🔴 Rojo | Error en compilación o tests fallaron |
| 🟡 Amarillo | Pipeline en ejecución |
| ⚪ Gris | Pipeline nunca ejecutado |

## 🐛 Debugging

### Test falla pero funciona localmente

1. Verifica que la respuesta sea **exactamente igual** (incluyendo espacios)
2. En MockMvc usa `content().string()` para strings exactos
3. Usa `containsString()` para búsquedas parciales

### Pipeline falla en GitHub pero funciona local

1. Verifica la versión de Java: `java -version`
2. Verifica versión de Maven: `mvn -v`
3. Borra caché local: `rm -rf ~/.m2/repository`
4. Intenta: `mvn clean install`

### YAML syntax errors

1. Valida el archivo en: https://yamllint.com/
2. Recuerda: **solo espacios**, nunca tabs
3. La indentación es crítica en YAML

## 📚 Recursos

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [Maven Documentation](https://maven.apache.org/)

---

**Última actualización:** Diciembre 2025