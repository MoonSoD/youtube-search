package xyz.moonsod.youtubevideosearch;

import xyz.moonsod.youtubevideosearch.obj.GoogleAPI;

import javax.naming.directory.SearchResult;
import java.io.Reader;
import java.util.Scanner;

public class Application {
    //private final Settings settings;
    private final Scanner scanner = new Scanner(System.in);
    private final GoogleAPI googleAPI;

    public Application() {
        /*this.settings = new Settings();
        this.settings.loadSettings();*/

        googleAPI = new GoogleAPI("AIzaSyCtika1GgOfmdCS1cM8-Vj0KrcJVgmO9iU");
    }

    public void start() {
        System.out.print("\nZadajte vyhladanie: ");
        String search = scanner.next();

        System.out.println("Zobrazujem najrelevantnejsie videa k vyhladavaniu:\n");

        googleAPI.getVideos(search, 5).forEach(videoEntry -> {
            System.out.println("--------------------------------------");
            System.out.printf("Nazov: %s", videoEntry.getTitle());
            System.out.printf("\nAutor: %s", videoEntry.getAuthor());
            System.out.println("\n--------------------------------------");
            System.out.println(" ");
        });
    }

}
