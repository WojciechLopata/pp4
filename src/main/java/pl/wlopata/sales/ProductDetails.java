package pl.wlopata.sales;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDetails {
    private  String desc;
    private BigDecimal price;
    private UUID id;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
