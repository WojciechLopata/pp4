package pl.wlopata;
import  org.junit.jupiter.api.Test;
public class FirstTest {
    @Test
    void TestIt(){
        assert true==false;
    }
    @Test
    void testIt2(){
        String myName="Wojciech";
        String output=String.format("Hello %s",myName);
        assert output.equals("Hello Wojciech");
    }
    @Test
    void baseSchema(){
        //arrange //given //input
        //act //when // interaction
        //assert // then //output
    }
}
