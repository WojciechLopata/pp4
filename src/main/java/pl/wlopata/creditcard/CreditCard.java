package pl.wlopata.creditcard;
import java.math.BigDecimal;
public class CreditCard {
    private BigDecimal balance;
    private BigDecimal limit;
    String cardNumber;

    public CreditCard(String s) {
    }
    public void withdraw(BigDecimal withdrawalAmount){
        if(this.balance.compareTo(withdrawalAmount)>=0){
            this.balance=this.balance.subtract(withdrawalAmount);
        }
        else{
            throw new BalanceSmallerThatWithdrawalException();
        }
    }
    public void assignLimit(BigDecimal creditAmount) {
        //@Todo weird function fix it later date
        if(creditAmount.compareTo(BigDecimal.valueOf(100))<0){
            throw new CreditBelowThresholdException();

        }
        if(isCreditNull()){
            this.limit=creditAmount;
        }
        else{
            throw new LimitAssignedMultipleTimesException();
        }
    }
    public void assignBalance(BigDecimal balance){
        this.balance=balance;
    }

    private boolean isCreditNull() {
        return this.limit==null;
    }

    public BigDecimal getBalance() {
        return  this.balance;
    }
}
