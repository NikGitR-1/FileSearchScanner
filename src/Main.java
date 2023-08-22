import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<File> files;

    public static void main(String[] args) {
        files = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к папке для поиска: ");
        String folderPath = scanner.nextLine();

        System.out.print("Введите формат файла (например, jpg): ");
        String fileFormat = scanner.nextLine();

        searchingFiles(new File(folderPath), fileFormat, files);

        System.out.println("-----------------------------------------");
        for (File file : files) {
            System.out.println("Найден файл: " + file.getAbsolutePath());
        }
    }

    private static void searchingFiles(File rootFile, String fileFormat, List<File> searchFiles) {
        if (rootFile.isDirectory()) {
            System.out.println("Поиск файлов в папке: " + rootFile.getAbsolutePath());
            File[] files = rootFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        searchingFiles(file, fileFormat, searchFiles);
                    } else {
                        if (file.getAbsolutePath().endsWith("." + fileFormat)) {
                            searchFiles.add(file);
                        }
                    }
                }
            }
        }
    }
}
