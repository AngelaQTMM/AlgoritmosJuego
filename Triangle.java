package org.example.algoritmica.others.training;

import lombok.Data;

import java.util.Arrays;

/**
 * Triangle
 *
 * @author Marcos Quispe
 * @since 1.0
 */
@Data
public class Triangle {
    private int INDEX_START = 0;
    private int INDEX_END = 2;

    private int[] values;
    private int indexBase = 0;

    public Triangle(int[] values) {
        this.values = values;
    }

    public int length() {
        return values.length;
    }

    public void turn() {
//        indexBase++;
//        if (indexBase == values.length)
//            indexBase = 0;
        indexBase--;
        if (indexBase == -1)
            indexBase = values.length - 1;
    }

    public void rollbackTurn() {
        indexBase--;
        if (indexBase == -1)
            indexBase = values.length - 1;
    }

    public int getValueStart() {
        int index = indexBase + INDEX_START;
        return values[index];
    }

    public int getValueEnd() {
        int index = (indexBase + 1) % 3;
        //int index = (indexBase + INDEX_END) % 3;
        return values[index];
    }

    public int getValueMiddle() {
        //int index = (indexBase + 1) % 3;
        int index = (indexBase + INDEX_END) % 3;
        return values[index];
    }

    @Override
    public String toString() {
        int[] values1 = new int[values.length];
        values1[0] = getValueStart();
        values1[1] = getValueEnd();
        values1[2] = getValueMiddle();
        return "Triangle: " + Arrays.toString(values1);
    }
}
