import java.util.Scanner;
/**
 * Класс помогает с интерфейсом программы. Спрашивает и передает значения
 */
public class Asker {
    Scanner scanner = new Scanner(System.in);
    public Integer ask(String s){
        System.out.println(s);
        return scanner.nextInt();
    }
}