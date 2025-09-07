package org.example;

import org.example.dominios.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE LOCADORA DE VEÍCULOS ===\n");
        
        Locadora locadora = new Locadora();
        
        try {
            cadastrarClientes(locadora);
            cadastrarVeiculos(locadora);
            criarContratos(locadora);
            exibirRelatorios(locadora);
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    private static void cadastrarClientes(Locadora locadora) {
        System.out.println("Cadastrando clientes...");
        
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", 
                                     "Rua das Flores, 123", "(11) 99999-9999");
        Cliente cliente2 = new Cliente("Maria Santos", "987.654.321-00", 
                                     "Av. Paulista, 456", "(11) 88888-8888");
        Cliente cliente3 = new Cliente("Empresa ABC Ltda", "12.345.678/0001-90", 
                                     "Rua Comercial, 789", "(11) 77777-7777");
        
        locadora.adicionarCliente(cliente1);
        locadora.adicionarCliente(cliente2);
        locadora.adicionarCliente(cliente3);
        
        System.out.println("Clientes cadastrados com sucesso!");
    }
    
    private static void cadastrarVeiculos(Locadora locadora) {
        System.out.println("\nCadastrando veículos...");
        
        Carro carro1 = new Carro("ABC-1234", "Toyota", "Corolla", 2022, 4);
        Carro carro2 = new Carro("XYZ-5678", "Honda", "Civic", 2023, 4);
        Carro carro3 = new Carro("DEF-9012", "BMW", "320i", 2021, 4);
        
        Moto moto1 = new Moto("MOT-1234", "Honda", "CB 600", 2022, 600);
        Moto moto2 = new Moto("MOT-5678", "Yamaha", "MT-07", 2023, 700);
        Moto moto3 = new Moto("MOT-9012", "Kawasaki", "Ninja 300", 2021, 300);
        
        Utilitario util1 = new Utilitario("UTI-1234", "Ford", "Transit", 2022, 1500.0);
        Utilitario util2 = new Utilitario("UTI-5678", "Mercedes", "Sprinter", 2023, 3000.0);
        Utilitario util3 = new Utilitario("UTI-9012", "Iveco", "Daily", 2021, 5000.0);
        
        locadora.adicionarVeiculo(carro1);
        locadora.adicionarVeiculo(carro2);
        locadora.adicionarVeiculo(carro3);
        locadora.adicionarVeiculo(moto1);
        locadora.adicionarVeiculo(moto2);
        locadora.adicionarVeiculo(moto3);
        locadora.adicionarVeiculo(util1);
        locadora.adicionarVeiculo(util2);
        locadora.adicionarVeiculo(util3);
        
        System.out.println("Veículos cadastrados com sucesso!");
    }
    
    private static void criarContratos(Locadora locadora) {
        System.out.println("\nCriando contratos de locação...");
        
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);
        LocalDate proximaSemana = hoje.plusDays(7);
        LocalDate proximoMes = hoje.plusDays(30);
        
        var clientes = locadora.getClientes();
        var veiculos = locadora.getVeiculos();
        
        ContratoLocacao contrato1 = locadora.criarContrato(
            clientes.get(0), veiculos.get(0), amanha, proximaSemana);
        
        ContratoLocacao contrato2 = locadora.criarContrato(
            clientes.get(1), veiculos.get(3), amanha, proximoMes);
        
        ContratoLocacao contrato3 = locadora.criarContrato(
            clientes.get(2), veiculos.get(6), amanha, hoje.plusDays(15));
        
        System.out.println("Contratos criados:");
        System.out.println(contrato1.emitirContrato());
        System.out.println();
        System.out.println(contrato2.emitirContrato());
        System.out.println();
        System.out.println(contrato3.emitirContrato());
    }
    
    private static void exibirRelatorios(Locadora locadora) {
        locadora.exibirVeiculosDisponiveis();
        locadora.exibirContratosAtivos();
        locadora.exibirRelatorioGeral();
        
        System.out.println("\n=== DEMONSTRAÇÃO DE POLIMORFISMO ===");
        System.out.println("Cálculo de tarifas usando polimorfismo:");
        
        for (Veiculo veiculo : locadora.getVeiculos()) {
            System.out.printf("%s - Tarifa base: R$ %.2f%n", 
                            veiculo.getClass().getSimpleName(), 
                            veiculo.calcularTarifaBase());
        }
        
        System.out.println("\n=== TESTE DE VALIDAÇÕES ===");
        try {
            new Cliente("", "123.456.789-00", "Rua Teste", "(11) 99999-9999");
        } catch (IllegalArgumentException e) {
            System.out.println("Validação de nome: " + e.getMessage());
        }
        
        try {
            new Carro("INV-ALID", "Toyota", "Corolla", 2022, 4);
        } catch (IllegalArgumentException e) {
            System.out.println("Validação de placa: " + e.getMessage());
        }
        
        try {
            var clientes = locadora.getClientes();
            var veiculos = locadora.getVeiculos();
            locadora.criarContrato(clientes.get(0), veiculos.get(0), 
                                 LocalDate.now().minusDays(1), LocalDate.now().plusDays(5));
        } catch (IllegalArgumentException e) {
            System.out.println("Validação de data: " + e.getMessage());
        }
    }
}