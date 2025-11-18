Guía de pruebas con Postman (Streaming-Java)

Prerequisitos
- App corriendo en `http://localhost:8080`.
- Base de datos accesible según `application.properties`.

Importación
- Importa `postman/Streaming-Java.postman_collection.json`.
- Importa `postman/Streaming-Java.postman_environment.json` y selecciónalo.
- Ajusta `baseUrl` si tu puerto/host es distinto.

Flujo recomendado
- Auth → Login: envía `{ "username": "correo@dominio", "password": "clave" }`.
  - El test guarda `token` en el entorno automáticamente.
- Usuarios/Planes: ejecuta cualquier request; usan `Authorization: Bearer {{token}}`.

Endpoints incluidos
- `POST {{baseUrl}}/auth/login`.
- `GET {{baseUrl}}/usuarios/obtener`, `GET {{baseUrl}}/usuarios/{{id}}`, `POST {{baseUrl}}/usuarios/`, `DELETE {{baseUrl}}/usuarios/{{id}}`.
- `GET {{baseUrl}}/planes/obtener`, `GET {{baseUrl}}/planes/{{id}}`, `POST {{baseUrl}}/planes/`, `DELETE {{baseUrl}}/planes/{{id}}`.

Notas
- Cambia la variable `id` en el entorno para probar GET/DELETE dinámicos.
- Si la seguridad exige JWT para estos endpoints, asegúrate de hacer login primero.
- Para datos de ejemplo, ajusta cuerpos JSON según tu esquema real.