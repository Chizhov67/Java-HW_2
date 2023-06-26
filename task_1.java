import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        Logger log = Logger.getLogger(Main.class.getName());
        // Генерация рандомного массива
        Random random = new Random();
        int[] arr = random.ints(10, 1, 100).toArray();
        int iteration = 1;
        // Вывод первоначального массива в лог
        log.info("Start array: " + Arrays.toString(arr));
        // Сортировка пузырьком
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j + 1] < arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                    log.info("Iter " + iteration + ": " + Arrays.toString(arr));
                    iteration++;
                }
            }
        }
    }
}