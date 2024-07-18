
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Song{
    String title, artist, genre, duration;


    Song(String title, String artist, String genre, String duration){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }
}
class MusicPlayer{
    ArrayList<Song> song_obj = new ArrayList<>();
    ArrayList<String> song_genre = new ArrayList<>();
    void add(Song obj){
        for (Song song : song_obj){
            if (obj.title.equals(song.title)){
                System.out.println("Song Already exist");
                return ;
            }
        }
        song_obj.add(obj);
        System.out.println("Song added Successfully");
        for (String genre : song_genre){
            if (obj.genre.equals(genre)){
                return;
            }
        }
        song_genre.add(obj.genre);

    }
    void remove(String title){
        for (Song song : song_obj){
            if (title.equals(song.title)){
                System.out.println("Song Removed Successfully");
                song_obj.remove(song);
                return ;
            }
        }
    }
    void suffle(){
        Collections.shuffle(song_obj);
        System.out.println("Playlist Shuffle Successfully");
    }

    ArrayList<ArrayList<Song>> base_genre_song = new ArrayList<>();

    void genre(){
        ArrayList<Song> song_user = new ArrayList<>();
        for (String genre : song_genre){
            for (Song music : song_obj){
                    if (music.genre.equals(genre)){
                        song_user.add(music);
                    }
            }
            base_genre_song.add(song_user);
        }
    }
    void print(String genre){
        for (ArrayList<Song> item : base_genre_song){
            for (Song song : item ){
                if (song.genre.equals(genre)){
                    System.out.println("Title: "+song.title);
                    System.out.println("Artist: "+song.artist);
                    System.out.println("Duration: "+song.duration);
                }

            }
        }
    }
}




public class Music_Playlist_Organizer {
    public static void main(String[]args) throws IOException {
        System.out.println("-----Music Playlist-----");

        MusicPlayer playlist = new MusicPlayer();
        Scanner user = new Scanner(System.in);
        String userchoice;
        do{
            System.out.print("What you want to do ? (Add/Remove/Shuffle/Genre/Print): ");
            String choice=user.next().toLowerCase();
            switch (choice){
                case "add":
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Song Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Artist Name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Song Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Song Duration: ");
                    String duration = scanner.nextLine();
                    Song userSong = new Song(title, artist, genre, duration);
                    playlist.add(userSong);
                    break;
                case "remove":
                    System.out.print("Song Title: ");
                    String removeSongTitle = user.nextLine();
                    playlist.remove(removeSongTitle);
                    break;
                case "shuffle":
                    playlist.suffle();
                    break;
                case "print":
                    Scanner playSong = new Scanner(System.in);
                    System.out.print("Genre : ");
                    String playSongTitle = playSong.nextLine();
                    playlist.genre();
                    playlist.print(playSongTitle);
                    break;
                case "genre":
                    playlist.genre();
                    break;
                default:
                    System.out.println("Invalid Command");

            }
            System.out.print("Do you want to Continue (y or n):  ");
            userchoice=user.next().toLowerCase();
        } while (userchoice.equals("y"));
        System.out.println("Thanks");
    }
}
