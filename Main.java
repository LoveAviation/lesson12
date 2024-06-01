import java.util.Scanner;

public class Main {
    public static void main(String[] args) {    
        Complex z1 = new Complex();
        Complex z2 = new Complex();
        Asker help = new Asker();
        Scanner scanner = new Scanner(System.in);

        z1.putRe(help.ask("введите целую часть первого комплексного числа: "));
        z1.putIm(help.ask("введите мнимую часть первого комплексного числа: "));

        z2.putRe(help.ask("введите целую часть второго комплексного числа: "));
        z2.putIm(help.ask("введите мнимую часть второго комплексного числа: "));

        CalculateZ calc = new CalculateZ();
        calc.Calculate(z1, z2);
        scanner.close();
    }
}
