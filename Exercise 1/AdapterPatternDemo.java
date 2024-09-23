// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee
class VlcPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file. Name: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    VlcPlayer vlcPlayer;

    public MediaAdapter() {
        vlcPlayer = new VlcPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName);
        }
    }
}

// Concrete class implementing MediaPlayer
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter();
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media type. " + audioType + " format not supported.");
        }
    }
}

// Usage
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("vlc", "song.vlc");
    }
}
