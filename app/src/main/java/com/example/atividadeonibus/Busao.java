package com.example.atividadeonibus;

public class Busao {

    private String marca;
    private String modelo;
    private String origemDestino;
    private String tipo;
    private String assentosTotais;
    private String assentosOcupado;

    public Busao(){
    }

    public Busao(String marca, String modelo, String origemDestino, String tipo, String assentostotais, String assentosOcupado) {
        this.marca = marca;
        this.modelo = modelo;
        this.origemDestino = origemDestino;
        this.tipo = tipo;
        this.assentosTotais = assentostotais;
        this.assentosOcupado = assentosOcupado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOrigemDestino() {
        return origemDestino;
    }

    public void setOrigemDestino(String origemDestino) {
        this.origemDestino = origemDestino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAssentosTotais() {
        return assentosTotais;
    }

    public void setAssentosTotais(String assentosTotais) {
        this.assentosTotais = assentosTotais;
    }

    public String getAssentosOcupado() {
        return assentosOcupado;
    }

    public void setAssentosOcupado(String assentosOcupado) {
        this.assentosOcupado = assentosOcupado;
    }
}
