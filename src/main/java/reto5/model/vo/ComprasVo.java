package reto5.model.vo;

//Clase que realiza el encapsulamiento de los datos de la consulta de compras

public class ComprasVo {
    private Integer id;
    private String Constructora;
    private String Banco;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstructora() {
        return Constructora;
    }
    public void setConstructora(String constructora) {
        Constructora = constructora;
    }

    public String getBanco() {
        return Banco;
    }
    public void setBanco(String banco) {
        Banco = banco;
    }
}
