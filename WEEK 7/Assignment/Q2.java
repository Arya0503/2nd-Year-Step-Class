import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String title) {
        if (this.count < this.songs.length) {
            this.songs[this.count] = title;
            this.count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(this.songs, this.count);
    }

    public int getSongCount() {
        return this.count;
    }
}

public class PlaylistMain {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Song at index 0: " + p.getSongs()[0]);
        System.out.println("Total Songs: " + p.getSongCount());
    }
}