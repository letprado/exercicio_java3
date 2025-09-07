package org.example.dominios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoLocacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double valorTotal;
    private boolean ativo;

    public ContratoLocacao(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataTermino) {
        validarContrato(cliente, veiculo, dataInicio, dataTermino);
        
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.ativo = true;
        
        this.veiculo.setDisponivel(false);
        this.valorTotal = calcularValorTotal();
    }

    private void validarContrato(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataTermino) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não pode ser nulo");
        }
        if (dataInicio == null || dataTermino == null) {
            throw new IllegalArgumentException("Datas não podem ser nulas");
        }
        if (dataTermino.isBefore(dataInicio) || dataTermino.isEqual(dataInicio)) {
            throw new IllegalArgumentException("Data de término deve ser posterior à data de início");
        }
        if (!veiculo.isDisponivel()) {
            throw new IllegalStateException("Veículo não está disponível para locação");
        }
        if (dataInicio.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data de início não pode ser anterior à data atual");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public long getDiasLocacao() {
        return ChronoUnit.DAYS.between(dataInicio, dataTermino);
    }

    private double calcularValorTotal() {
        long dias = getDiasLocacao();
        double tarifaBase = veiculo.calcularTarifaBase();
        double fator = calcularFatorDesconto(dias);
        
        return veiculo.calcularTarifaComFator(fator) * dias;
    }

    private double calcularFatorDesconto(long dias) {
        if (dias >= 30) {
            return 0.8;
        } else if (dias >= 15) {
            return 0.85;
        } else if (dias >= 7) {
            return 0.9;
        } else {
            return 1.0;
        }
    }

    public void finalizarContrato() {
        if (!ativo) {
            throw new IllegalStateException("Contrato já foi finalizado");
        }
        
        this.ativo = false;
        this.veiculo.setDisponivel(true);
    }

    public String emitirContrato() {
        StringBuilder contrato = new StringBuilder();
        contrato.append("=== CONTRATO DE LOCAÇÃO ===\n");
        contrato.append("Cliente: ").append(cliente.toString()).append("\n");
        contrato.append("Veículo: ").append(veiculo.toString()).append("\n");
        contrato.append("Período: ").append(dataInicio).append(" a ").append(dataTermino).append("\n");
        contrato.append("Duração: ").append(getDiasLocacao()).append(" dias\n");
        contrato.append("Valor total: R$ ").append(String.format("%.2f", valorTotal)).append("\n");
        contrato.append("Status: ").append(ativo ? "ATIVO" : "FINALIZADO").append("\n");
        contrato.append("===========================");
        
        return contrato.toString();
    }

    @Override
    public String toString() {
        return String.format("Contrato: %s - %s (R$ %.2f)", 
                           cliente.getNome(), veiculo.getModelo(), valorTotal);
    }
}
