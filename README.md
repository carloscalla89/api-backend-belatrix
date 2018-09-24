# Para iniciar el API
el api cargará por defecto al puerto 8080. Se puede cambiar en el application.properties descomentando la etiqueta 
server.port=8091

# Ejemplos de URIs
# Endpoint Cotización
http://localhost:8091/money-exchange/exchangeRate?base=USDs&target=EUR&amount=100

# Endpoint Loguin
http://localhost:8091/money-exchange/login
{ "username": "carlos", "password": "1234" }
