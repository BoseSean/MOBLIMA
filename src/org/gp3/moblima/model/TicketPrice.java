package org.gp3.moblima.model;

/**
 * Created by hannancao on 6/11/17.
 */
public class TicketPrice implements Model {
    private Double[] price;

    public TicketPrice(){
        price = new Double[]{5.0, 14.0, 14.0, 14.0, 16.0, 14.0, 16.0, 7.0, 8.0, 14.0, 14.0, 16.0, 14.0, 16.0, 9.0, 14.0, 14.0, 14.0, 16.0, 14.0, 16.0, 13.0, 14.0, 14.0, 14.0, 16.0, 14.0, 16.0, 28.0, 38.0};
    }

    public Double getPrice(int i) {
        return price[i];
    }
    public Double[] getPriceList(){return price;}

    public void updatePrice(int pos, double new_price) {
        price[pos] = new_price;
    }

}
