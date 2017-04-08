package test.newPackage;

import java.util.Random;

public class Figures {
    static Random random  = new Random();
    private static int generation = random.nextInt(15);

    abstract static class Figure {
        abstract double S() ; // area calculation
        static void color () {
            System.out.print("\tColor: "); 
            switch (random.nextInt(4)){
                case 0: System.out.println("white"); break;
                case 1: System.out.println("black"); break;
                case 2: System.out.println("red");   break;
                case 3: System.out.println("blue");  break;
                case 4: System.out.println("green"); break;
            }
        }
    }

    static class Square extends Figure {
        Square sq;

        int sideLength;
        int degree;

        Square(int sideLength, int degree) {
            sq = new Square(sq.sideLength, sq.degree);
            sq.sideLength = sideLength;
            sq.degree = degree;
        }

        static int S(int sideLength) { return (int) Math.pow(sideLength, 2); }

        static int side(int rnd) { return rnd; } //unique method

        static void output(int rnd) {
            System.out.print("Figure: Square\n" + "\tArea: " + S(side(rnd)) );
            System.out.println("\n\tSide length: " + side(rnd) );
            color();
        }

        @Override
        double S() {
            return 0;
        }
    }
//------------------------------------------------
    static class Triangle extends Figure{
        Triangle tr;

        double catheter1;
        double catheter2;
        double hypotenuse;

        static double catR1;
        static double catR2;

        Triangle(double catheter1, double catheter2, double hypotenuse) {
            tr = new Triangle(tr.catheter1, tr.catheter2, tr.hypotenuse);
            tr.catheter1 = catheter1;
            tr.catheter2 = catheter2;
            tr.hypotenuse = hypotenuse;
        }

        static double S(double catheter1, double catheter2) {
            return  (catheter1 * catheter2 / 2);
        }

        static int hypotenuse (int catheter1, int catheter2) { //unique method
            double hyp = Math.pow(catheter1,2) + Math.pow(catheter2,2);
            return (int) Math.sqrt(hyp);
        }
        static void output(int catheter1, int catheter2) {
            catR1 = 2 + random.nextInt(10 - 2);
            catR2 = 2 + random.nextInt(10 - 2);
            System.out.println("Figure: Triangle" +"\n\tArea: " + S(catheter1, catheter2)
                    + "\n\tHypotenuse: " + hypotenuse(catheter1, catheter2));
            color();
        }

    @Override
    double S() {
        return 0;
    }
}
//-----------------------------------------------
    public static void main (String [] args) {
        for (int i = 0; i < generation; i ++) {
            int n = random.nextInt(3);
            int r1 = 2+random.nextInt(10-2);
            int r2 = 2+random.nextInt(10-2);
            switch (n) {
                case 0: Square.output(r1); break;
                case 1: Triangle.output(r1,r2); break;
            }
        }
    }
}
