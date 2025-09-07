package org.example.dominios;

public class Moto extends Veiculo {
    private int cilindrada;

    public Moto(String placa, String marca, String modelo, int ano, int cilindrada) {
        super(placa, marca, modelo, ano);
        if (cilindrada <= 0) {
            throw new IllegalArgumentException("Cilindrada deve ser maior que zero");
        }
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public double calcularTarifaBase() {
        double tarifaBase = 30.0;
        
        if (cilindrada <= 150) {
            tarifaBase += 5.0;
        } else if (cilindrada <= 300) {
            tarifaBase += 15.0;
        } else if (cilindrada <= 600) {
            tarifaBase += 25.0;
        } else {
            tarifaBase += 40.0;
        }
        
        return tarifaBase;
    }

    @Override
    public String toString() {
        return String.format("Moto: %s (%dcc)", super.toString(), cilindrada);
    }
}
