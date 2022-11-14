package com.bancolavadores.bl;

import java.time.LocalDate;

public class CuentaAhorroProgramado extends Cuenta {
    private Cuenta cuentas;
    private double monto;

    public CuentaAhorroProgramado(int numCuenta, double saldo, Cuenta cuenta) {
        super(numCuenta, saldo);
        this.cuentas = cuenta;
        this.monto = saldo;
    }


    public Cuenta getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta cuentas) {
        this.cuentas = cuentas;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "AhorroProgramado{" +
                "cuentas=" + cuentas +
                ", monto=" + monto +
                '}';
    }

    @Override
    public double depositar(double monto) {
        return 0;
    }

    @Override
    public double retirar(double monto) {
        return 0;
    }
}
