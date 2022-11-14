package com.bancolavadores.tl;

import com.bancolavadores.bl.BL;
import com.bancolavadores.bl.Cliente;
import com.bancolavadores.bl.Cuenta;
import com.bancolavadores.bl.CuentaAhorroProgramado;

import java.time.LocalDate;

public class Controller {

    private static BL logic = new BL();

    public String registroCliente(int id, String nombre, String direccion) {
        Cliente cliente = new Cliente(id,nombre,direccion);
        return logic.registroCliente(cliente);
    }

    public String[] listarCliente() {
        return logic.listarCliente();
    }

    public String registroCuenta(int idClient, int numCuenta, double saldo, int type) {
        Cliente cliente = logic.buscarCliente(idClient);
        if(cliente!=null){
            return cliente.setCuentas(numCuenta,saldo,type);
        }
        return "No se pudo";
    }

    public String[] listarCuenta(int idClient) {
        Cliente cliente = logic.buscarCliente(idClient);
        if(cliente != null){
            return logic.listarCuenta(cliente);
        }
        return new String[]{"No hay ciente"};
    }

    public String registroDeposito(int idClient, int numCuenta, String descripcion, double monto, int dia, int mes, int year) {
        Cliente cliente = logic.buscarCliente(idClient);
        if(cliente != null){
            Cuenta cuenta = logic.buscarCuente(cliente,numCuenta);
            if(cuenta != null){
                return "Saldo: " + cuenta.setMovimientos(descripcion,monto, LocalDate.of(year,mes,dia), 1);
            }
            else {
                return "No hay una cuenta asosiada a ese cliente";
            }
        }
        return "No hay ciente";
    }

    public String registroRetiro(int idClient, int numCuenta, String descripcion, double monto, int dia, int mes, int year) {
        Cliente cliente = logic.buscarCliente(idClient);
        if(cliente != null){
            Cuenta cuenta = logic.buscarCuente(cliente,numCuenta);
            if(cuenta != null){

                return "Saldo: " + cuenta.setMovimientos(descripcion,monto, LocalDate.of(year,mes,dia), 2);
            }
            else {
                return "No hay una cuenta asosiada a ese cliente";
            }
        }
        return "No hay ciente";
    }

    public String[] listarMovimientos(int idClient, int numCuenta) {
        Cliente cliente = logic.buscarCliente(idClient);
        if(cliente != null){
            Cuenta cuenta = logic.buscarCuente(cliente,numCuenta);
            if(cuenta != null){
                return logic.listarMovimientos(cuenta);
            }
            else {
                return new String[]{"No hay una cuenta asosiada a ese cliente"};
            }
        }
        return new String[]{"No hay ciente"};
    }

    public String registroCuentaProgramdas(int idClient, int numCuenta, double saldo, int type, int numCuentaAso) {
        Cliente cliente = logic.buscarCliente(idClient);
        if(cliente!=null){
            Cuenta cuenta = logic.buscarCuente(cliente,numCuentaAso);
            if(cuenta != null){
                cliente.setCuentas(numCuenta,saldo,cuenta);
            }
            else {
                return "No hay una cuenta asosiada a ese cliente";
            }
        }
        return "No se pudo";
    }
}
