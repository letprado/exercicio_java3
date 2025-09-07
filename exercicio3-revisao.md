# Exercício 3 — Sistema de Locadora de Veículos

## 1. Contextualização

Uma empresa de locação de veículos precisa de um sistema simples para gerenciar seu catálogo de veículos, os dados de clientes e os contratos de locação. O objetivo deste exercício é modelar e implementar, em Java, os elementos essenciais de uma locadora, aplicando os princípios de orientação a objetos (OO).

## 2. Entidades e Conceitos

- **Veículo (classe abstrata)**  
  - Atributos comuns: placa, marca, modelo, ano.  
  - Métodos: cálculo de tarifa-base para locação.  
- **Tipos de Veículos (interfaces ou subclasses)**  
  - *Carro*, *Moto* e *Utilitário* devem especializar `Veículo`.  
  - Atributos específicos:  
    - Carro: quantidade de portas.  
    - Moto: cilindrada.  
    - Utilitário: capacidade de carga (em kg).  
  - Cada tipo implementa ou sobrescreve o método de cálculo da tarifa, acrescentando fatores específicos.
- **Cliente**  
  - Atributos: nome, CPF/CNPJ, endereço, telefone.  
  - Métodos: getters e setters com validação básica.
- **Contrato de Locação**  
  - Atributos: cliente, veículo, data de início, data de término, valor calculado.  
  - Métodos: emitir contrato, finalizar contrato e calcular valor total (aplicando descontos ou acréscimos conforme o tipo de veículo e tempo de locação).

## 3. Requisitos Técnicos

1. **Encapsulamento:** todos os atributos devem ser privados, com acesso controlado via métodos públicos.  
2. **Herança e interfaces:** `Veículo` deve ser abstrata e servir de base para `Carro`, `Moto` e `Utilitário`. Se julgar apropriado, crie uma interface adicional (`Tarifável`) para definir o contrato de cálculo de tarifa.  
3. **Polimorfismo:** o cálculo de tarifa em contratos deve ser feito através de referências do tipo `Veículo`/`Tarifável`, permitindo que cada tipo de veículo defina seu próprio valor.  
4. **Validações:**  
   - Verificar que a placa segue um formato válido.  
   - Não permitir contratos com datas inconsistentes (término antes do início).  
   - Garantir que um veículo disponível não seja locado duas vezes simultaneamente.

## 4. Tarefas Propostas

- **Modelagem:** elaborar um diagrama de classes (pode ser informal) indicando atributos e métodos de cada classe descrita.  
- **Implementação:** codificar as classes em Java 17 ou superior, seguindo as boas práticas de OO.  
- **Fluxo de Teste (no método `main`):**  
  1. Cadastrar alguns clientes e veículos de cada tipo.  
  2. Criar contratos de locação com diferentes durações.  
  3. Exibir a lista de veículos disponíveis e de contratos ativos.  
  4. Calcular valores de locação aplicando tarifas diferenciadas conforme o veículo.  
- **Documentação:** incluir comentários em português explicando a finalidade de cada classe e os motivos das escolhas de design.

## 5. Critérios de Avaliação

- Correção na aplicação dos pilares de OO.  
- Coerência da modelagem e clareza na separação de responsabilidades.  
- Implementação das validações e tratamento de possíveis erros.  
- Legibilidade e organização do código.