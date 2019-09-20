package cn.bdqn.pojo;

/**
 * 消费记录
 */
public class ConsumInfo {
    //消费编号
    private Integer conId;
    //手机号
    private String cardNumber;
    //消费类型
    private String type;
    //消费数据
    private String consumData;
    //消费价格
    private Integer price;


    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConsumData() {
        return consumData;
    }

    public void setConsumData(String consumData) {
        this.consumData = consumData;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
