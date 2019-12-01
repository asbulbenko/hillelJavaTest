package square;

public class SquareRoot {
    private int d, a, b, c;
    private double x, x1, x2;

    public boolean findRoots(int a, int b, int c){
        System.out.println("Search roots of square equation");
        // calculate discriminator
        d = b * b - 4 * a * c;

        // according to discriminator value
        // d < 0 - nothing to return
        // d = 0 - only 1 root for equation exist
        // d > 0 - 2 roots for equation exists
        if(d < 0){
            System.out.println("No roots found");
            return false;
        }else if(d == 0){
            x = -b / (2 * a);
            System.out.println("One root found: x = " + x);
            return true;
        } else {
            x1 = (-b - Math.sqrt(1.0 * d)) / (2 * a);
            x2 = (-b + Math.sqrt(1.0 * d)) / (2 * a);
            System.out.println("Roots: x1 = " + x1 + ", x2 = " + x2);
            return true;
        }
    }
}
