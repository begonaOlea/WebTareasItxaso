package com.demo.producto;

public enum Estados {
    TODO("To do"), INPROGRESS("In progress"), DONE("Done");
    
    private String valor;

    private Estados(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    } 
}
