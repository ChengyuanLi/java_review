package com.domain;

/**
 * @author aidenli
 */
public class Farm {
    private int rows = 3;
    private int columns = 3;

    Seed[][] farm = new Seed[rows][columns];

    {
        Seed seed = new Seed("Apple");
        seed.setFlag(0);
        farm[0][0] = seed;
        Seed seed2 = new Seed("Orange");
        seed2.setFlag(1);
        farm[1][1] = seed2;
        Seed seed3 = new Seed("Banana");
        seed3.setFlag(2);
        farm[2][2] = seed3;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Seed[][] getFarm() {
        return farm;
    }

    public void setFarm(Seed[][] farm) {
        this.farm = farm;
    }
}
