package com.bancolavadores.bl;

import java.util.ArrayList;

public class BL {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public String registroCliente(Cliente cliente) {
        if(buscarCliente(cliente.getId()) == null){
            clientes.add(cliente);
            return "Success";
        }
        return "No se pudo";
    }

    public Cliente buscarCliente(int id){
        Cliente result = null;
        for (int i = 0; i < clientes.size(); i++){
            if(id == clientes.get(i).getId()){
                result = clientes.get(i);
                break;
            }
        }
        return result;
    }

    public String[] listarCliente() {
        int size = clientes.size();
        String[] array;
        if(size > 0){
            array = new String[size];
            for (int i = 0; i < size; i++) {
                array[i] = clientes.get(i).toString();
            }
        }
        else {
            array = new String[1];
            array[0] = "No hay clientes";
        }
        return array;
    }

    public String[] listarCuenta(Cliente cliente) {
        String[] array;
        ArrayList<Cuenta> cuentas = cliente.getCuentas();
        int size = cuentas.size();
        if(size > 0){
            array = new String[size];
            for (int i = 0; i < size; i++) {
                array[i] = cuentas.get(i).toString();
            }
        }
        else {
            array = new String[1];
            array[0] = "No hay cuentas";
        }
        return array;
    }

    public Cuenta buscarCuente(Cliente cliente, int numCuenta) {
        ArrayList<Cuenta> cuentas = cliente.getCuentas();
        Cuenta result = null;
        for (int i = 0; i < cuentas.size(); i++){
            if(numCuenta == cuentas.get(i).getNumCuenta()){
                result = cuentas.get(i);
                break;
            }
        }
        return result;
    }

    public String[] listarMovimientos(Cuenta cuenta) {
        ArrayList<Movimiento> movimientos = cuenta.getMovimientos();
        String[] array;
        int size = movimientos.size();
        if(size > 0){
            array = new String[size];
            for (int i = 0; i < size; i++) {
                array[i] = movimientos.get(i).toString();
            }
        }
        else {
            array = new String[1];
            array[0] = "No hay movimientos";
        }
        return array;
    }
}
