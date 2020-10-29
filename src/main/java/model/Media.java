/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Media {
    
    private String tipo;
    private String url;

    public Media() {
    }

    public Media(String tipo, String url) {
        this.tipo = tipo;
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Media{" + "tipo=" + tipo + ", url=" + url + '}';
    }
    
    
    
}
