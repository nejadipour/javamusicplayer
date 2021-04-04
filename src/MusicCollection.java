import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * @author Alireza Nejadipour
 * @version 6 (3/26/2021)
 */

public class MusicCollection
{
    private final ArrayList<Artist> artists;
    private final ArrayList<Music> musics;
    private final ArrayList<Genre> genres;
    private final ArrayList<Music> favorites;
    private ArrayList<Music> searchResult;

    /**
     * create a new music collection
     */
    public MusicCollection()
    {
        artists = new ArrayList<>();
        musics = new ArrayList<>();
        genres = new ArrayList<>();
        favorites = new ArrayList<>();
        searchResult = new ArrayList<>();

    }


    /**
     * all the musics available in the library will be placed by this method
     * @return if no music is available returns false
     */
    public boolean displayMusics()
    {
        int musicNum = 1;

        if (musics.size() == 0)
        {
            System.out.println("No music found.");
            return false;

        }
        else
        {
            for (Music music : musics)
            {
                System.out.println("Music " + musicNum + ":");
                music.print();

                musicNum++;

            }

            return true;

        }

    }


    /**
     * adds a new music to the list of musics
     * @param music the music to be added
     * @return if the music is not new and it is found in the library returns false
     */
    public boolean addMusic(Music music)
    {
        if (findMusic(music.getAddress()) == null)
        {
            musics.add(music);

            String artistName = music.getArtist();
            Artist artist = findArtist(artistName);
            if (artist == null)
            {
                artist = new Artist(artistName);
                artists.add(artist);

            }
            artist.addMusic(music);

            String genreName = music.getGenre();
            Genre genre = findGenre(genreName);
            if (genre == null)
            {
                genre = new Genre(genreName);
                genres.add(genre);

            }
            genre.addMusic(music);

            return true;

        }
        else
        {
            return false;

        }

    }


    /**
     * looks into the musics list to find a music by the given address
     * each music has its particular address
     * @param address the address of where music is located
     * @return if the music is found returns the music, else returns null
     */
    public Music findMusic(String address)
    {
        for (Music music : musics)
        {
            if (music.getAddress().equals(address))
            {
                return music;

            }

        }

        return null;

    }


    /**
     * removes the passed music from the musics list
     * @param address the address of music to remove
     * @return if music is not available returns false-_-
     */
    public boolean removeMusic(String address)
    {
        Music musicToRemove = findMusic(address);

        if (musicToRemove == null)
        {
            return false;
        }
        else
        {
            musics.remove(musicToRemove);

            Artist artist = findArtist(musicToRemove.getArtist());
            artist.removeMusic(musicToRemove);

            Genre genre = findGenre(musicToRemove.getGenre());
            genre.removeMusic(musicToRemove);

            removeFavorite(musicToRemove);

            return true;

        }

    }


    /**
     * all the artists of the music library will be placed by this method
     * @return if no artist is available in the musics list it returns false
     */
    public boolean displayArtists()
    {
        int artistNum = 1;

        if (artists.size() == 0)
        {
            System.out.println("No artist found.");
            return false;
        }
        else
        {
            for(Artist artist : artists)
            {
                System.out.println("Artist " + artistNum + ":");
                artist.print();

                artistNum++;

            }

        }

        return true;

    }


    /**
     * adds the given artist to the artists' list
     * @param artist the artist that should be added
     * @return false if the artist is already available
     */
    public boolean addArtist(Artist artist)
    {
        if (findArtist(artist.getName()) == null)
        {
            artists.add(artist);
            return true;

        }
        else
        {
            return false;

        }

    }


    /**
     * the method will search the list of artists to find the artist by given name
     * @param name the name of artist that should be found
     * @return if the artist is found returns the artist, else returns null
     */
    public Artist findArtist(String name)
    {
        for(Artist artist : artists)
        {
            if(artist.getName().equals(name))
            {
                return artist;

            }

        }

        return null;

    }


    /**
     * removes the artist from the list by given name
     * @param name the name of artist that should be removed
     */
    public void removeArtist(String name)
    {
        Artist artistToRemove = findArtist(name);

        if (artistToRemove == null)
        {
            System.out.println("Artist doesn't exist.");

        }
        else
        {
            // remove all the musics of the artist
            ArrayList<Music> musicsToRemove = artistToRemove.getMusics();

            while(musicsToRemove.size() != 0)
            {
                Music music = musicsToRemove.get(0);
                removeMusic(music.getAddress());
                musicsToRemove.remove(music);

            }

            artists.remove(artistToRemove);

            System.out.println("Artist removed.");

        }

    }


