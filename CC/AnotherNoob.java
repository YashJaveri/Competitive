import java.util.*;
/*I being a Noob thought of another very simple problem.
Noob being a noob has a playlist of N songs. Each song is characterized by di and gi denoting the duration and genre of the song.
Again, Noob being a noob needs to practice CP so he can only listen to songs for exactly T minutes.
Again, Noob being a noob wants to play any song at most once also no two songs with the same genre should be played one after the other. 
Again, Noob being a noob wants to know how many possible combinations exist such that each song is played at the most once and the sum of the duration of all the songs selected is exactly T.*/

class Song{
    private int dur = -1, genre = -1;

    public Song(int dur, int genre){
        this.dur = dur;
        this.genre = genre;
    }

    public int getDur(){
        return this.dur;
    }

    public int getGenre(){
        return this.genre;
    }

    @Override
    public String toString() { 
        return String.format("D: " + this.dur + " G: " + this.genre);
    } 
}

public class AnotherNoob {
    static int N, totalTime;    
    static ArrayList<ArrayList<Song> > subSetOfSongs = new ArrayList<ArrayList<Song> >();
    static ArrayList<ArrayList<Integer> > genreCountSet = new ArrayList<ArrayList<Integer> >();

    private static void print(Object s){        
        System.out.println(s.toString());
    }

    static void subSet(List<Song> set, int setSize) 
    {        
        long powSetSize = (long)Math.pow(2, setSize);
        int counter, j;
        
        for(counter = 0; counter <  powSetSize; counter++) 
        {
            ArrayList<Song> subSongs = new ArrayList<Song>();
            ArrayList<Integer> genreCount = new ArrayList<Integer>(Collections.nCopies(3, 0));

            int totalDuration = 0;
            //Subset using Bitmasking
            for(j = 0; j < setSize; j++) 
            {                
                if((counter & (1 << j)) > 0) 
                {
                    Song s = set.get(j);
                    subSongs.add(s);
                    totalDuration += s.getDur();
                    if(totalDuration>totalTime)
                    {
                        subSongs.clear();
                        break;
                    }
                    //Genre count:
                    genreCount.set(s.getGenre()-1, genreCount.get(s.getGenre()-1)+1);
                }
            }
            //Only retain those with duratio = Total Time given in the question
            if(subSongs.size() != 0 && totalDuration == totalTime)
            {
                subSetOfSongs.add(subSongs);
                if(genreCount.size() != 0)
                    genreCountSet.add(genreCount);
            }            
        }
    }
          
    static private void algo(List<Song> songs){
        /*Calculate subsets*/
        subSet(songs, N);
        /*subSetOfSongs: Subset of songs with "D:" as duration and "G:" as genre*/
        //print("Subset with duration=total time: " + subSetOfSongs);
        /*genreCountSet: Subset of genre counts (i.e. total number of each of the genres)*/
        //print("And their corresponding genre counts: " + genreCountSet);        
        long totalCombos = 0;

        print("Valid ones after removing sets where alternate is not possible:");
        for(int i=0; i<genreCountSet.size(); i++){
            //print(genreCountSet.get(i));
            int sizeOfCurrSubSet = subSetOfSongs.get(i).size();
            boolean isValid = true;
            for(int j=0; j<3; j++){
                //Check validity wether alternate diferent genres is possible or not
                if((sizeOfCurrSubSet%2 == 0 && genreCountSet.get(i).get(j) > (sizeOfCurrSubSet/2)) 
                    || (sizeOfCurrSubSet%2 != 0 && genreCountSet.get(i).get(j) > ((sizeOfCurrSubSet+1)/2)))
                {
                    isValid = false;
                    break;
                }                
            }
            if(isValid)
            {                
                print(subSetOfSongs.get(i));
                //Calculate permutations code:-

            }
        }
    }

    public static void main (String[] args) 
    {       
        Scanner sc = new Scanner(System.in);
        List<Song> songs = new ArrayList<>();        

        N = sc.nextInt();
        totalTime = sc.nextInt();

        int d, g;
        for(int i=0; i<N; i++){
            d = sc.nextInt();
            g = sc.nextInt();
            Song s = new Song(d, g);         
            songs.add(s);
        }        
        algo(songs);
    }
}
