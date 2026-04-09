package edu.phystech.hw2;

public class IntHolder {
    private int value;

    public IntHolder(int value) {
        this.value = value;
    }

    public static IntHolder valueOf(int value) {
        return new IntHolder(value);
    }

    public int getValue() {
        return value;
    }

    public void add(int val) { this.value += val; }
    public void subtract(int val) { this.value -= val; }
    public void multiply(int val) { this.value *= val; }
    public void divide(int val) {
        if (val == 0) throw new ArithmeticException("division by zero");
        this.value /= val;
    }

    public void swap(IntHolder other) {
        int temp = this.value;
        this.value = other.value;
        other.value = temp;
    }
}