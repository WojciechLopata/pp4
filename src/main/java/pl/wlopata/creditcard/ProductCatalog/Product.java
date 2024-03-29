package pl.wlopata.creditcard.ProductCatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String uuid;
    private final String name;
    private final String desc;
    private BigDecimal price;
    private String image;
    private boolean online;

    public Product(UUID uuid, String name, String desc,BigDecimal price) {
        this.uuid = uuid.toString();
        this.name = name;
        this.desc = desc;
        this.price=price;
    }

    public String getId() {
        return uuid;
    }

    public String getDesc() {
        return desc;
    }

    public UUID getUUID() {
        return UUID.fromString(uuid);
    }

    public String getName() {
        return name;
    }

    public void changePrice(BigDecimal newPrice) {
        price = newPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageKey) {

        image = imageKey;
    }

    public void setOnline(boolean online) {

        this.online = online;
    }

    public boolean getOnline() {
        return online;
    }
}