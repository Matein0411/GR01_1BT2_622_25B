# Mini aplicación Taller (Usuarios y Vehículos)

Ejemplo didáctico que muestra cómo usar:
- Servlets/JSP para la capa web
- Hibernate ORM para persistencia

Contenido:
- Crear y listar Usuarios
- Crear y listar Vehículos asociados a un Usuario (ManyToOne)

Cómo ejecutar (resumen):
1. Compilar con Maven:

```bash
mvn -DskipTests package
```

2. Desplegar el WAR en un contenedor Jakarta EE / Servlet 6 (Tomcat 10+, Payara, etc.) o usar plugin de Jetty.

Notas:
- La configuración de Hibernate está en `src/main/resources/hibernate.cfg.xml`.
- Ajusta la URL/credenciales de la base de datos si es necesario.
- Endpoints principales:
  - /usuarios -> lista usuarios
  - /usuarios/nuevo -> formulario para crear usuario
  - /vehiculos -> lista vehículos
  - /vehiculos/nuevo -> formulario para crear vehículo (selecciona usuario)

Esto es un ejemplo mínimo pensado para aprendizaje. Puedes mejorar validaciones, manejo de errores, y la UI con CSS/Bootstrap.
