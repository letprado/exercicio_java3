## Estrutura das Classes

```
┌─────────────────────────────────────────────────────────────────┐
│                        Tarifavel (interface)                   │
├─────────────────────────────────────────────────────────────────┤
│ + calcularTarifaBase(): double                                  │
│ + calcularTarifaComFator(double): double                        │
└─────────────────────────────────────────────────────────────────┘
                                        ▲
                                        │ implements
┌─────────────────────────────────────────────────────────────────┐
│                        Veiculo (abstract)                      │
├─────────────────────────────────────────────────────────────────┤
│ - placa: String                                                 │
│ - marca: String                                                 │
│ - modelo: String                                                │
│ - ano: int                                                      │
│ - disponivel: boolean                                           │
├─────────────────────────────────────────────────────────────────┤
│ + Veiculo(String, String, String, int)                         │
│ + getPlaca(): String                                            │
│ + getMarca(): String                                            │
│ + getModelo(): String                                           │
│ + getAno(): int                                                 │
│ + isDisponivel(): boolean                                       │
│ + setDisponivel(boolean): void                                  │
│ + calcularTarifaBase(): double (abstract)                       │
│ + calcularTarifaComFator(double): double                        │
│ + toString(): String                                            │
│ + equals(Object): boolean                                       │
│ + hashCode(): int                                               │
│ - validarPlaca(String): boolean                                 │
└─────────────────────────────────────────────────────────────────┘
                                        ▲
                                        │ extends
                    ┌───────────────────┼───────────────────┐
                    │                   │                   │
┌───────────────────▼───┐    ┌─────────▼─────────┐    ┌────▼────────────┐
│        Carro          │    │        Moto        │    │   Utilitario    │
├───────────────────────┤    ├───────────────────┤    ├─────────────────┤
│ - quantidadePortas:   │    │ - cilindrada: int │    │ - capacidadeCarga│
│   int                 │    │                   │    │   : double       │
├───────────────────────┤    ├───────────────────┤    ├─────────────────┤
│ + Carro(...)          │    │ + Moto(...)       │    │ + Utilitario(...)│
│ + getQuantidadePortas │    │ + getCilindrada() │    │ + getCapacidadeCarga│
│   (): int             │    │   : int           │    │   (): double     │
│ + calcularTarifaBase  │    │ + calcularTarifaBase│    │ + calcularTarifaBase│
│   (): double          │    │   (): double      │    │   (): double     │
│ + toString(): String  │    │ + toString(): String│    │ + toString(): String│
└───────────────────────┘    └───────────────────┘    └─────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│                        Cliente                                 │
├─────────────────────────────────────────────────────────────────┤
│ - nome: String                                                  │
│ - documento: String                                             │
│ - endereco: String                                              │
│ - telefone: String                                              │
├─────────────────────────────────────────────────────────────────┤
│ + Cliente(String, String, String, String)                      │
│ + getNome(): String                                             │
│ + setNome(String): void                                         │
│ + getDocumento(): String                                        │
│ + setDocumento(String): void                                    │
│ + getEndereco(): String                                         │
│ + setEndereco(String): void                                     │
│ + getTelefone(): String                                         │
│ + setTelefone(String): void                                     │
│ + isPessoaFisica(): boolean                                     │
│ + isPessoaJuridica(): boolean                                   │
│ + toString(): String                                            │
│ + equals(Object): boolean                                       │
│ + hashCode(): int                                               │
│ - validarDocumento(String): boolean                             │
│ - validarCPF(String): boolean                                   │
│ - validarCNPJ(String): boolean                                  │
│ - validarTelefone(String): boolean                              │
└─────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│                    ContratoLocacao                             │
├─────────────────────────────────────────────────────────────────┤
│ - cliente: Cliente                                              │
│ - veiculo: Veiculo                                              │
│ - dataInicio: LocalDate                                         │
│ - dataTermino: LocalDate                                        │
│ - valorTotal: double                                            │
│ - ativo: boolean                                                │
├─────────────────────────────────────────────────────────────────┤
│ + ContratoLocacao(Cliente, Veiculo, LocalDate, LocalDate)      │
│ + getCliente(): Cliente                                         │
│ + getVeiculo(): Veiculo                                         │
│ + getDataInicio(): LocalDate                                    │
│ + getDataTermino(): LocalDate                                   │
│ + getValorTotal(): double                                       │
│ + isAtivo(): boolean                                            │
│ + getDiasLocacao(): long                                        │
│ + finalizarContrato(): void                                     │
│ + emitirContrato(): String                                      │
│ + toString(): String                                            │
│ - validarContrato(...): void                                    │
│ - calcularValorTotal(): double                                  │
│ - calcularFatorDesconto(long): double                           │
└─────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│                        Locadora                                │
├─────────────────────────────────────────────────────────────────┤
│ - veiculos: List<Veiculo>                                       │
│ - clientes: List<Cliente>                                       │
│ - contratos: List<ContratoLocacao>                              │
├─────────────────────────────────────────────────────────────────┤
│ + Locadora()                                                    │
│ + adicionarVeiculo(Veiculo): void                               │
│ + adicionarCliente(Cliente): void                               │
│ + criarContrato(...): ContratoLocacao                           │
│ + getVeiculosDisponiveis(): List<Veiculo>                       │
│ + getContratosAtivos(): List<ContratoLocacao>                   │
│ + getVeiculos(): List<Veiculo>                                  │
│ + getClientes(): List<Cliente>                                  │
│ + getContratos(): List<ContratoLocacao>                         │
│ + exibirVeiculosDisponiveis(): void                             │
│ + exibirContratosAtivos(): void                                 │
│ + exibirRelatorioGeral(): void                                  │
└─────────────────────────────────────────────────────────────────┘
```

## Relacionamentos

- **Herança**: Carro, Moto e Utilitario herdam de Veiculo
- **Implementação**: Veiculo implementa Tarifavel
- **Composição**: ContratoLocacao possui Cliente e Veiculo
- **Agregação**: Locadora gerencia listas de Veiculos, Clientes e Contratos

## Princípios OO Aplicados

1. **Encapsulamento**: Todos os atributos são privados com acesso via métodos públicos
2. **Herança**: Veiculo é classe abstrata base para os tipos específicos
3. **Polimorfismo**: Cálculo de tarifa através da interface Tarifavel
4. **Abstração**: Interface Tarifavel define contrato para cálculo de tarifas
