# Representação Externa de Dados em Java

Este repositório contém a implementação de soluções de serialização e desserialização de dados em Java, desenvolvidas para a disciplina de Sistemas Computacionais Distribuídos.

O objetivo principal é demonstrar na prática como transformar objetos Java (POJOs) em formatos binários eficientes para tráfego em rede e armazenamento, utilizando três tecnologias de mercado.

## Bibliotecas Utilizadas

O projeto utiliza o **Maven** para o gerenciamento de dependências. As seguintes bibliotecas foram configuradas no arquivo `pom.xml`:

* **MessagePack:** `jackson-dataformat-msgpack` (versão 0.9.3) - Transforma os objetos em um formato binário compacto, usando a interface simples da biblioteca Jackson.
* **Apache Avro:** `avro` (versão 1.11.3) - Utilizada com o recurso interno de reflexão (`ReflectData`) para gerar o esquema direto das classes dinamicamente, sem precisar de arquivos externos.
* **Protocol Buffers (Protostuff):** `protostuff-core` e `protostuff-runtime` (versão 1.8.0) - Uma alternativa prática no ecossistema Java que permite usar a alta performance do Protobuf nos POJOs comuns, sem precisar pré-compilar arquivos `.proto`.

## Como Rodar o Projeto

Para testar as implementações, siga os passos abaixo:

1. **Importe o projeto:** Abra o projeto em sua IDE de preferência (Eclipse, IntelliJ, VS Code) como um "Projeto Maven" para que as dependências sejam baixadas automaticamente.
2. **Navegue pelos pacotes:** Os códigos estão organizados por tecnologia nos pacotes (`br.edu.ifsuldeminas.mch.sd.messagepack`, `.avro`, `.protobuf`).
3. **Execute os testes:** Em cada pacote, existe uma classe `Main.java`. Execute-a como uma Aplicação Java.
4. **Verifique os resultados:** O console exibirá a confirmação de criação do arquivo e, logo em seguida, a impressão dos dados que foram recuperados com sucesso. Os arquivos físicos (`person.msgpack`, `person.avro`, `person.bin`) serão gerados na pasta raiz do projeto.

---

## Respostas do Tutorial

Abaixo estão as análises referentes às três tecnologias estudadas:

**1. Quais vantagens e desvantagens cada tecnologia apresenta?**
* **Protobuf:** A maior vantagem é a velocidade e o tamanho minúsculo do arquivo gerado. A desvantagem é que a configuração inicial nativa exige um pouco mais de trabalho (criação de contratos `.proto`).
* **Apache Avro:** A vantagem é que ele lida super bem com mudanças na estrutura dos dados ao longo do tempo (evolução de esquema). A desvantagem é que o arquivo final fica um pouco maior, pois o esquema é salvo junto com a informação.
* **MessagePack:** A principal vantagem é a simplicidade, funcionando quase como um "JSON binário". A desvantagem é não validar a estrutura de dados de forma tão rigorosa quanto o Protobuf.

**2. Em quais tipos de sistemas cada formato costuma ser utilizado?**
* **Protobuf:** Muito usado na comunicação interna entre microsserviços modernos (geralmente via gRPC).
* **Apache Avro:** É o padrão em Engenharia de Dados e ambientes de Big Data (como o ecossistema Hadoop e o Apache Kafka).
* **MessagePack:** Bastante usado em sistemas de cache velozes (como o Redis) e APIs que precisam de respostas rápidas com baixo consumo.

**3. Qual formato gerou o menor arquivo?**
O **Protobuf**. Ele é extremamente otimizado, convertendo os dados em binário sem precisar salvar os nomes das variáveis (chaves) no arquivo, armazenando apenas os valores organizados por índices.

**4. Qual formato foi mais simples de implementar?**
O **MessagePack**. Como a lógica dele se assemelha muito à do JSON, a adaptação foi imediata. Bastou importar a biblioteca e utilizar as classes `Person` e `Address` diretamente, sem necessidade de configurações extras de esquema.

**5. Qual formato parece mais adequado para Sistemas Distribuídos modernos?**
O **Protobuf**. Em arquiteturas modernas, desempenho de rede e padronização são essenciais. Ele cria um contrato forte que garante que sistemas escritos em linguagens totalmente diferentes consigam conversar entre si de forma fluida, segura e gastando pouquíssima banda.
