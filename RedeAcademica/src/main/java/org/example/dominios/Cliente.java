package org.example.dominios;

import java.util.regex.Pattern;

public class Cliente {
    private String nome;
    private String documento;
    private String endereco;
    private String telefone;

    public Cliente(String nome, String documento, String endereco, String telefone) {
        setNome(nome);
        setDocumento(documento);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome.trim();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        if (!validarDocumento(documento)) {
            throw new IllegalArgumentException("CPF ou CNPJ inválido");
        }
        this.documento = documento.replaceAll("[^0-9]", "");
    }

    private boolean validarDocumento(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            return false;
        }
        
        String docLimpo = documento.replaceAll("[^0-9]", "");
        
        if (docLimpo.length() == 11) {
            return validarCPF(docLimpo);
        } else if (docLimpo.length() == 14) {
            return validarCNPJ(docLimpo);
        }
        
        return false;
    }

    private boolean validarCPF(String cpf) {
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) digito1 = 0;
        
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) digito2 = 0;
        
        return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
               digito2 == Character.getNumericValue(cpf.charAt(10));
    }

    private boolean validarCNPJ(String cnpj) {
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }
        
        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        
        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * pesos1[i];
        }
        int digito1 = soma % 11 < 2 ? 0 : 11 - (soma % 11);
        
        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * pesos2[i];
        }
        int digito2 = soma % 11 < 2 ? 0 : 11 - (soma % 11);
        
        return digito1 == Character.getNumericValue(cnpj.charAt(12)) &&
               digito2 == Character.getNumericValue(cnpj.charAt(13));
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        }
        this.endereco = endereco.trim();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (!validarTelefone(telefone)) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        this.telefone = telefone.replaceAll("[^0-9]", "");
    }

    private boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return false;
        }
        
        String telLimpo = telefone.replaceAll("[^0-9]", "");
        return telLimpo.length() >= 10 && telLimpo.length() <= 11;
    }

    public boolean isPessoaFisica() {
        return documento.length() == 11;
    }

    public boolean isPessoaJuridica() {
        return documento.length() == 14;
    }

    @Override
    public String toString() {
        String tipoDoc = isPessoaFisica() ? "CPF" : "CNPJ";
        return String.format("%s (%s: %s) - %s", nome, tipoDoc, documento, telefone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return documento != null ? documento.equals(cliente.documento) : cliente.documento == null;
    }

    @Override
    public int hashCode() {
        return documento != null ? documento.hashCode() : 0;
    }
}
