package com.frannzg.gestordetasques;

import java.util.Date;

public class Tasca {
    private String titol;
    private String descripcio;
    private Date dataLimit;
    private String estat;

    public Tasca(){

    }

    public Tasca(String titol, String descripcio, Date dataLimit, String estat) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.dataLimit = dataLimit;
        this.estat = estat;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Date getDataLimit() {
        return dataLimit;
    }

    public void setDataLimit(Date dataLimit) {
        this.dataLimit = dataLimit;
    }

    @Override
    public String toString() {
        return "Tasca{" +
                "titol='" + titol + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", dataLimit=" + dataLimit +
                ", estat='" + estat + '\'' +
                '}';
    }
}
