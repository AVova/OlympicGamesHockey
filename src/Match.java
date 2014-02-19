import java.util.Random;

/**
 * Created by user on 16.02.14.
 */
public class Match {
    Country CountryA, CountryB;
    Country Winner, Looser;
    public int AGoals, BGoals;
    public boolean isPlayed=false;
    Match(Country a, Country b){
        this.CountryA=a;
        this.CountryB=b;
    }
    public void setPlayed(int a,int b){
        isPlayed=true;
        AGoals=a;
        BGoals=b;
        if (a>b) {Winner = CountryA;
                Looser = CountryB;}
        else {Winner = CountryB;
            Looser = CountryA;}
    }
    public void setPlayed(){
        int a = Main.random(10);
        int b = Main.random(10);
        while (a==b) b= Main.random(10);
        setPlayed(a,b);
    }
}
