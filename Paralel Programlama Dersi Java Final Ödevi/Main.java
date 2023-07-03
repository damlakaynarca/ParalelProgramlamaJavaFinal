import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Birinci Thread - Kullanıcı bilgilerini kaydetme
        Thread thread1 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Kullanıcı Adı: ");
            String username = scanner.nextLine();
            System.out.print("Şifre: ");
            String password = scanner.nextLine();
            System.out.print("E-posta Adresi: ");
            String email = scanner.nextLine();

            try {
                FileWriter fileWriter = new FileWriter("c:\\io\\turgutozaluniversitesi\\person.txt");
                fileWriter.write("Kullanıcı Adı: " + username + "\n");
                fileWriter.write("Şifre: " + password + "\n");
                fileWriter.write("E-posta Adresi: " + email + "\n");
                fileWriter.close();
                System.out.println("Kullanıcı bilgileri kaydedildi.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // İkinci Thread - Secret information kaydetme
        Thread thread2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Secret information: ");
            String secretInfo = scanner.nextLine();

            try {
                FileWriter fileWriter = new FileWriter("c:\\io\\turgutozaluniversitesi\\secret.txt");
                fileWriter.write("Secret Information: " + secretInfo + "\n");
                fileWriter.close();
                System.out.println("Secret information kaydedildi.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Threadleri başlatma
        thread1.start();
        try {
            thread1.join(); // Birinci thread'in işi bitmesini bekler
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
//join() methodu ,birinci thread'in işini bitirmesini beklemek için kullanılır.Böylece ikinci thread yalnızca birinci thread'in tamamlanmasından 
//sonra çalışmaya başlar 