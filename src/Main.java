import java.util.Scanner;

public class Main {
       public static void main(String[] args) {
        System.out.println("Введите выражение:");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        System.out.println(calc(line));
    }

    public static String calc(String input) {
        String[] iskInt = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] iskString = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] words = input.split("\\s");
        if (words.length != 3) {
            System.out.println("Исключение: Неверное количество символов (каждый символ идет через пробел)");
            System.exit(0);
        }

        for(int i = 0; i <= 9; ++i) {
            for(int j = 0; j <= 9; ++j) {
                if (words[0].equals(iskInt[i]) && words[2].equals(iskInt[j])) {
                    Calcul arab = new Calcul(Integer.valueOf(words[0]), words[1], Integer.valueOf(words[2]));
                    String lastText = "Ответ: " + arab.lastText;
                    return lastText;
                }
            }
        }

        for(int i = 0; i <= 9; ++i) {
            for(int j = 0; j <= 9; ++j) {
                if (words[0].equals(iskString[i]) && words[2].equals(iskString[j])) {
                    Rom2Arab out = new Rom2Arab();
                    int vol1 = out.toArab(words[0]);
                    int vol2 = out.toArab(words[2]);
                    Calcul conv = new Calcul(vol1, words[1], vol2);
                    if (conv.lastText >= 1) {
                        String romConv = out.toRom(conv.lastText);
                        String lastText = "Ответ: " + romConv;
                        return lastText;
                    }

                    System.out.println("Исключение: Ответ меньше 1.");
                    System.exit(0);
                }
            }
        }

        return "Исключение: Ошибка ввода (можно вводить только целые или римские или арабские цифры от 1 до 10:)";
    }
}