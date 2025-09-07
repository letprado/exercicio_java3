package org.example.dominios;

import java.util.regex.Pattern;

public abstract class Veiculo implements Tarifavel {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private boolean disponivel;

    public Veiculo(String placa, String marca, String modelo, int ano) {
        if (!validarPlaca(placa)) {
            throw new IllegalArgumentException("Placa inválida. Formato esperado: ABC-1234 ou ABC1D23");
        }
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.disponivel = true;
    }

    private boolean validarPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            return false;
        }
        
        String placaFormatada = placa.toUpperCase().replaceAll("[^A-Z0-9]", "");
        
        Pattern padraoAntigo = Pattern.compile("^[A-Z]{3}[0-9]{4}$");
        Pattern padraoNovo = Pattern.compile("^[A-Z]{3}[0-9][A-Z][0-9]{2}$");
        
        return padraoAntigo.matcher(placaFormatada).matches() || 
               padraoNovo.matcher(placaFormatada).matches();
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public abstract double calcularTarifaBase();

    public double calcularTarifaComFator(double fator) {
        return calcularTarifaBase() * fator;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d - Placa: %s", marca, modelo, ano, placa);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo veiculo = (Veiculo) obj;
        return placa != null ? placa.equals(veiculo.placa) : veiculo.placa == null;
    }

    @Override
    public int hashCode() {
        return placa != null ? placa.hashCode() : 0;
    }
}
