# teste-smartbot
Aplicação feita em Spring Boot(Java) Utilizando a base de dados MYSQL
Toda a persistência de dados foi feita utilizando a JPA as Entidades são criadas automaticamente no banco pelo hibernate
Utilizei a anotação @PostConstruct para executar o método assim que o contexto da aplicação foi iniciado
"insertPrimaryValuesForPrimaryRequest" e executado após o inicio do contexto. Ele insere no banco: ids, open_value,data e hora, e um valor minimo e máximo que são apenas para comparar posteriormente no metodo maxAndLowValues
"insertValuesFor1MinuteElapsed" atualiza os valores no banco, a cada um 1 minuto, pela anotação @Scheduled(fixedRate = "Tempo em milesimos")
"maxAndLowValues" busca os valores de max e min que estão no banco, compara com os valores que chegam da api, e caso max<apiValor a atualiação acontece. A mesma lógica e aplicada para o min(isso acontece a cada 5 ou 10 segundos, através do Sheduled)
Fiz dos intervalos 1,5 e 10 minutos entidades, cada um com sua tabela no banco.
No respository tenho as interações com o banco. Os Updates são especificos para cada método.
A Dockerização está funcional. Não cheguei a testar em outras máquinas, mas creio estar tudo bem.
Creio ter faltado o nome das moedas. infelizmente a api manda o objeto como "BTC_ETC":{} enquanto poderia ser {name : "BTC_ETC"} mas creio que não e dicil inputar os nomes no banco.
Os intervalos de atualização de 5 e 10 minutos sobre o high e low estão sendo feito de 10 segundos. O Impacto disso que os valores dessas duas tabelas não mostram realmente os valores dentro de 10 minutos e sim 10 segundos
O Docker Run possui propiedades para lidar com o fuso-horario. Dentro do container a aplicação puxava um fuso aleatório deixando asssim 3 horas a mais do fuso brasileiro.
o JDK utilizado no conteiner foi o 17 - Alpine
