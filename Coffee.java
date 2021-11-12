class Coffee extends Beverage{
    String beans;

    public Coffee(String name, int price, boolean ice, String beans){
        super(name, price, ice);
        this.beans = beans;
    }
    @Override
    public String toString(){
        return this.name + " " + this.price + "원 " + (ice ? "아이스" : "핫" ) + " (원두 : " + beans + ")";
    }
}