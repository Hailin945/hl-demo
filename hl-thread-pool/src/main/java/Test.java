import java.util.Scanner;

/**
 * @author Hailin
 * @date 2020/3/12
 */
public class Test {

    public static void main(String[] args) {
        while (true) {
            double pi = 3.14;
            Scanner input = new Scanner(System.in);
            int r = input.nextInt();
            double s = pi * r * r;
            double l = 2 * pi * r;
            System.out.println("圆的面积：" + s + "\n圆的周长：" + l);
        }
    }
}
