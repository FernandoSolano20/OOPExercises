package com.bancolavadores.bl;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Cuenta {
    private int numCuenta;
    private double saldo;
    private LocalDate fechaApertura;
    private ArrayList<Movimiento> movimientos;

    public Cuenta(int numCuenta, double saldo) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.fechaApertura = LocalDate.now();
        this.movimientos = new ArrayList<>();
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public double setMovimientos(String descripcion, double monto, LocalDate fecha, int type) {
        Movimiento movimiento = null;
        double result = 0;
        if(type == 1){
            movimiento = new Deposito(descripcion, monto, fecha);
            result = depositar(monto);
        }
        else {
            movimiento = new Retiro(descripcion, monto, fecha);
            result = retirar(monto);
        }
        movimientos.add(movimiento);
        return result;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numCuenta=" + numCuenta +
                ", saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                '}';
    }

    public abstract double depositar(double monto);
    public abstract double retirar(double monto);
}
