# kafka-restaurante consumidor
# Criar Restaurante:
```
curl --request POST \
  --url localhost:8082/clientes \
  --header 'Content-Type: application/json' \
  --data '
	{
	    "nomeFantasia":"Restaurante full",
	    "documento":"doc2",
	    "site":"www.restaurante.com.br",
	    "telefone":"3432212257"

}

```

# Buscar Restaurante

```
curl --request GET \
  --url localhost:8082/clientes/2\
  --header 'Content-Type: application/json' \
  --data '

```
