package com.demo.producto;

public enum Estados {
    TODO("hacer"), INPROGRESS("enproceso"), DONE("hecho");
    
    private String valor;

    private Estados(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    } 
}
