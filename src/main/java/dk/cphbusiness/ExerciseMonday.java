package dk.cphbusiness;

public class ExerciseMonday {
    public static void main(String[] args) {
        System.out.println("ex1");
        ArithmeticOperation add = (a, b) -> a + b;
        int result = add.perform(1, 2);
        System.out.println(result);

        System.out.println("ex2");
        System.out.println(doMath(10, 20, (a, b) -> a + b)); // 30

    }
    private static interface ArithmeticOperation {
        int perform(int a, int b);
    }
    public static int doMath(int a, int b, ArithmeticOperation op) {
        int result = op.perform(a, b);
        return result;
    }
}
