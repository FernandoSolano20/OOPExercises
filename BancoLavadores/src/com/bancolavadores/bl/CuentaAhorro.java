package com.bancolavadores.bl;

public class CuentaAhorro extends Cuenta {
    private final double TASA_INTERES = 0.2;

    public CuentaAhorro(int numCuenta, double saldo) {
        super(numCuenta, saldo);
    }

    @Override
    public double depositar(double monto) {
        setSaldo(getSaldo() * TASA_INTERES + getSaldo() + monto);
        return getSaldo();
    }

    @Override
    public double retirar(double monto) {
        setSaldo(getSaldo() - getSaldo() * TASA_INTERES  - monto);
        return getSaldo();
    }
}
