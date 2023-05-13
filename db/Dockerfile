FROM oracle/database:21.3.0-xe

# Establecer la variable de entorno para permitir conexiones de red externas
ENV LISTENER_NETWORKS="(ADDRESS=(PROTOCOL=TCP)(HOST=0.0.0.0)(PORT=1521))"

# Exponer el puerto 1521 para que otros contenedores y hosts puedan conectarse
EXPOSE 1521
