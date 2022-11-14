package com.bancolavadores.bl;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta{

    public static int limite = 50000;

    public CuentaCorriente(int numCuenta, double saldo) {
        super(numCuenta, saldo);
    }

    @Override
    public double depositar(double monto) {
        setSaldo(getSaldo() + monto);
        return getSaldo();
    }

    @Override
    public double retirar(double monto) {
        setSaldo(getSaldo() - monto);
        return getSaldo();
    }
}
