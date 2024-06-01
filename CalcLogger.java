import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Логирование калькулятора
 */
public class CalcLogger {
    public void saveInfo(String S){
        Logger logger = Logger.getLogger("MyLog");
        try {
            FileHandler fh = new FileHandler("Log1.log", true);
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
            logger.info(S);
        } catch (SecurityException | IOException e) {
            logger.log(Level.SEVERE, "Произошла ошибка при работе с FileHandler.", e);
        }
    }
}
