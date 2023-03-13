import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Menu {
  private static Scanner scanner = new Scanner(System.in);
  private static Timer timer = new Timer();
  private static Playlist playlist = new Playlist();

  //constructor to start menu
  public static void menu() {
    int choice = 0;
    clear_console();
    System.out.println("==========RDEV STUDIOS==========");
    System.out.println("Bem vindo ao RDEV Player");
    System.out.println("O que você deseja fazer?\n");
    System.out.println("1 - Reproduzir música");
    System.out.println("2 - Reproduzir filme");
    System.out.println("3 - Sair");
    System.out.print("\nDigite a opção desejada: ");
    choice = scanner.nextInt();

    //switch to call playlist factory
    switch (choice) {
      case 1:
        System.out.println("\nReproduzindo playlist de músicas...");
        playlist.call_playlist_factory(1);
        break;
      case 2:
        System.out.println("\nReproduzindo playlist de filmes...");
        playlist.call_playlist_factory(2);
        break;
      case 3:
        clear_console();
        System.out.println("\nFinalizando RDEV Player...");
        timer.schedule(new TimerTask() {
          @Override
          public void run() {
            System.exit(0);
          }
        }, 1000);
        break;
      default:
        //
        System.out.println("\nOpção inválida\n\n");
        timer.schedule(new TimerTask() {
          @Override
          public void run() {
            clear_console();
            menu();
          }
        }, 500);
    }
  }

  //function to clear console
  static void clear_console() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
