/**
 * Created by user on 16.02.14.
 */
public class Match {
    Country CountryA, CountryB;
    Country Winner, Looser;
    public int AGoals, BGoals;
    public boolean isPlayed=false;
    boolean ifAisWinner=false;
    Match(Country a, Country b){
        this.CountryA=a;
        this.CountryB=b;
    }
    public void setPlayed(int a,int b){
        isPlayed=true;
        AGoals=a;
        CountryA.addGoals(a);
        BGoals=b;
        CountryB.addGoals(b);
        if (a>b) {Winner = CountryA;
                Looser = CountryB;
                ifAisWinner = true;
                CountryA.addPoints(1);
        }
        else {Winner = CountryB;
            Looser = CountryA;
            CountryB.addPoints(1);}
    }
    public void setPlayed(){
        int a = GroupPlaying.random(10);
        int b = GroupPlaying.random(10);
        while (a==b) b = GroupPlaying.random(10);
        setPlayed(a,b);
    }
    public String getResults(){
        if (ifAisWinner)
            return (Winner.name+" vs "+Looser.name + " : "+AGoals+" - " + BGoals);
        else
            return (Winner.name+" vs "+Looser.name + " : "+BGoals+" - " + AGoals);
    }
}
