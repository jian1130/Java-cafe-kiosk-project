class Beverage extends Menu{
    boolean ice;

    public Beverage(String name, int price, boolean ice){
        super(name, price);
        this.ice = ice;
    }
    @Override
    public String toString(){
        return this.name + " " + this.price + "원 " + (ice ? "아이스" : "핫");
    }
}