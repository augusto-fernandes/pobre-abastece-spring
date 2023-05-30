package fatec.probreabastece.com.pobreabastece.controller;

import fatec.probreabastece.com.pobreabastece.model.Endereco;
import fatec.probreabastece.com.pobreabastece.model.Posto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;


public class PostoEndereco  {
    private String tipo;
    private Posto posto;
    private Endereco endereco;

    public PostoEndereco() {
    }

    public PostoEndereco(String tipo, Posto posto, Endereco endereco) {
        this.tipo = tipo;
        this.posto = posto;
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    @Override
    public String toString() {
        return "PostoEndereco{" +
                "tipo='" + tipo + '\'' +
                ", posto=" + posto +
                ", endereco=" + endereco +
                '}';
    }


}
