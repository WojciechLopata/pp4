package pl.wlopata.sales.product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDetails {
    private  String desc;
    private BigDecimal price;
    private String id;
    private final String name;

    public ProductDetails(String id, String name, BigDecimal price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
