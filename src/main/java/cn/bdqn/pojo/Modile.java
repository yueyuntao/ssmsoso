package cn.bdqn.pojo;

public class Modile {
    private Integer id;
    private String cardNumber;
    private String userName;
    private String passWord;
    private Packages pas;
    private Integer sonsumAmount;
    private Integer money;
    private Integer realTalkTime;
    private Integer realSMSCount;
    private Integer realFlow;


    public Modile() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Packages getPas() {
        return pas;
    }

    public void setPas(Packages pas) {
        this.pas = pas;
    }

    public Integer getSonsumAmount() {
        return sonsumAmount;
    }

    public void setSonsumAmount(Integer sonsumAmount) {
        this.sonsumAmount = sonsumAmount;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(Integer realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public Integer getRealSMSCount() {
        return realSMSCount;
    }

    public void setRealSMSCount(Integer realSMSCount) {
        this.realSMSCount = realSMSCount;
    }

    public Integer getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(Integer realFlow) {
        this.realFlow = realFlow;
    }


    @Override
    public String toString() {
        return "Modile{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", pas=" + pas +
                ", sonsumAmount=" + sonsumAmount +
                ", money=" + money +
                ", realTalkTime=" + realTalkTime +
                ", realSMSCount=" + realSMSCount +
                ", realFlow=" + realFlow +
                '}';
    }
}
