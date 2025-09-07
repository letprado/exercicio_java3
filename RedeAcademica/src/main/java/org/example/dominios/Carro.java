package org.example.dominios;

public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String placa, String marca, String modelo, int ano, int quantidadePortas) {
        super(placa, marca, modelo, ano);
        if (quantidadePortas < 2 || quantidadePortas > 5) {
            throw new IllegalArgumentException("Quantidade de portas deve estar entre 2 e 5");
        }
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    @Override
    public double calcularTarifaBase() {
        double tarifaBase = 50.0;
        
        if (quantidadePortas == 2) {
            tarifaBase += 20.0;
        } else if (quantidadePortas == 4) {
            tarifaBase += 10.0;
        } else if (quantidadePortas == 5) {
            tarifaBase += 15.0;
        }
        
        return tarifaBase;
    }

    @Override
    public String toString() {
        return String.format("Carro: %s (%d portas)", super.toString(), quantidadePortas);
    }
}
