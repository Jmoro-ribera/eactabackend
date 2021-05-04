# E-Acta Backend

## Descargar

### Git clone

Podeís descargarlo con la url: `git clone https://github.com/Jmoro-ribera/eactabackend.git` o si tenéis un clave ssh protegida con contraseña en gitHub: `git clone git@github.com:Jmoro-ribera/eactabackend.git`

## Base de Datos

La carpeta con los datos de la base de datos se encuentran en `src/main/resources`.

**Seguid los siguientes pasos:**

1. Tenéis que sacar la carpeta de ahí y colocarla dónde creáis conveniente.
1. **Cambiad** la dirección de la carpeta en `src/main/resources/aplication.properties`. 

**Recordatorio**: `file:~/` indica vuestro directorio **home**.

## Direcciones

**Recordatorio**: los **{}**, indica donde teneis que poner la información, cuando paséis la dirección.

### Usuarios

* `/api/usuarios/`: Como petición **GET**, devuelve todos los usuarios.
* `/api/usuarios/email/{email}`: Devuelve el usuario que tenga ese correo electrónico.
* `/api/usuarios/{id}`: Como petición **GET**, devuelve el usuario con ese id.
* `/api/usuarios/`: Como petición **POST**, sube un usuario a la BBDD.
* `/api/usuarios/{id}`: Como petición **PUT**, cambia los datos del usuario que tenga ese id en la BBDD.
* `/api/usuarios/{id}`: Como petición **DELETE**, borra el usuario que tenga ese id en la BBDD.

### Rol

* `/api/roles/`: Como petición **GET**, devuelve todos los roles.
* `/api/roles/{id}`: Como petición **GET**, devuelve el rol que tenga ese id.
* `/api/roles/`: Como petición **POST**, sube un rol a la BBDD.
* `/api/roles/{id}`: Como petición **PUT**, cambia los datos del rol que tenga ese id en la BBDD
* `/api/roles/{id}`: Como petición **DELETE**, borra el rol que tenga ese id en la BBDD.

## Funcionalidad

* `/api/funcionalidad/`: Como petición **GET**, devuelve todas las funcionalidades.
* `/api/funcionalidad/{id}`: Como petición **GET**, devuelve la funcionalidad que tenga ese id.
* `/api/funcionalidad/`: Como petición **POST**, sube una funcionalidad a la BBDD.
* `/api/funcionalidad/{id}`: Como petición **PUT**, cambia los datos de la funcionalidad que tenga ese id en la BBDD
* `/api/funcionalidad/{id}`: Como petición **DELETE**, borra la funcionalidad que tenga ese id en la BBDD.

### Asignaturas

* `/api/asignaturas/`: Como petición **GET**, devuelve todas las asignaturas.
* `/api/asignaturas/{id}`: Como petición **GET**, devuelve la asignatura que tenga ese id.
* `/api/asignaturas/`: Como petición **POST**, sube una asignatura a la BBDD.
* `/api/asignaturas/{id}`: Como petición **PUT**, cambia los datos de la asignatura que tenga ese id en la BBDD.
* `/api/asignaturas/{id}`: Como petición **DELETE**, borra la asignatura que tenga ese id en la BBDD.

### AlumnosNotaAsignatura

* `/api/notas/`: Como petición **GET**, devuelve todas las notas.
* `/api/notas/{id}`: Como petición **GET**, devuelve la nota que tenga ese id.
* `/api/notas/alumnos/{usuario}`: Devuelve las notas de un alumno que tenga ese id.
* `/api/notas/asignaturas/{asignatura}`: Devuelve las notas de una asignatura que tenga ese id.
* `/api/notas/get/alumno/{idAlumno}/{idAsignatura}`: Devuelve la nota del alumno que tenga ese id, de la asignatura que tenga ese id.
* `/api/notas/`: Como petición **POST**, sube una nota a la BBDD.
* `/api/notas/put/alumno/{idAlumno}/{idAsignatura}/{nota}`: Como petición **PUT**, cambia los datos de la nota que tenga ese id de alumnos, ese id de asignatura, por la nota que pone en la dirección en la BBDD.
* `/api/notas/{id}`: Como petición **DELETE**, borra la nota que tenga ese id en la BBDD.