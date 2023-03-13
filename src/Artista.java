public class Artista {
  private String nome;
  private String dataNascimento;
  private String premiacoes;
  private String genero;

  public Artista(String nome, String dataNascimento, String premiacoes, String genero) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.premiacoes = premiacoes;
    this.genero = genero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getPremiacoes() {
    return premiacoes;
  }

  public void setPremiacoes(String premiacoes) {
    this.premiacoes = premiacoes;
  }

  public String getgenero() {
    return genero;
  }

  public void setgenero(String genero) {
    this.genero = genero;
  }
}

// Actor class extends Artista
class Ator extends Artista {
  private String formacao;

  public Ator(String nome, String dataNascimento, String premiacoes, String genero, String formacao) {
    super(nome, dataNascimento, premiacoes, genero);
    this.formacao = formacao;
  }

  public String getFormacao() {
    return formacao;
  }

  public void setFormacao(String formacao) {
    this.formacao = formacao;
  }
}

// Musician class extends Artista
class Musico extends Artista {
  private String atuacao;

  public Musico(String nome, String dataNascimento, String premiacoes, String genero, String atuacao) {
    super(nome, dataNascimento, premiacoes, genero);
    this.atuacao = atuacao;
  }

  public String getAtuacao() {
    return atuacao;
  }

  public void setAtuacao(String atuacao) {
    this.atuacao = atuacao;
  }
}