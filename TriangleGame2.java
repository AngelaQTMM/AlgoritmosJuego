package org.example.algoritmica.others.training;

import java.util.Arrays;
import java.util.List;

/**
 * TriangleGame2
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TriangleGame2 {

    // 1. definir clase triangulo y que pueda rotar
    // 2. recorrer los 6 triangulos y comparar extremos
    // 3. condicion match entre actual y siguiente
    // 4. incluir la rotacion
    // 5. retornar la suma

    public String resolve(List<Triangle> triangles) {
        Integer sumaChildMax = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            int sumaChild = resolverMask(triangles, 0);
            sumaChildMax = Math.max(sumaChildMax, sumaChild);

            triangles.get(0).turn();
        }

        return (sumaChildMax.equals(Integer.MIN_VALUE)) ? "none" : String.valueOf(sumaChildMax);
    }

    private int resolverMask(List<Triangle> triangles, int index) {
        //System.out.println("resolverMask index: " + index);
        if (index == triangles.size() - 1) {
            if (triangles.get(index).getValueStart() == triangles.get(0).getValueEnd()) {
                //System.out.println("match: " + triangles.get(index).getValueStart());
                return triangles.get(index).getValueMiddle();
            }
            return Integer.MIN_VALUE;
        }

        int sumaChildMax = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (triangles.get(index).getValueStart() == triangles.get(index + 1).getValueEnd()) {
                //System.out.println("match: " + triangles.get(index).getValueStart());
                int sumaChild = resolverMask(triangles, index + 1);
                sumaChildMax = Math.max(sumaChildMax, sumaChild);
            }
            triangles.get(index + 1).turn();
        }

        if (sumaChildMax == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return sumaChildMax + triangles.get(index).getValueMiddle();
        }
    }

    public static void main(String[] args) {
        Triangle t = new Triangle(new int[] {3, 1, 5});
//        System.out.println(t.getValueMiddle());
//        t.turn();
//        System.out.println(t.getValueMiddle());
//        System.out.println(t);
//        System.out.println(t.getValueStart());
//        System.out.println(t.getValueEnd());
//        t.turn();
//        System.out.println();
//        System.out.println(t);
//        System.out.println(t.getValueStart());
//        System.out.println(t.getValueEnd());

        TriangleGame2 tg = new TriangleGame2();
        List<Triangle> triangles;

        triangles = Arrays.asList(
                new Triangle(new int[] {1, 4, 20})
                , new Triangle(new int[] {3, 1, 5})
                , new Triangle(new int[] {50, 2, 3})
                , new Triangle(new int[] {5, 2, 7})
                , new Triangle(new int[] {7, 5, 20})
                , new Triangle(new int[] {4, 7, 50})
        );
        System.out.println(tg.resolve(triangles));

        triangles = Arrays.asList(
                new Triangle(new int[] {10, 1, 20})
                , new Triangle(new int[] {20, 2, 30})
                , new Triangle(new int[] {30, 3, 40})
                , new Triangle(new int[] {40, 4, 50})
                , new Triangle(new int[] {50, 5, 60})
                , new Triangle(new int[] {60, 6, 10})
        );
        System.out.println(tg.resolve(triangles));

        triangles = Arrays.asList(
                new Triangle(new int[] {10, 1, 20})
                , new Triangle(new int[] {20, 2, 30})
                , new Triangle(new int[] {30, 3, 40})
                , new Triangle(new int[] {40, 4, 50})
                , new Triangle(new int[] {50, 5, 60})
                , new Triangle(new int[] {10, 6, 60})
        );
        System.out.println(tg.resolve(triangles));
//        System.out.println(Integer.MIN_VALUE);
    }

}
