package org.example.dominios;

public class Utilitario extends Veiculo {
    private double capacidadeCarga;

    public Utilitario(String placa, String marca, String modelo, int ano, double capacidadeCarga) {
        super(placa, marca, modelo, ano);
        if (capacidadeCarga <= 0) {
            throw new IllegalArgumentException("Capacidade de carga deve ser maior que zero");
        }
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    @Override
    public double calcularTarifaBase() {
        double tarifaBase = 80.0;
        
        if (capacidadeCarga <= 1000) {
            tarifaBase += 20.0;
        } else if (capacidadeCarga <= 3000) {
            tarifaBase += 40.0;
        } else if (capacidadeCarga <= 5000) {
            tarifaBase += 60.0;
        } else {
            tarifaBase += 80.0;
        }
        
        return tarifaBase;
    }

    @Override
    public String toString() {
        return String.format("Utilitário: %s (%.0f kg)", super.toString(), capacidadeCarga);
    }
}
