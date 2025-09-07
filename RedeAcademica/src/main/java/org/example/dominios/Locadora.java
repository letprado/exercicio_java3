package org.example.dominios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<ContratoLocacao> contratos;

    public Locadora() {
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.contratos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não pode ser nulo");
        }
        if (veiculos.contains(veiculo)) {
            throw new IllegalArgumentException("Veículo já cadastrado");
        }
        veiculos.add(veiculo);
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (clientes.contains(cliente)) {
            throw new IllegalArgumentException("Cliente já cadastrado");
        }
        clientes.add(cliente);
    }

    public ContratoLocacao criarContrato(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataTermino) {
        ContratoLocacao contrato = new ContratoLocacao(cliente, veiculo, dataInicio, dataTermino);
        contratos.add(contrato);
        return contrato;
    }

    public List<Veiculo> getVeiculosDisponiveis() {
        return veiculos.stream()
                      .filter(Veiculo::isDisponivel)
                      .toList();
    }

    public List<ContratoLocacao> getContratosAtivos() {
        return contratos.stream()
                       .filter(ContratoLocacao::isAtivo)
                       .toList();
    }

    public List<Veiculo> getVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public List<ContratoLocacao> getContratos() {
        return new ArrayList<>(contratos);
    }

    public void exibirVeiculosDisponiveis() {
        System.out.println("\n=== VEÍCULOS DISPONÍVEIS ===");
        List<Veiculo> disponiveis = getVeiculosDisponiveis();
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veículo disponível no momento.");
        } else {
            for (Veiculo veiculo : disponiveis) {
                System.out.println(veiculo + " - Tarifa: R$ " + String.format("%.2f", veiculo.calcularTarifaBase()));
            }
        }
    }

    public void exibirContratosAtivos() {
        System.out.println("\n=== CONTRATOS ATIVOS ===");
        List<ContratoLocacao> ativos = getContratosAtivos();
        if (ativos.isEmpty()) {
            System.out.println("Nenhum contrato ativo no momento.");
        } else {
            for (ContratoLocacao contrato : ativos) {
                System.out.println(contrato);
            }
        }
    }

    public void exibirRelatorioGeral() {
        System.out.println("\n=== RELATÓRIO GERAL ===");
        System.out.println("Total de veículos: " + veiculos.size());
        System.out.println("Veículos disponíveis: " + getVeiculosDisponiveis().size());
        System.out.println("Total de clientes: " + clientes.size());
        System.out.println("Contratos ativos: " + getContratosAtivos().size());
        System.out.println("Total de contratos: " + contratos.size());
    }
}
