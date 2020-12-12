package panel.log;
import java.util.Random;

/**
 * Класс генерации ключей
 */
public class KeyGen {
    private static Random random = new Random();
    public static String  generation(){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 20; i++){
            int number = random.nextInt(10);
            string.append(number);
        }
        return string.toString();
    }
}
