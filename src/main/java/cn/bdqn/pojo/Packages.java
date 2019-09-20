package cn.bdqn.pojo;

public class Packages {
    private int paId;
    private String name;
    private int talkTime;
    private int flow;
    private int smsCount;
    private int price;

    public Packages(){
        if (this.getPaId()==1){
            this.setName("话痨套餐");
            this.setTalkTime(500);
            this.setSmsCount(30);
            this.setFlow(0);
            this.setPrice(58);
        }else if(this.getPaId()==2){
            this.setName("网虫套餐");
            this.setTalkTime(0);
            this.setSmsCount(0);
            this.setFlow(3072/1024);
            this.setPrice(68);
        }else{
            this.setName("超人套餐");
            this.setTalkTime(200);
            this.setFlow(1024/1024);
            this.setSmsCount(50);
            this.setPrice(78);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaId() {
        return paId;
    }

    public void setPaId(int paId) {
        this.paId = paId;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Packages{" +
                "paId=" + paId +
                ", talkTime=" + talkTime +
                ", flow=" + flow +
                ", smsCount=" + smsCount +
                ", price=" + price +
                '}';
    }



}
