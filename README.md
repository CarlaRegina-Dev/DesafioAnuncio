<h3 align="center">
  Desafio Anúncio Capgemini.
</h3>

<p align="center">
Considere os seguintes critérios fictícios para desenvolver o cadastro de anúncios: 
Crie um sistema que permita o cadastro de anúncios. O anúncio deverá conter os seguintes dados:

- nome do anúncio
- cliente
- data de início
- data de término
- investimento por dia
 
O sistema fornecerá os relatórios de cada anúncio contendo:
valor total investido

`quantidade máxima de visualizações`
`quantidade máxima de cliques`
`quantidade máxima de compartilhamentos`

Os relatórios poderão ser filtrados por intervalo de tempo e cliente.</p>
 

## Tecnologias Utilizadas:

- java 11
- Spring Boot 2.4.5 
- Mysql 
- swagger



## Instruções:
`Para acessar o sistema utlize a rota http://localhost:8080/swagger-ui.html`

- O swagger da aplicação anuncio receber data no formato dd/MM/yyyy.
- O swagger da aplicação anuncio receber valores financeiros com casas décimais sepradas por ponto.
- Utilize "listar anuncio por filtro" para saber o relatório como pedido no desafio, contendo: .valor total - investido .quantidade máxima de visualizações .quantidade máxima de cliques .quantidade máxima de - compartilhamentos .filtrados por intervalo de tempo e cliente
- Para realizar a consulta por filtro passe nome do cliente data inicio e fim no formato dd/MM/yyyy.
 
 
