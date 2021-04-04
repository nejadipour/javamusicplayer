import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class is used to run all the program
 * @author Alireza Nejadipour
 * @version 6 (3/26/2021)
 */

public class Run
{
    private final String mainMenu;
    private final String musicsMenu;
    private final String artistsMenu;
    private final String genresMenu;
    private final String favoriteMenu;
    private int choice;
    private final Scanner scanner;
    public MusicCollection runtimeMusicCollection;

    /**
     * create a new run
     */
    public Run()
    {
        runtimeMusicCollection = new MusicCollection();

        scanner = new Scanner(System.in).useDelimiter("\n");

        mainMenu =
                """
                        1.Musics
                        2.Artists
                        3.Genres
                        4.Favorites
                        5.Search
                        6.Exit
                        """;

        musicsMenu =
                """
                        1.Show musics
                        2.Add music
                        3.Remove music
                        4.Main menu
                        """;

        artistsMenu =
                """
                        1.Show artists
                        2.Add artist
                        3.Remove artist
                        4.Main menu
                        """;

        genresMenu =
                """
                        1.Show generes
                        2.Add genre
                        3.Remove genre
                        4.Main menu
                        """;

        favoriteMenu =
                """
                        1.Show favorites
                        2.Add favorite
                        3.Remove favorite
                        4.Main menu
                        """;

    }


    /**
     * anytime the user should choose between
     */
    public void userChoice()
    {
        System.out.print("Your Choice : ");
        choice = scanner.nextInt();

    }


    /**
     * prints the main menu
     */
    public void printMainMenu()
    {
        System.out.println(mainMenu);
        userChoice();

        switch (choice)
        {
            case 1:
                printMusicsMenu();
                break;
            case 2:
                printArtistsMenu();
                break;

            case 3:
                printGenresMenu();
                break;

            case 4:
                printFavoriteMenu();

            case 5:
                search();
                break;

            case 6:
                System.out.println("Hope U great music times!");
                System.exit(0);
                break;

        }

    }


    /**
     * prints the menu related to the musics part
     */
    public void printMusicsMenu()
    {
        System.out.println(musicsMenu);

        userChoice();

        switch (choice)
        {
            case 1 ->
                    {
                        if (runtimeMusicCollection.displayMusics())
                        {
                            userChoice();

                            String address = runtimeMusicCollection.getMusics().get(choice - 1).getAddress();
                            if (Player.startPlay(address))
                            {
                                System.out.println("Music finished.");

                            }
                            else
                            {
                                System.out.println("Couldn't open the file.");

                            }

                        }
                        printMusicsMenu();
                    }
            case 2 ->
                    {
                        addMusic();
                        printMusicsMenu();

                    }
            case 3 ->
                    {
                        removeMusic();
                        printMainMenu();

                    }
            case 4 -> printMainMenu();

        }

    }


    /**
     * gets all the information about a music
     * like name, genre and address
     * then tries to add it to the musics
     */
    public void addMusic()
    {
        System.out.print("Enter the name : ");
        String name = scanner.next();

        System.out.print("Enter the artist : ");
        String artistName = scanner.next();

        System.out.print("Enter the genre : ");
        String genre = scanner.next();

        System.out.print("Enter the address : ");
        String address = scanner.next();

        System.out.print("Enter the year : ");
        int year = scanner.nextInt();

        Music musicToAdd = new Music(name, genre, artistName, address, year);

        if(runtimeMusicCollection.addMusic(musicToAdd))
        {
            System.out.println("Music added.");

        }
        else
        {
            System.out.println("Music is already available.");

        }

    }


    /**
     * gets all the information about a music then removes it
     */
    public void removeMusic()
    {
        System.out.print("Enter the address : ");
        String address = scanner.next();

        if (runtimeMusicCollection.removeMusic(address))
        {
            System.out.println("Music removed.");

        }
        else
        {
            System.out.println("Music is not available.");

        }

    }


    /**
     * this method prints the menu related to the artists
     */
    public void printArtistsMenu()
    {
        System.out.println(artistsMenu);

        userChoice();

        switch (choice)
        {
            case 1 ->
                    {
                        if (runtimeMusicCollection.displayArtists())
                        {
                            userChoice();
                            Artist artist = runtimeMusicCollection.getArtists().get(choice - 1);

                            if (artist.printMusics())
                            {
                                userChoice();

                                String address = artist.getMusics().get(choice - 1).getAddress();

                                if (Player.startPlay(address))
                                {
                                    System.out.println("Music finished.");

                                }
                                else
                                {
                                    System.out.println("Couldn't open the file.");

                                }

                            }

                        }
                        printArtistsMenu();
                    }
            case 2 ->
                    {
                        addArtist();
                        printArtistsMenu();

                    }
            case 3 ->
                    {
                        removeArtist();
                        printArtistsMenu();

                    }
            case 4 -> printMainMenu();
        }

    }


