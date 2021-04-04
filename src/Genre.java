import java.util.ArrayList;

/**
 * A class to hold details of each genre
 *
 * @author Alireza Nejadipour
 * @version 4.2 (3/25/2021)
 */

public class Genre
{
    private final String name;
    private final ArrayList<Music> musics;

    /**
     * create new Genre by the given name
     * @param name the name of genre
     */
    public Genre(String name)
    {
        this.name = name;
        musics = new ArrayList<>();

    }


    /**
     * adds the given music to the list of musics
     * @param music the music to be added
     */
    public void addMusic(Music music)
    {
        if (findMusic(music.getName()) == null)
        {
            musics.add(music);

        }

    }


    /**
     * finds the passed music in the list of musics
     * @param name name of the music to be found
     * @return the music if it is found
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
     * removes the given music from the list of musics
     * @param music the music to be removed
     */
    public void removeMusic(Music music)
    {
        musics.remove(music);

    }


    /**
     * prints the information of each genre
     * like the name and the songs it has
     */
    public void print()
    {
        System.out.println(getName() + " | " + getMusics().size() + " musics");

    }


    /**
     * prints the musics available in the genre
     * @return if there is no song available it returns false
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
     * gets the name of genre
     * @return field name is returned
     */
    public String getName()
    {
        return name;
    }

    /**
     * gets the list of musics the genre has
     * @return musics field
     */
    public ArrayList<Music> getMusics()
    {
        return musics;
    }

}