package com.example.examen;

public class Rectangulo {

    private float base;
    private float altura;

    public Rectangulo(float base, float altura){
        this.base = base;
        this.altura = altura;
    }

    public float calcularPerimetro(){
        float res = base+base+altura+altura;
        return res;
    }

    public float calcularArea(){
        float res = base*altura;
        return res;
    }

}