    /**
     * scans information needed to create a new artist
     * then adds the artist to the list
     */
    public void addArtist()
    {
        System.out.print("Enter the name of artist : ");
        String name = scanner.next();

        Artist artistToAdd = new Artist(name);

        if(runtimeMusicCollection.addArtist(artistToAdd))
        {
            System.out.println("Artist added.");

        }
        else
        {
            System.out.println("Artist already exists.");

        }

    }


    /**
     * scans the name and then tries to remove the artist
     */
    public void removeArtist()
    {
        System.out.print("Enter the name : ");
        String name = scanner.next();

        runtimeMusicCollection.removeArtist(name);

    }


    /**
     * prints the menu related to the genres part
     */
    public void printGenresMenu()
    {
        System.out.println(genresMenu);

        userChoice();

        switch (choice)
        {
            case 1 ->
                    {
                        if (runtimeMusicCollection.displayGenres())
                        {
                            userChoice();

                            Genre genre = runtimeMusicCollection.getGenres().get(choice - 1);

                            if (genre.printMusics())
                            {
                                userChoice();

                                String address = genre.getMusics().get(choice - 1).getAddress();

                                if (Player.startPlay(address))
                                {
                                    System.out.println("Music finished.");

                                }
                                else
                                {
                                    System.out.println("Couldn't open the file.");

                                }

                            }

                        }
                        printGenresMenu();

                    }
            case 2 ->
                    {
                        addGenre();
                        printGenresMenu();

                    }
            case 3 ->
                    {
                        removeGenre();
                        printGenresMenu();

                    }
            case 4 -> printMainMenu();

        }

    }


    /**
     * scans the name of the genre
     * creates new genre
     * and tries to add it to the genres' list
     */
    public void addGenre()
    {
        System.out.print("Enter the name of genre : ");
        String name = scanner.next();

        Genre genreToAdd = new Genre(name);

        if(runtimeMusicCollection.addGenre(genreToAdd))
        {
            System.out.println("Genre added.");

        }
        else
        {
            System.out.println("Genre already exists.");

        }

    }


    /**
     * scans the name of genre and tries to remove it
     */
    public void removeGenre()
    {
        System.out.print("Enter the name : ");

        String name = scanner.next();

        runtimeMusicCollection.removeGenre(name);

    }


    /**
     * prints the menu related to the favorites part
     * user decides what to happen next
     */
    public void printFavoriteMenu()
    {
        System.out.println(favoriteMenu);

        userChoice();

        switch (choice)
        {
            case 1->
                    {
                        if (runtimeMusicCollection.displayFavorites())
                        {
                            userChoice();

                            String address = runtimeMusicCollection.getFavorites().get(choice - 1).getAddress();
                            if (Player.startPlay(address))
                            {
                                System.out.println("Music finished.");

                            }
                            else
                            {
                                System.out.println("Couldn't open the file.");

                            }

                        }

                        printFavoriteMenu();

                    }
            case 2->
                    {
                        addFavorite();
                        printFavoriteMenu();

                    }
            case 3->
                    {
                        removeFavorite();
                        printFavoriteMenu();

                    }
            case 4-> printMusicsMenu();

        }

    }


    /**
     * prints all the musics and then the user decides which music to be added to favorites
     */
    public void addFavorite()
    {
        if (runtimeMusicCollection.displayMusics())
        {
            userChoice();

            String address = runtimeMusicCollection.getMusics().get(choice - 1).getAddress();

            Music musicToAdd = runtimeMusicCollection.findMusic(address);

            runtimeMusicCollection.addFavorite(musicToAdd);

        }

    }


    /**
     * displays all the favorite musics
     * then the user decides which music to be removed from favorites
     */
    public void removeFavorite()
    {
        if (runtimeMusicCollection.displayFavorites())
        {
            userChoice();

            String address = runtimeMusicCollection.getFavorites().get(choice - 1).getAddress();

            Music musicToRemove = runtimeMusicCollection.findMusic(address);

            runtimeMusicCollection.removeFavorite(musicToRemove);

            System.out.println("Music removed from favorites.");

        }

    }


    /**
     * scans the string user wanna search
     */
    public void search()
    {
        System.out.print("Enter the name of music, artist, genre : ");
        String wordToSearch = scanner.next();

        if (runtimeMusicCollection.search(wordToSearch))
        {
            runtimeMusicCollection.displayResults();

            userChoice();

            String address = runtimeMusicCollection.getSearchResult().get(choice - 1).getAddress();

            if (Player.startPlay(address))
            {
                System.out.println("Music finished.");

            }
            else
            {
                System.out.println("Couldn't open the file.");

            }

            ArrayList<Music>searchResults = new ArrayList<>();
            runtimeMusicCollection.setSearchResult(searchResults);

        }
        else
        {
            System.out.println("Nothing found.");

        }
        printMainMenu();

    }


    public static void main(String[] args)
    {
        Run run = new Run();

        run.printMainMenu();
    }

}