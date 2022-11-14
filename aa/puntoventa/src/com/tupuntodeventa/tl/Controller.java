package com.tupuntodeventa.tl;

import com.tupuntodeventa.bl.*;

import java.time.LocalDate;

public class Controller {

    private BL logic = new BL();

    public String registerAdmin(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, int day, int month, int year, int gender, String phone) {
        Admin admin = new Admin(id,name,lastName1,lastName2,userName,email,pass, LocalDate.of(year,month,day),gender,phone);
        return logic.registerAdmin(admin);
    }

    public void registerDirection(int id, String exactAddress, String district, String canton, String province, int km) {
        logic.registerDirection(id, exactAddress, district, canton, province, km);
    }

    public String registerClient(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, int day, int month, int year, int gender, String phone) {
        Client client = new Client(id,name,lastName1,lastName2,userName,email,pass, LocalDate.of(year,month,day),gender,phone);
        return logic.registerUser(client);
    }

    public String registerCoupon(int day, int month, int year, boolean status, int discount) {
        Coupon coupon = new Coupon(LocalDate.of(year,month,day),status,discount);
        boolean result = true;
        do{
            coupon.setCode();
            result = logic.registerCoupon(coupon);
        }while (!result);
        return "Registrado";
    }

    public String registerPlate(int code, int price, String descript) {
        SinglePlate singlePlate = new SinglePlate(code,price,descript);
        return logic.registerProduct(singlePlate);
    }

    public String searchPlate(int codeCombo, int code) {
        Product product = logic.getProductById(code);
        if(product != null && product instanceof  SinglePlate){
            Product productCombo = logic.getProductById(codeCombo);
            if(productCombo != null && productCombo instanceof Combo){
                ((Combo) productCombo).setPlates((SinglePlate) product);
                return "se agrego";
            }
        }
        return "no se agrego";
    }

    public String registerCombo(int code, String name, int price) {
        Combo combo = new Combo(code,name,price);
        return logic.registerProduct(combo);
    }

    public String registerPlateCombo(int codeCombo, int code, int price, String descript) {
        if(logic.getProductById(code) == null){
            Product product = logic.getProductById(codeCombo);
            if(product != null && product instanceof Combo){
                ((Combo) product).setPlates(code,price,descript);
                return "Se registro";
            }
        }
        return "No Se registro";
    }


    public String[] listUsers() {
        return logic.listUsers();
    }

    public String[] listCoupons() {
        return logic.listCoupons();
    }

    public String[] listProducts() {
        return logic.listProducts();
    }
}
