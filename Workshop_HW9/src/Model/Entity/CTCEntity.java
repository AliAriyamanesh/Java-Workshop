package Model.Entity;

public class CTCEntity {
    private int from;
    private int to;
    private int cost;
    private int id;

    public CTCEntity() {
    }

    public CTCEntity(int from, int to, int cost, int id) {
        this.from = from;
        this.to = to;
        this.cost = cost;
        this.id = id;
    }

    public CTCEntity(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public CTCEntity setFrom(int from) {
        this.from = from;
        return this;
    }

    public int getTo() {
        return to;
    }

    public CTCEntity setTo(int to) {
        this.to = to;
        return this;
    }

    public int getCost() {
        return cost;
    }

    public CTCEntity setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public int getId() {
        return id;
    }

    public CTCEntity setId(int id) {
        this.id = id;
        return this;
    }
}
