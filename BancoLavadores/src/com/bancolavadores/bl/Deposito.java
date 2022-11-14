package com.bancolavadores.bl;

import java.time.LocalDate;

public class Deposito extends Movimiento {
    public Deposito(String descripcion, double monto, LocalDate fecha) {
        super(descripcion, monto, fecha);
    }
}
