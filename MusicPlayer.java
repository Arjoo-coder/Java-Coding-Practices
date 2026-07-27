// 1. Node class representing a Song
class SongNode {
    String title;
    String artist;
    SongNode next;
    SongNode prev;

    public SongNode(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
        this.prev = null;
    }
}

// 2. Playlist Class using Circular Doubly Linked List
class Playlist {
    private SongNode head = null;
    private SongNode currentSong = null;

    // Add a song to the end of the playlist
    public void addSong(String title, String artist) {
        SongNode newSong = new SongNode(title, artist);

        if (head == null) {
            head = newSong;
            head.next = head; // Pointing to itself (Circular)
            head.prev = head; // Pointing to itself (Circular)
            currentSong = head; // Set initial playing song
        } else {
            SongNode last = head.prev; // In CDLL, head.prev is always the last node

            last.next = newSong;
            newSong.prev = last;
            newSong.next = head;
            head.prev = newSong; // Update head's prev to the new last node
        }
        System.out.println("Added: " + title + " by " + artist);
    }

    // Play the current song
    public void playCurrent() {
        if (currentSong == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        System.out.println("🎶 Now Playing: " + currentSong.title + " - " + currentSong.artist);
    }

    // Skip to the next song
    public void nextSong() {
        if (currentSong != null) {
            currentSong = currentSong.next;
            System.out.print("[Skipped Next] -> ");
            playCurrent();
        }
    }

    // Go back to the previous song
    public void prevSong() {
        if (currentSong != null) {
            currentSong = currentSong.prev;
            System.out.print("[Went Back] -> ");
            playCurrent();
        }
    }

    // Display the entire playlist loop once
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("\n--- Your Playlist Queue ---");
        SongNode temp = head;
        do {
            System.out.println("🎵 " + temp.title + " (" + temp.artist + ")");
            temp = temp.next;
        } while (temp != head);
        System.out.println("---------------------------\n");
    }
}

// 3. Main Class to run the Simulation
public class MusicPlayer {
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();

        // Adding songs
        myPlaylist.addSong("Blinding Lights", "The Weeknd");
        myPlaylist.addSong("Stay", "Kid LAROI & Justin Bieber");
        myPlaylist.addSong("Shape of You", "Ed Sheeran");

        // Display the queue
        myPlaylist.displayPlaylist();

        // Simulating playback controls
        myPlaylist.playCurrent();  // Plays Song 1
        myPlaylist.nextSong();     // Plays Song 2
        myPlaylist.nextSong();     // Plays Song 3
        
        // Circular Behavior Test (Last song to First song)
        myPlaylist.nextSong();     // Wraps around to Song 1

        // Circular Behavior Test (First song to Last song)
        myPlaylist.prevSong();     // Wraps back to Song 3
    }
}
