package pl.wlopata.creditcard;

import org.junit.jupiter.api.Test;

public class NumericRepresentetionTest {
    @Test
    void lestCheckDouble(){
    double a=0.003;
    double b= 0.001;
    double c=b-a;
    System.out.println(c);
    }
    @Test
    void lestCheckFloat(){
        float a=0.003f;
        float b=0.002f;
        float c=b-a;
        System.out.println(c);
    }
}
