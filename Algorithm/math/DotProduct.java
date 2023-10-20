package Algorithm.math;

//기하학적 접근(벡터 연산 알고리즘)

public class DotProduct {
    static class Vector {
        double x, y;

        Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double dot(Vector v) {
            return this.x * v.x + this.y * v.y;
        }
    }

    public static void main(String[] args) {
        Vector v1 = new Vector(3, 4);
        Vector v2 = new Vector(1, 2);
        System.out.println(v1.dot(v2)); 
    }
}