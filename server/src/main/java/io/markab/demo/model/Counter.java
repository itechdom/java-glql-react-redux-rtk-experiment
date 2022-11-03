package io.markab.demo.model;
import java.io.Serializable;

public class Counter implements Serializable {

    private String name;

    public Counter(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

}
