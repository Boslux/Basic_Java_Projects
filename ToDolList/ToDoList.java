package Java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bu sınıf, basit bir To Do listesi uygulamasını temsil eder.
 * Kullanıcılar yeni görevler ekleyebilir, mevcut görevleri listeleyebilir,
 * görevleri tamamlayabilir ve uygulamadan çıkabilir.
 */
public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            displayMenu();
            int choice = getChoice(scanner);
            
            switch (choice) {
                case 1:
                    addTask(scanner, tasks);
                    break;
                case 2:
                    listTasks(tasks);
                    break;
                case 3:
                    completeTask(scanner, tasks);
                    break;
                case 4:
                    System.out.println("Programdan çıkılıyor...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("***************");
        System.out.println("To Do List");
        System.out.println("1. Görev Ekle");
        System.out.println("2. Görevleri Listele");
        System.out.println("3. Görevi Tamamla");
        System.out.println("4. Çıkış Yap");
    }

    private static int getChoice(Scanner scanner) {
        System.out.print("Seçiminizi girin: ");
        return scanner.nextInt();
    }

    private static void addTask(Scanner scanner, ArrayList<String> tasks) {
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Yeni Görev Girin: ");
        String newTask = scanner.nextLine();
        tasks.add(newTask);
        System.out.println("Görev eklendi: " + newTask);
    }

    private static void listTasks(ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Görev Bulunamadı.");
        } else {
            System.out.println("Görevler:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void completeTask(Scanner scanner, ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Tamamlanacak görev bulunamadı.");
        } else {
            System.out.print("Tamamlanan görevinizin numarasını girin: ");
            int completedTaskIndex = scanner.nextInt();
            if (completedTaskIndex >= 1 && completedTaskIndex <= tasks.size()) {
                String completedTask = tasks.remove(completedTaskIndex - 1);
                System.out.println("Görev Tamamlandı: " + completedTask);
            } else {
                System.out.println("Geçersiz İşlem Numarası.");
            }
        }
    }
}
