import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Playlist {
  private Scanner scanner = new Scanner(System.in);
  private Midia[] midias;
  private String ordemExecucao;
  private String midiaAtual;

  public Midia[] getMidias() {
    return midias;
  }

  public void setMidias(Midia[] midias) {
    this.midias = midias;
  }

  public String getOrdemExecucao() {
    return ordemExecucao;
  }

  public void setOrdemExecucao(String ordemExecucao) {
    this.ordemExecucao = ordemExecucao;
  }

  public String getMidiaAtual() {
    return midiaAtual;
  }

  public void setMidiaAtual(String midiaAtual) {
    this.midiaAtual = midiaAtual;
  }

  //Method to set next midia
  public void next_midia(int i) {
    if (i + 1 > midias.length) { //If the index is greater than the array length, it will start from the first index
      System.out.println("Reiniciando da playlist");
      System.out.println("Tocando mídia: " + midias[0].getTitulo());
    } else {
      System.out.println("Tocando mídia: " + midias[i + 1].getTitulo());
    }
  }

    //Method to set previous midia
  public void previous_midia(int i) {
    if (i - 1 < 0) { //If the index is less than 0, it will start from the last index
      System.out.println("Reiniciando da playlist");
      System.out.println("Tocando mídia: " + midias[midias.length - 1].getTitulo());
    } else {
      System.out.println("Tocando mídia: " + midias[i - 1].getTitulo());

    }
  }

  //Method to shuffle midia
  public void shuffle_midia() {
    System.out.println("\nMisturando mídias...\n");
    Collections.shuffle(Arrays.asList(this.getMidias())); //Shuffle the array
  }

  private void create_music() {
    Artista[] artista = new Artista[5];
    Musica[] musica = new Musica[5];

    //Creating artists
    artista[0] = new Artista("Bon Jovi", "02/03/1962", "MTV Video Music Award", "Masculino");
    artista[1] = new Artista("Gustavo Lima", "02/03/1980", "Troféu Imprensa de Melhor Cantor", "Masculino");
    artista[2] = new Artista("Luan Santana", "13/03/1991", "Troféu Imprensa de Melhor Cantor", "Masculino");
    artista[3] = new Artista("Marília Mendonça", "07/07/1994", "Troféu Imprensa de Melhor Cantor", "Feminino");
    artista[4] = new Artista("Adelle", "05/05/1988", "Grammy Award", "Feminino");

    //Creating musics
    musica[0] = new Musica("It's My Life", 2000, "Rock", 4.30, artista[0], 5);
    musica[1] = new Musica("Apelido Carinhoso", 2010, "Sertanejo", 3.20, artista[1], 5);
    musica[2] = new Musica("Acordando o Prédio", 2015, "Sertanejo", 2.40, artista[2], 5);
    musica[3] = new Musica("Infiel", 2017, "Sertanejo", 3.50, artista[3], 5);
    musica[4] = new Musica("Hello", 2015, "Pop", 2.50, artista[4], 5);

    this.setMidias(musica);
  }

  private void create_movie() {
    Ator[] elenco = new Ator[5];
    Filme[] filme = new Filme[5];

    //Creating actors
    elenco[0] = new Ator("Marlon Brando", "03/04/1924", "Oscar de Melhor Ator", "Masculino", "Cinema");
    elenco[1] = new Ator("Robert De Niro", "17/08/1943", "Oscar de Melhor Ator", "Masculino", "Cinema");
    elenco[2] = new Ator("Al Pacino", "25/04/1940", "Oscar de Melhor Ator", "Masculino", "Cinema");
    elenco[3] = new Ator("Denzel Washington", "28/12/1954", "Oscar de Melhor Ator", "Masculino", "Cinema");
    elenco[4] = new Ator("Jack Nicholson", "22/04/1937", "Oscar de Melhor Ator", "Masculino", "Cinema");

    //Creating movies
    filme[0] = new Filme(
        "O Poderoso Chefão", 1972, "Drama", 175, elenco,
        "Francis Ford Coppola", "Albert S. Ruddy");
    filme[1] = new Filme("O Poderoso Chefão II", 1974, "Drama", 202, elenco,
        "Francis Ford Coppola", "Albert S. Ruddy");
    filme[2] = new Filme("Avatar", 2009, "Ficção", 162, elenco, "James Cameron", "James Cameron");
    filme[3] = new Filme("Titanic", 1997, "Romance", 194, elenco, "James Cameron", "James Cameron");
    filme[4] = new Filme("O Iluminado", 1980, "Terror", 146, elenco, "Stanley Kubrick", "Stanley Kubrick");

    this.setMidias(filme); //setting midias array

  }

  //
  private void get_details(Midia[] midias, int choice, int type) {
    switch (choice) {
      case 1:
        Musica musica = (Musica) midias[type]; //casting to get details
        musica.details(); //calling details method
        break;
      case 2:
        Filme filme = (Filme) midias[type]; //casting to get details
        filme.details(); //calling details method
        break;
      default:
        System.out.println("Opção inválida");
        break;
    }
  }

//Method to call playlist factory
public void call_playlist_factory(int choice) {
    create_playlist(choice);
  }

  //Method to create playlist
  private  void create_playlist(int choice) {
    int returns = 0;
    String selected_playlist = choice == 1 ? "Músicas" : "Filmes"; //ternary operator to set playlist name
    boolean isPlaying = true;
    String controls = "\n\n1 - Próxima mídia | 2 - Mídia anterior | 3 - Play/Pause | 4 - Misturar mídias | 5 - Menu inicial";

    //type of media to create
    switch (choice) {
      case 1:
        create_music();
        break;
      case 2:
        create_movie();
        break;
      default:
        System.out.println("Opção inválida");
        break;
    }
    //Loop to play playlist and show controls
    for (int i = 0; i < this.getMidias().length;) {
      setMidiaAtual(this.getMidias()[i].getTitulo());

      Menu.clear_console();
      System.out.println("========== RDEV PLAYER ==========");
      if (isPlaying) {
        System.out.print("[" + (i + 1) + "/" + (this.getMidias().length) + "]");// Show current media and total media
        System.out.println(" Playlist: " + selected_playlist); // Show playlist name
        System.out.println("\nREPRODUZINDO:"); // Show current media
        get_details(this.getMidias(), choice, i); // Show current media details

        if (i + 1 > this.getMidias().length - 1) { // Show next media
          System.out.println("\nPRÓXIMA MÍDIA: " + this.getMidias()[0].getTitulo());
        } else {
          System.out.println("\nPRÓXIMA MÍDIA: " + this.getMidias()[i + 1].getTitulo());
        }

      } else {
        System.out.println("\nStatus: Pausado");
      }
      System.out.println(controls); // Show controls
      returns = scanner.nextInt(); // Get user input

      // Switch to control playlist
      switch (returns) {
        case 1: // Next media
          if (i + 1 > this.getMidias().length - 1) {
            i = 0;
          } else {
            i++;
          }
          isPlaying = true;
          break;
        case 2: // Previous media
          if (i - 1 < 0) {
            i = this.getMidias().length - 1;
          } else {
            i--;
          }
          isPlaying = true;
          break;
        case 3: // Play/Pause
          isPlaying = !isPlaying;
          break;
        case 4: // Shuffle playlist
          shuffle_midia();
          break;
        case 5: // Return to main menu
          Menu.menu();
          break;
        default: // Invalid option
          System.out.println("Opção inválida");
          break;
      }
    }
  }
}