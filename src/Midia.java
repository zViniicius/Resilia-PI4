public class Midia {
  private String titulo;
  private int ano;
  private String genero;

  public Midia(String titulo, int ano, String genero) {
    this.titulo = titulo;
    this.ano = ano;
    this.genero = genero;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }
}

// Music class extends Midia
class Musica extends Midia {
  private double duracao;
  private Artista artista;
  private int nota;

  public Musica(String titulo, int ano, String genero, double duracao, Artista artista, int nota) {
    super(titulo, ano, genero);
    this.duracao = duracao;
    this.artista = artista;
    this.nota = nota;
  }

  public double getDuracao() {
    return duracao;
  }

  public void setDuracao(double duracao) {
    this.duracao = duracao;
  }

  public Artista getArtista() {
    return artista;
  }

  public void setArtista(Artista artista) {
    this.artista = artista;
  }

  public int getNota() {
    return nota;
  }

  // Check if the note is between 1 and 5
  public void setNota(int nota) {

    if (nota > 0 && nota <= 5) {
      this.nota = nota;
    } else {
      System.out.println("Nota inválida, atribua uma nota entre 1 e 5.");
    }
  }

  // Print the details of the music
  public void details() {
    String formatedTime = String.format("%.2f", this.getDuracao()); // Format the time to 2 decimal
    formatedTime = formatedTime.replace(",", ":"); // Replace the comma to colon

    System.out.println("Titulo: " + this.getTitulo());
    System.out.println("Ano: " + this.getAno());
    System.out.println("Genero: " + this.getGenero());
    System.out.println("Duração: " + formatedTime + "min");
    System.out.println("Artista: " + this.getArtista().getNome());
    System.out.println("Nota: " + this.getNota());
  }
}


// Film class extends Midia
class Filme extends Midia {
  private double duracao;
  private String tipo;
  private Ator[] elenco;
  private String diretor;
  private String produtor;

  public Filme(String titulo, int ano, String genero, double duracao, Ator[] elenco, String diretor,
      String produtor) {
    super(titulo, ano, genero);
    this.duracao = duracao;
    this.elenco = elenco;
    this.setTipo(duracao);
    this.diretor = diretor;
    this.produtor = produtor;
  }

  public double getDuracao() {
    return duracao;
  }

  public void setDuracao(double duracao) {
    this.duracao = duracao;
  }

  public String getTipo() {
    return tipo;
  }

  // Check if the movie is short or long
  public void setTipo(double duracao) {
    if (duracao < 90) {
      this.tipo = "Curta";
    } else {
      this.tipo = "Longa";
    }
  }

  public Ator[] getElenco() {
    return elenco;
  }

  public void setElenco(Ator[] elenco) {
    this.elenco = elenco;
  }

  public String getDiretor() {
    return diretor;
  }

  public void setDiretor(String diretor) {
    this.diretor = diretor;
  }

  public String getProdutor() {
    return produtor;
  }

  public void setProdutor(String produtor) {
    this.produtor = produtor;
  }

  // Print the details of the movie
  public void details() {
    int convertedTimeToHours = (int) this.getDuracao() / 60; // Convert the time to hours
    int convertedTimeToMinutes = (int) this.getDuracao() % 60; // Convert the time to minutes

    System.out.println("Titulo: " + this.getTitulo());
    System.out.println("Ano: " + this.getAno());
    System.out.println("Genero: " + this.getGenero());
    System.out.println("Duração: " + convertedTimeToHours + "h" + convertedTimeToMinutes + "min");
    System.out.println("Tipo: " + this.getTipo());
    System.out.println("Diretor: " + this.getDiretor());
    System.out.println("Produtor: " + this.getProdutor());
    System.out.print("Elenco ");
    for (Ator ator : this.getElenco()) {
      System.out.print(" | " + ator.getNome() + " | ");
    }
    System.out.println("");
  }
}
