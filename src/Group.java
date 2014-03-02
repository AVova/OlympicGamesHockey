import static java.lang.System.out;

/**
 * Created by user on 18.02.14.
 */
public class Group {
    public String name;
    public static int played=0;
    Country cts[] = new Country[4];
    Group(Country c1, Country c2, Country c3, Country c4){
        this.cts[0]=c1;
        this.cts[1]=c2;
        this.cts[2]=c3;
        this.cts[3]=c4;
        c1.group=this;
        c2.group=this;
        c3.group=this;
        c4.group=this;
    }
    public void printStats(){
        out.println("Place 1___"+cts[0].getStats());
        out.println("Place 2___"+cts[1].getStats());
        out.println("Place 3___"+cts[2].getStats());
        out.println("Place 4___"+cts[3].getStats());
    }

    //в результате этого метода команды будут по местам расставлены с помощью сравнения очков и голов
    public void SortByStats(){
        for (Country cc : cts)
        {
            for(int i = 0; i<4; i++)
            {
                if (cc.points > cts[i].points)
                    cc.Place++;
                else if((cc.points == cts[i].points) && (cc.goals>cts[i].goals) )
                       cc.Place++;
            }
            cc.Place = - cc.Place + 4;
        }

        Country[] tmp = new Country[4];
        for(int i=0; i<4; i++)
            tmp[i] = cts[i];
        for(int i =0; i<4; i++)
            cts[tmp[i].Place-1]=tmp[i];
    }

}