    /**
     * all the genres available in the music library will be placed by this method
     * @return if there is no genre available the method will return false
     */
    public boolean displayGenres()
    {
        int genreNum = 1;

        if (genres.size() == 0)
        {
            System.out.println("No genre found.");
            return false;
        }
        else
        {
            for(Genre genre : genres)
            {
                System.out.println("Genre " + genreNum + ":");
                genre.print();

                genreNum++;

            }

        }

        return true;

    }


    /**
     * new genre will be added to the genres' list by this method
     * @param genre the genre that should be added
     * @return if the genre is already available it will return false
     */
    public boolean addGenre(Genre genre)
    {
        if (findGenre(genre.getName()) == null)
        {
            genres.add(genre);
            return true;

        }
        else
        {
            return false;

        }

    }


    /**
     * the method will search the genres' list to find the genre by the given name
     * @param name the name of the genre that should be found
     * @return if the genre is not available returns null
     */
    public Genre findGenre(String name)
    {
        for(Genre genre : genres)
        {
            if(genre.getName().equals(name))
            {
                return genre;

            }

        }

        return null;

    }


    /**
     * removes the genre from he list by the given name
     * @param name if the genre is not found returns false
     */
    public void removeGenre(String name)
    {
        Genre genreToRemove = findGenre(name);

        if (genreToRemove == null)
        {
            System.out.println("Genre doesn't exist.");

        }
        else
        {
            // remove all the songs of the genre
            ArrayList<Music> musicsToRemove = genreToRemove.getMusics();
            while(musicsToRemove.size() != 0)
            {
                Music music = musicsToRemove.get(0);
                removeMusic(music.getAddress());
                musicsToRemove.remove(music);

            }

            genres.remove(genreToRemove);

            System.out.println("Genre removed.");

        }

    }


    /**
     * favorite musics will be printed
     * @return if the favorites' list is empty returns false
     */
    public boolean displayFavorites()
    {
        int favoriteNum = 1;

        if (favorites.size() == 0)
        {
            System.out.println("No favorite found.");
            return false;

        }
        else
        {
            for(Music music : favorites)
            {
                System.out.println("Favorite " + favoriteNum + ":");
                music.print();

                favoriteNum++;

            }

        }

        return true;

    }


    public void addFavorite(Music music)
    {
        if (findFavorite(music.getAddress()) == null)
        {
            favorites.add(music);
            System.out.println("Music added.");

        }
        else
        {
            System.out.println("Music is already in favorites.");

        }


    }


    /**
     * removes given music from the favorites' list
     * @param music the music that should remove from the list of favorites
     */
    public void removeFavorite(Music music)
    {
        favorites.remove(music);

    }


    /**
     * finds the music from the favorites' list by the given address
     * @param address the location of the music that should be removed
     * @return null if music is not available
     */
    public Music findFavorite(String address)
    {
        for (Music music : favorites)
        {
            if (music.getAddress().equals(address))
            {
                return music;

            }

        }

        return null;

    }


    /**
     * searches the data to find the given string
     * @param word the string that search will be based on
     * @return if nothing is found returns false
     */
    public boolean search(String word)
    {
        for(Music music : musics)
        {
            // search is not case sensitive
            if (music.getName().toLowerCase().contains(word.toLowerCase()) ||
                    music.getArtist().toLowerCase().contains(word.toLowerCase()) ||
                    music.getGenre().toLowerCase().contains(word.toLowerCase()))
            {
                searchResult.add(music);

            }

        }

        return searchResult.size() != 0;

    }


    /**
     * search results will be placed by this method
     */
    public void displayResults()
    {
        int resNum = 1;

        for (Music music : searchResult)
        {
            System.out.println("Result " + resNum + ":");

            music.print();

            resNum++;

        }

    }


    /**
     * gets the artist available
     * @return the artists field will be returned
     */
    public ArrayList<Artist> getArtists()
    {
        return artists;

    }

    /**
     * gets all the musics of the music player
     * @return field musics will be returned
     */
    public ArrayList<Music> getMusics()
    {
        return musics;

    }

    /**
     * gets genres available in the player's library
     * @return genres field
     */
    public ArrayList<Genre> getGenres()
    {
        return genres;

    }

    /**
     * gets favorites musics
     * @return favorites field will be returned
     */
    public ArrayList<Music> getFavorites()
    {
        return favorites;

    }

    /**
     * gets search results after searching a word
     * @return searchResults field will be returned
     */
    public ArrayList<Music> getSearchResult()
    {
        return searchResult;

    }

    /**
     * each time searching and finding is finished
     * the searchResults list should get empty
     * it happens by this method;)
     * @param searchResult sets the searchResult field
     */
    public void setSearchResult(ArrayList<Music> searchResult)
    {
        this.searchResult = searchResult;

    }

}