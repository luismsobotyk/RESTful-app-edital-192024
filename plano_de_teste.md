# Plano de Teste

## 1. Ferramentas
- Linguagem: Java
- IDE: IntelliJ
- Ferramenta de Verificação Estática: SonarLint
- Ferramenta de Teste Unitário: JUnit
- Ferramenta de Teste de Componente: Cypress
- Ambiente de Integração contínua

## 2. Procedimentos
1. Realizar commit no formato `[tipo]: descrição`.
2. Criar Pull Request com a descrição detalhada da modificação.
3. Realizar revisão do código antes de mergear.
4. Executar o pipeline no GitHub Actions após merge.

## 3. Instalação e uso das ferrametnas
### 3.1 SonarLint:
- [config/FileStorageConfig.java](src/main/java/com/example/restfulappedital192024/config/FileStorageConfig.java): Nenhum problema encontrado
- [controller/PublicationController.java](src/main/java/com/example/restfulappedital192024/controller/PublicationController.java): 4 problemas encontrados:
  - Linha 14: Constant names should comply with a naming convetion: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 14: Unused "private" fields should be removed: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 15: Unused "private" fields should be removed: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 17: Field dependency injection should be avoided: Remover afetaria o funcionamento
- [exceptions/ExceptionResponse.java](src/main/java/com/example/restfulappedital192024/exceptions/ExceptionResponse.java): Nenhum problema encontrado
- [exceptions/ResourceNotFoundException.java](src/main/java/com/example/restfulappedital192024/exceptions/ResourceNotFoundException.java): Nenhum problema encontrado
- [handler/CustomizedResponseEntityExceptionHandler.java](src/main/java/com/example/restfulappedital192024/handler/CustomizedResponseEntityExceptionHandler.java): 2 problemas encontrados:
  - Linha 26: The diamond operator ("<>") should be used: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 36: The diamond operator ("<>") should be used: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
- [model/Author.java](src/main/java/com/example/restfulappedital192024/model/Author.java): Nenhum problema encontrado
- [model/Label.java](src/main/java/com/example/restfulappedital192024/model/Label.java): Nenhum problema encontrado
- [model/Pubication.java](src/main/java/com/example/restfulappedital192024/model/Publication.java): 5 problemas encontrados
  - Linha 92: Methods should not be empty: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 203: Methods and field names should not be the same or differ only by capitalization: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 203: Methods should not have identical implementations: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 207: Methods should not have identical implementations: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 207: Methods and field names should not be the same or differ only by capitalization: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
- [model/PubicationLabel.java](src/main/java/com/example/restfulappedital192024/model/PublicationLabel.java): Nenhum problema encontrado
- [model/PubicationQualifier.java](src/main/java/com/example/restfulappedital192024/model/PublicationQualifier.java): Nenhum problema encontrado
- [model/Qualifier.java](src/main/java/com/example/restfulappedital192024/model/Qualifier.java): Nenhum problema encontrado
- [repository/LabelRepository.java](src/main/java/com/example/restfulappedital192024/repository/LabelRepository.java): Nenhum problema encontrado
- [repository/PublicationRepository.java](src/main/java/com/example/restfulappedital192024/repository/PublicationRepository.java): Nenhum problema encontrado
- [repository/QualifierRepository.java](src/main/java/com/example/restfulappedital192024/repository/QualifierRepository.java): Nenhum problema encontrado
- [services/PublicationServices.java](src/main/java/com/example/restfulappedital192024/services/PublicationServices.java): 5 problemas encontrados:
  - Linha 18: Field dependency injection should be avoided: Remover afetaria o funcionamento
  - Linha 21: Field dependency injection should be avoided: Remover afetaria o funcionamento
  - Linha 23: Field dependency injection should be avoided: Remover afetaria o funcionamento
  - Linha 67: Sections of code should not be commented out: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
  - Linha 89: String literals should not be duplicated: Resolvido ([`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/efa8d1d95a8ec91f7c18c863301eafbfd42c012b))
- [RestfulAppEdital192024Application.java](src/main/java/com/example/restfulappedital192024/ResTfulAppEdital192024Application.java): Nenhum problema encontrado

### 3.2 Junit:
- Foi criada a classe PublicationControllerTest para testar as 3 funcionalidades da api:
  - /findByDoi: Como a API não tem dados do jeito que foi desenvolvida pois trabalha com banco na memória sem persistência, apenas o status está sendo verificado e se o json de erro é retornado. [`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/0d17bae3ddf9ff2fe78040cface0788d75a227e7)
  - /findByYear/{year}: Como a API não tem dados do jeito que foi desenvolvida pois trabalha com banco na memória sem persistência, apenas o status está sendo verificado e se o json de erro é retornado. [`efa8d1d`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/0d17bae3ddf9ff2fe78040cface0788d75a227e7)

### 3.3 Cypress:
- Os testes e configs do Cypress foram adicionados no commit [`8da51f6`](https://github.com/luismsobotyk/RESTful-app-edital-192024/commit/40cfe51093d94fa55c80aca08571bd3153dd32da):
  - /findByDoi: Agora com dados, fiz um teste que busca pela DOI: 10.1080/16549716.2024.2330758 e checa se o JSON retornado bate com os dados esperados;
  - /findByYear: Fiz um teste buscando por 2024 e vendo se o retorno é o esperado e fiz um teste 2025 que deve retornar a mensagem de erro.




