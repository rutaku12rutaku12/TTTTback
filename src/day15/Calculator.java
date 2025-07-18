package day15;

public interface Calculator {
    public static int plus( int x , int y){
        System.out.println("x = " + x + ", y = " + y + ", x + y = "+(x+y));
        return x+y;
    }
}
