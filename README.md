## URl SHORTENER
________________________

### Sobre o Desafio
_______________

Através de uma chamada POST recber uma url para encurtamento.

`[POST] /shorten-url`
``` json 
    {
        "url": "https://github.com/GlauberBalsani"
    }
```
___________
E retorna o JSON com a url encurtada

`HTTP/1.1 200 OK`
```json
    {
        "url": "http://localhost:8080/shorten-url0Pm1qr0"
    }
```
