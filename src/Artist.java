import java.util.ArrayList;

/**
 * A class to hold details of each artist
 *
 * @author Alireza Nejadipour
 * @version 4 (3/26/2021)
 */

public class Artist
{
    private final String name;
    private final ArrayList<Music> musics;

    /**
     * create a new artist with the given name
     * @param name the name of artist
     */
    public Artist(String name)
    {
        this.name = name;
        musics = new ArrayList<>();

    }


    /**
     * adds a new music to the list of musics
     * @param music the music to add
     */
    public void addMusic(Music music)
    {
        if (findMusic(music.getName()) == null)
        {
            musics.add(music);

        }

    }


    /**
     * checks the given music to see if it is new or not
     * @param name the name of music to be checked
     * @return if the music is found returns the music, else returns null
     */
    public Music findMusic(String name)
    {
        for (Music music : musics)
        {
            if (music.getName().equals(name))
            {
                return music;

            }

        }

        return null;
    }


    /**
     * removes a music from the list
     * @param music the music to be removed
     */
    public void removeMusic(Music music)
    {
        musics.remove(music);

    }


    /**
     * prints the data of artist
     * like the name and the number of musics by the artist
     */
    public void print()
    {
        System.out.println(getName() + " | " + getMusics().size() + " musics");
    }


    /**
     * prints all the songs of the artist
     * @return false if no music is available
     */
    public boolean printMusics()
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

            }

            return true;

        }

    }


    /**
     * gets the name of artist
     * @return name field
     */
    public String getName()
    {
        return name;
    }

    /**
     * gets the list of musics by the artist
     * @return musics field is returned
     */
    public ArrayList<Music> getMusics()
    {
        return musics;
    }

}