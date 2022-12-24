package model;

import java.time.LocalDate;

public class Phone {
    private Long id;
    private String model;
    private int memory;
    private LocalDate yearOdIssue;
    private double price;

    public Phone(Long id, String model, int memory, LocalDate yearOdIssue, double price) {
        this.id = id;
        this.model = model;
        this.memory = memory;
        this.yearOdIssue = yearOdIssue;
        this.price = price;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public LocalDate getYearOdIssue() {
        return yearOdIssue;
    }

    public void setYearOdIssue(LocalDate yearOdIssue) {
        this.yearOdIssue = yearOdIssue;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " \n   Phone : " +
                "\n id : " + id +
                "\n model : " + model +
                "\n memory : " + memory +
                "\n yearOdIssue : " + yearOdIssue +
                "\n price : " + price +
                "\n======================";
    }
}
