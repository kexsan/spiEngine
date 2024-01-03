package et.spi.str;

public class StrTest
{
    public static void main(String[] args) {
        String[] stringsArray = new String[199];

        for (int i = 1; i <= 199; i++) {
            stringsArray[i - 1] = String.format("%03d", i);
        }

        System.out.println("Элементы массива строк:");
        for (int i = 0; i < stringsArray.length; i++) {
            System.out.print(stringsArray[i] + " ");
        }
    }
}
