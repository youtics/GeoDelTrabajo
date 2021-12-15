package com.youtics.menuoverflow;

public class Buque {
    String matricula;
    String nombreBuque;
    int potenciaHP;
    int cantTripulantes;
    String armador;
    int cantCombustible;

    public  Buque(){}
    public Buque(String matricula, String nombreBuque, int potenciaHP, int cantTripulantes, String armador, int cantCombustible) {
        this.matricula = matricula;
        this.nombreBuque = nombreBuque;
        this.potenciaHP = potenciaHP;
        this.cantTripulantes = cantTripulantes;
        this.armador = armador;
        this.cantCombustible = cantCombustible;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreBuque() {
        return nombreBuque;
    }

    public void setNombreBuque(String nombreBuque) {
        this.nombreBuque = nombreBuque;
    }

    public int getPotenciaHP() {
        return potenciaHP;
    }

    public void setPotenciaHP(int potenciaHP) {
        this.potenciaHP = potenciaHP;
    }

    public int getCantTripulantes() {
        return cantTripulantes;
    }

    public void setCantTripulantes(int cantTripulantes) {
        this.cantTripulantes = cantTripulantes;
    }

    public String getArmador() {
        return armador;
    }

    public void setArmador(String armador) {
        this.armador = armador;
    }

    public int getCantCombustible() {
        return cantCombustible;
    }

    public void setCantCombustible(int cantCombustible) {
        this.cantCombustible = cantCombustible;
    }

    @Override
    public String toString() {
        return "Buque{" +
                "matricula=" + matricula +
                ", nombreBuque='" + nombreBuque + '\'' +
                ", potenciaHP=" + potenciaHP +
                ", cantTripulantes=" + cantTripulantes +
                ", armador='" + armador + '\'' +
                ", cantCombustible=" + cantCombustible +
                '}';
    }
}
