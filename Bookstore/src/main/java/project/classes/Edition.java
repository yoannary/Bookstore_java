package project.classes;

import project.types.PaperType;
import project.types.SizeType;

public class Edition {
    private String name;
    private int numOfPages;
    private SizeType pageSize;
    private PaperType paperType;
    private int numOfMonthlyOrdered = 0;

    public Edition(String name, int numOfPages, SizeType pageSize, PaperType paperType) {
        this.name = name;
        this.numOfPages = numOfPages;
        this.pageSize = pageSize;
        this.paperType = paperType;
    }

    public Edition(String name, int numOfPages, SizeType pageSize, PaperType paperType, int numOfMonthlyOrdered) {
        this.name = name;
        this.numOfPages = numOfPages;
        this.pageSize = pageSize;
        this.paperType = paperType;
        this.numOfMonthlyOrdered = numOfMonthlyOrdered;
    }

    public String getName() {
        return name;
    }
    public int getNumOfPages() {
        return numOfPages;
    }
    public int getNumOfMonthlyOrdered() {
        return numOfMonthlyOrdered;
    }
    public void setNumOfMonthlyOrdered(int numOfMonthlyOrdered) {
        this.numOfMonthlyOrdered = numOfMonthlyOrdered;
    }
    public int getPageSize() {
        return pageSize.getPrice();
    }
    public double getPricePerPage() {
        return paperType.getPrice();
    }

    @Override
    public String toString() {
        return "Edition{" +
                "name=" + name +
                "numOfPages=" + numOfPages +
                "pageSize=" + pageSize +
                "paperType=" + paperType +
                '}';
    }
}
