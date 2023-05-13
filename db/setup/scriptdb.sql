-- Crear la conexión a la base de datos
ALTER SESSION SET CONTAINER=ORCLPDB1;

-- Crear el usuario myuser y otorgar permisos
CREATE USER c##maestria IDENTIFIED BY admin123;
GRANT CONNECT, RESOURCE TO c##maestria;
ALTER USER c##maestria QUOTA UNLIMITED ON USERS;

