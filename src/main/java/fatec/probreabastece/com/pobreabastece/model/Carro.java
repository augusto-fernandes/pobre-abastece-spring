package fatec.probreabastece.com.pobreabastece.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String modelo;
    private String marca;
    private String placa;

    public Carro() {
    }

    public Carro(Long id, String modelo, String marca, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(id, carro.id) && Objects.equals(modelo, carro.modelo) && Objects.equals(marca, carro.marca) && Objects.equals(placa, carro.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, marca, placa);
    }
}
