package com.bancolavadores.bl;

import java.time.LocalDate;

public class Retiro extends Movimiento {
    public Retiro(String descripcion, double monto, LocalDate fecha) {
        super(descripcion, monto, fecha);
    }
}
