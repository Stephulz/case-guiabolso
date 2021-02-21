# Case Guiabolso - [Transações](https://case-guiabolso.herokuapp.com/1000/transacoes/2007/10)

[![Build Status](https://travis-ci.org/Stephulz/case-guiabolso.svg?branch=main)](https://travis-ci.org/Stephulz/case-guiabolso)
[![codecov](https://codecov.io/gh/Stephulz/case-guiabolso/branch/main/graph/badge.svg?token=K5NSN5R8PV)](https://codecov.io/gh/Stephulz/case-guiabolso)

#### Resumo:

API mock com a função de retornar uma lista de transações aleatórias.

```
[GET] /{id}/transacoes/{ano}/{mes}

Content-type: application/json

[
 {
  "descricao": "string(10, 120)"
  "data": "long(timestamp)"
  "valor": "integer(-9.999.999, 9.999.999)"
 }
]
```

## Regras de negócio

Requisição:

- a `requisição` será um __GET__
- a `requisição` deve respeitar o formato `[GET] /<id>/transacoes/<ano>/<mes>`
- os parâmetros `<id>`, `<ano>` e `<mês>` são o `conjunto de dados`

Transação:

- dado um `conjunto de dados`, deve ser retornada uma lista de transações
- cada _transação_ deve seguir o [contrato de transação](#Resumo)
- a lista de transações deve ter `um total de transações igual ao mês, multiplicado pelo primeiro dígito do id`. Ex.: id `2995`, mês `7`, `2 * 7 = 14 transações na lista`
- dado dois `conjuntos de dados` iguais, as respostas devem ser as mesmas
- isso significa que, para um mesmo id, mês e ano, deve ser retornada a mesma lista

Id:

- o id de usuário é um `número inteiro` de `1.000 a 100.000`

Descrição:

- cada transação deve ter `descrição aleatória legível`
- vocês devem criar a lógica para gerar essa `descrição aleatória legível`
- a descrição deve ter o tipo `string`
- essa `descrição aleatória legível` deve ser legível por humanos, isso significa que `YhCekEr13RH` não é válido, enquanto `chaconapotalo pocanoçale` é válido
- cada descrição deve ter no mínimo `10 caracteres`
- cada descrição não pode superar `60 caracteres`

Valor:

- cada transação deve ter um `valor baseado no id do usuário, no índice da transação e no mês`
- o valor da transação deve ser representado por um `número inteiro` (reais sem centavos)
- o valor da transação deve estar entre `-9.999.999 e 9.999.999`, inclusive

Data:

- cada transação deve ter uma `data aleatória` 
- o campo data deve ter o formato `timestamp` 
- o campo data deve ter o tipo `long`
- a data aleatória deve estar `dentro do range de ano e mês` dados

Tratamento de erro de input:

- utilize os `status HTTP` para representar os casos de exceção nas validações
- além do status, deve ser respondido o `motivo do erro`
