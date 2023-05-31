package pl.wlopata.sales.offering;

import java.math.BigDecimal;

public class Offer {
    BigDecimal total;
    int itemsCount;
    public  Offer(){
        this.total=BigDecimal.valueOf(0);
        this.itemsCount=0;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public int getItemsCount() {
        return itemsCount;
    }
}
