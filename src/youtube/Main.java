package youtube;

import java.time.LocalDateTime;
import youtube.model.Song;


public class Main {
    public static void main(String[] args) {
        Song the_scientist = new Song(
                "The Scientist",
                "Coldplay",
                "A Rush of Blood to the head",
                2002
        );

        the_scientist.printLabel(); // Normal

        // Normal -> Auge
        the_scientist.setReproductions(1_001);
        the_scientist.printLabel(); // Auge

        // Auge -> Normal
        the_scientist.setDislikes(5_000);
        the_scientist.printLabel(); // Normal

        // Normal - Tendencia
        the_scientist.setReproductions(50_001);
        the_scientist.setLikes(20_001);
        the_scientist.printLabel(); // Tendencia

        // Tendencia -> Normal
        the_scientist.setLastPlayedTime(LocalDateTime.now().minusDays(2));
        the_scientist.printLabel(); // Normal




    }
}