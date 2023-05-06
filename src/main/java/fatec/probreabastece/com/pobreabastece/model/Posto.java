package fatec.probreabastece.com.pobreabastece.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "POSTO")
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    private String endereco;

    private String cnpj;

    public Posto() {
    }

    public Posto(String nome, String endereco, String cnpj) {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posto posto = (Posto) o;
        return Objects.equals(nome, posto.nome) && Objects.equals(endereco, posto.endereco) && Objects.equals(cnpj, posto.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, endereco, cnpj);
    }
}
