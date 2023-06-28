package project.classes;

import project.common.EnoughPaperException;

public class Machine {
    private int maxPaperToPrint;
    private int leftPaper;
    public Machine(int maxPaperToPrint) {
        this.maxPaperToPrint = maxPaperToPrint;
        this.leftPaper = maxPaperToPrint;
    }
    public int getMaxPaperToPrint() {
        return maxPaperToPrint;
    }
    public int getLeftPaper() {
        return leftPaper;
    }
    public void addPaper(int numberOfSheets) {
        this.leftPaper += numberOfSheets;
    }
    public void printEdition(Edition edition) throws EnoughPaperException {
        // Check if there is enough paper to print the edition.
        if (this.leftPaper < edition.getNumOfPages()) {
            throw new EnoughPaperException("Not enough paper for " + edition.getName());
        }

        this.leftPaper -= edition.getNumOfPages();
    }
}
