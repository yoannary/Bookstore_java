package project.types;

public enum PaperType {
NORMAL(2), GLOSSY(3), PAPER_FOR_NEWSPAPER(1);
    private int price;
    PaperType(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}
