package project.types;

public enum SizeType {
    A1(1),A2(2),A3(3),A4(4),A5(5);
    private int price;
    SizeType(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}
