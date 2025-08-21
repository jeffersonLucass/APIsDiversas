package io.github.jeffersonLucass.arquiteturaspring.montadora;

public class Motor {

    private String modelo;
    private Integer cavalos;
    private Integer Cilindros;
    private Double  litragem;
    private TipoMotor tipoMotor;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCavalos() {
        return cavalos;
    }

    public void setCavalos(Integer cavalos) {
        this.cavalos = cavalos;
    }

    public Integer getCilindros() {
        return Cilindros;
    }

    public void setCilindros(Integer cilindros) {
        Cilindros = cilindros;
    }

    public Double getLitragem() {
        return litragem;
    }

    public void setLitragem(Double litragem) {
        this.litragem = litragem;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "modelo='" + modelo + '\'' +
                ", cavalos=" + cavalos +
                ", Cilindros=" + Cilindros +
                ", litragem=" + litragem +
                ", Motor=" + tipoMotor +
'}';
    }
}
