package com.tupuntodeventa.bl.Orden.Type;

import com.tupuntodeventa.bl.Coupon.Coupon;
import com.tupuntodeventa.bl.Orden.Orden;
import com.tupuntodeventa.bl.User.User;

public class ClientOrden extends Orden {
    private Coupon coupon;

    public ClientOrden(User user, String type) {
        super(user, type);
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "ClientOrden{" +
                super.toString() +
                "coupon=" + coupon +
                '}';
    }
}
