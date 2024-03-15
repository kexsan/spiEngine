package et.spi;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BSearch {
    @SneakyThrows
    @Test
    public void testBS()
    {

        int[] arr = {2, 4, 6, 8, 10, 12, 14};

        // Поиск элемента 8 в массиве
        int index = Arrays.binarySearch(arr, 8);

        if (index >= 0) {
            System.out.println("Элемент 8 найден в индексе: " + index);
        } else {
            System.out.println("Элемент 8 не найден. Вставить на позицию: " + (-index - 1));
        }

    }


    @Test
    public void testBSNegative5()
    {

        int[] arr = {2, 4, 6, 8, 10, 12, 14};

        // Поиск элемента 8 в массиве
        int index = Arrays.binarySearch(arr, 5);

        if (index >= 0) {
            System.out.println("Элемент 5 найден в индексе: " + index);
        } else {
            System.out.println("Элемент 5 не найден. Вставить на позицию: " + (-index - 1));
        }

    }

    @Test
    public void testBSNegative15()
    {

        int[] arr = {2, 4, 6, 8, 10, 12, 14};

        // Поиск элемента 8 в массиве
        int index = Arrays.binarySearch(arr, 3);

        if (index >= 0) {
            System.out.println("Элемент 3 найден в индексе: " + index);
        } else {
            System.out.println("Элемент 3 не найден. Вставить на позицию: " + (-index - 1));
        }

    }

    @Test
    public void asda()
    {

        int x = 33;
        double y = 33%17.5;
        System.out.println(y);

    }
}
