import java.util.Scanner;
/**
 * Основная часть, где идет подсчет чисел
 * Формат комплексного числа:
 * z = a + bi
 */
public class CalculateZ {
    Scanner scanner = new Scanner(System.in);
    CalcLogger log = new CalcLogger();
    public String Calculate(Complex z1, Complex z2) {
        System.out.println("Введите знак: ");
        char c = scanner.next().charAt(0);
        int[] a = z1.getZ();
        int[] b = z2.getZ();
        String total = new String();
        switch (c) {
            case '-':
                total = (a[0] - b[0]) + " - " + (a[1] - b[1]) + "i";
                break;
            case '+':
                total = (a[0] + b[0]) + " + " + (a[1] + b[1]) + "i";
                break;
            case '*':
                total = ((a[0]*b[0]) - (a[1]*b[1])) + " + " + ((a[0]*b[1]) + (a[1]*b[0])) + "i";
                break;
            case '/':
                float a0 = a[0];
                float a1 = a[1];
                float b0 = b[0];
                float b1 = b[1];
                total = ((a0*b0) + (a1*b1))/(b0*b0 + b1*b1) + " + " + ((a1*b0 - a0*b1)/(b0*b0 + b1*b1)) + "i";
                break;
        }
        System.out.println("Ответ: " + total);
        log.saveInfo(z1.showZ() + " " + c + " " +  z2.showZ() + " = " + total);
        return total;
    }
}
