public class App {
    public static void main(String[] args) throws Exception {
        Playlist playlist = new Playlist();
        Biblioteca biblioteca = new Biblioteca("Vinicius", playlist);
        biblioteca.tocar_playlist(); //
    }
}