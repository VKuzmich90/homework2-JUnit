package by.kuzmich.domain;

public class OrderItem {

    private String name;

    private String id;

    private int number;

    private int cost;

    public OrderItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getCost() {
        return cost;
    }

    public String getId() {
        return id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
