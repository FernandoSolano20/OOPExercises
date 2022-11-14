package com.bancolavadores.bl;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private ArrayList<Cuenta> cuentas;

    public Cliente(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public String setCuentas(int numCuenta, double saldo, int type) {
        Cuenta cuenta = null;
        if(type == 1 && saldo < CuentaCorriente.limite) {
            return "No se pudo asosciar monto debe ser mayor a " + CuentaCorriente.limite;
        }
        else if(type == 2){
             cuenta = new CuentaCorriente(numCuenta,saldo);
        }
        else if(type == 2){
            cuenta = new CuentaAhorro(numCuenta,saldo);
        }
        cuentas.add(cuenta);
        return "Se asosocio";
    }

    public String setCuentas(int numCuenta, double saldo, Cuenta cuenta) {
        Cuenta cuentaAhorro = new CuentaAhorroProgramado(numCuenta,saldo,cuenta);
        cuentas.add(cuentaAhorro);
        return "Se asosocio";
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
