# Enunciado — Rede Social Acadêmica (Hands-on)

## 1. Contextualização do Problema

As redes sociais fazem parte do cotidiano de todos nós. Elas permitem que usuários criem publicações, interajam entre si e participem de comunidades com interesses em comum.  

Neste exercício, o desafio é desenvolver, em **Java**, um protótipo simplificado de uma **Rede Social Acadêmica**, voltada para alunos e professores de uma instituição de ensino. O objetivo não é reproduzir todas as funcionalidades de uma rede social comercial, mas sim aplicar, de forma prática, os conceitos fundamentais da **Orientação a Objetos (OO)**: **encapsulamento, herança, polimorfismo e abstração**.  

---

## 2. Cenário

O sistema deve atender às seguintes necessidades:

- **Usuários:** haverá dois tipos principais de usuários:
  - **Aluno**, que pode criar publicações, seguir outros usuários e participar de grupos de estudo.
  - **Professor**, que além das funcionalidades comuns, tem a capacidade de criar grupos de estudo.

- **Publicações:** os usuários podem criar publicações de diferentes tipos:
  - **Texto**, contendo apenas um conteúdo textual.
  - **Imagem**, contendo uma URL e uma legenda.
  - **Vídeo**, contendo uma URL e a duração em segundos.

- **Interações:** sobre cada publicação, os usuários podem:
  - **Comentar**, desde que o texto não seja vazio.
  - **Curtir**, sendo permitido apenas uma curtida por usuário em cada publicação.

- **Grupos de Estudo:** os professores podem criar grupos de estudo. Alunos e professores podem participar desses grupos e publicar dentro deles. O dono do grupo é sempre o professor que o criou.

- **Feeds:** o sistema deve oferecer dois tipos de feed:
  - **Feed Global**, exibindo todas as publicações da rede em ordem cronológica inversa.
  - **Feed do Usuário**, exibindo publicações das pessoas seguidas por ele e dos grupos de que participa.

---

## 3. Regras de Negócio

1. O endereço de e-mail do usuário deve ser validado, contendo obrigatoriamente o caractere `@` e um domínio simples.  
2. Uma publicação não pode ser criada vazia (texto em branco, URL ausente ou duração inválida).  
3. Comentários devem ter texto não vazio.  
4. Cada usuário pode curtir uma publicação apenas uma vez.  
5. Apenas professores podem criar grupos de estudo.  
6. Nomes de grupo não podem ser vazios.  
7. Somente membros podem publicar dentro de um grupo.  

---

## 4. Estrutura Esperada

O sistema deverá ser implementado em **Java 17 ou superior**, sem uso de frameworks externos. A aplicação será executada em console.  

### Classes e responsabilidades mínimas

- **Usuario (abstrata):**  
  Atributos essenciais (`id`, `nome`, `email`). Métodos para seguir outros usuários, entrar em grupos e obter informações.  

- **Aluno** e **Professor (subclasses de Usuario):**  
  Professor deve possuir a capacidade de criar grupos de estudo.  

- **Publicacao (abstrata):**  
  Campos básicos (`id`, `autor`, `dataHora`, reações, comentários). Métodos abstratos para renderização.  

- **PubTexto, PubImagem, PubVideo (subclasses de Publicacao):**  
  Cada uma com atributos específicos e implementação própria do método de renderização.  

- **Comentario:**  
  Representa comentários feitos em publicações, contendo autor, texto e data/hora.  

- **GrupoEstudo:**  
  Possui dono (professor), nome, lista de membros e publicações. Deve permitir a entrada de novos membros e a postagem de publicações.  

- **Serviços auxiliares (opcional, recomendável):**  
  Classes responsáveis por manipular coleções de usuários, publicações e grupos, além da geração dos feeds.  

---

## 5. Requisitos Técnicos

- Todos os atributos devem ser **privados** (encapsulamento).  
- `id` das entidades deve ser imutável.  
- Exceções devem ser lançadas em casos de violação das regras de negócio. Recomenda-se a criação de uma exceção customizada (`RegraNegocioException`).  
- Coleções (`List`, `Set`, `Map`) devem ser utilizadas sempre que necessário para armazenar membros, seguidores, curtidas e comentários.  
- Métodos `equals` e `hashCode` devem ser implementados quando necessário para evitar duplicações em conjuntos.  
- O método `toString()` deve ser implementado de forma clara para facilitar a visualização no console.  

---

## 6. Demonstração Esperada no Método Main

O programa principal (`Main`) deverá conter um roteiro mínimo de execução que comprove as funcionalidades:

1. Criação de usuários (professores e alunos).  
2. Criação de um grupo de estudo por um professor.  
3. Participação de alunos no grupo.  
4. Criação de diferentes tipos de publicações (texto, imagem e vídeo).  
5. Comentários e curtidas em publicações.  
6. Exibição do Feed Global.  
7. Exibição do Feed de pelo menos dois usuários distintos, mostrando diferenças de acordo com quem eles seguem e em quais grupos participam.  

---

## 7. Critérios de Avaliação

- Correta aplicação dos pilares da Orientação a Objetos.  
- Modelagem clara e coesa das classes.  
- Encapsulamento e validações adequadas.  
- Utilização correta de coleções.  
- Tratamento de erros por meio de exceções personalizadas.  
- Clareza do código (nomes significativos, responsabilidade bem definida por classe).  
- Demonstração funcional completa no console.  

---

Este exercício terá duração de **duas horas** e deverá ser desenvolvido integralmente em sala de aula. Ao final, espera-se que cada grupo ou estudante apresente a execução de seu programa demonstrando as funcionalidades previstas.  