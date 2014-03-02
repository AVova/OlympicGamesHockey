import javax.swing.*;

/**
 * Created by user on 16.02.14.
 */
public class Country {
    public String name = "";
    public int goals=0;
    public int points = 0;

    public void addGoals(int x){ goals+=x; }
    public void addPoints(int x) { points +=x;}
    public void setName(String nname) {
        this.name = nname;
    }

    public Group group;
    public int Place;

    public String getStats(){
        return ("country: group : points : goals = "+name+" : "+group.name+" : " +points+" : "+goals);

    }
}
