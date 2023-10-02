package pl.wlopata.creditcard.ProductCatalog;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


public class HashMapProductStorage implements ProductStorage {

    private Map<String,Product> products;
    public HashMapProductStorage(){
        this.products=new HashMap<>();
    }


    @Override
    public List<Product> allProducts() {
        return products.values()
                .stream()
                .collect(Collectors.toList());
    }
    @Override
    public Product loadById(String productId){
        return products.get(productId);

    }
    @Override
    public List<Product> allPublishedProducts() {
        return products.values()
                .stream()
                .filter(Product::getOnline)
                .collect(Collectors.toList());
    }

    @Override
    public void add(Product newProduct) {
        products.put(newProduct.getId(), newProduct);
    }


    public static ProductCatalog loadFromJson() throws IOException, ParseException {

        ProductCatalog productCatalog= new ProductCatalog(new HashMapProductStorage());
        String fileName="src/main/resources/static/Products.json";
        FileReader reader = new FileReader(fileName);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(reader);


        JSONArray products = (JSONArray) obj;
        System.out.println(products.getClass());
        System.out.println(products.get(0).getClass());
        int size= products.size();
        int i=0;
        while(i<size){
            JSONObject product = (JSONObject) products.get(i);
            System.out.println(product.get("name").getClass());
            long   price = (long) product.get("price");
            String product_id = productCatalog.addProduct(product.get("name").toString(),product.get("desc").toString(), BigDecimal.valueOf(price),UUID.fromString(product.get("uuid").toString()));
            productCatalog.assignImage(product_id,product.get("image").toString());
            productCatalog.publishProduct(product_id);


            i++;





        }
        return  productCatalog;


    }


}
