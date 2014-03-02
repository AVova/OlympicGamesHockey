/**
 * Created by user on 16.02.14.
 */
public class GroupPlaying {
    //выдает случайное число от 0 до а
    public static int random(int a){
        return ( (int)(Math.random()*1000)  )%a;
    }
    //случайно сортирует num объектов
    public static void myRsort(Object[] o, int num){
        int r;
        for(int i=0; i<num; i++)
        {
            Object tmp = o[i];
            r=random(num);
            o[i] = o[r];
            o[r]=tmp;

        }
    }


    public static void main(String args[]){
        Country c[] = new Country[12];
        for(int i=0; i<9 ; i++)
        {
            c[i] = new Country();
            c[i].setName("0"+(i+1));
        }
        c[9] = new Country();
        c[9].setName(""+10);
        c[10] = new Country();
        c[10].setName(""+11);
        c[11] = new Country();
        c[11].setName(""+12);
        //отсортируем их случайно
        myRsort(c, 12);

        //первые четыре идут в группу А, вторые - в Б, третьи - в С
        Group A = new Group(c[0],c[1],c[2],c[3]);
        Group B = new Group(c[4],c[5],c[6],c[7]);
        Group C = new Group (c[8],c[9],c[10],c[11]);
        A.name = "A";
        B.name = "B";
        C.name = "C";

        //всего должно быть 18 матчей
        Match m[] = new Match[18];
        //составим расписание матчей по умолчанию
        for (int i=0; i<3; i++)
            {
                m[0 + 6*i] = new Match(c[4*i + 0],c[4*i + 1]); // team0 vs team1
                m[1 + 6*i] = new Match(c[4*i + 0],c[4*i + 2]); //0 vs 2
                m[2 + 6*i] = new Match(c[4*i + 0],c[4*i + 3]); //0 vs 3
                m[3 + 6*i] = new Match(c[4*i + 1],c[4*i + 2]); //1 vs 2
                m[4 + 6*i] = new Match(c[4*i + 1],c[4*i + 3]); //1 vs 3
                m[5 + 6*i] = new Match(c[4*i + 2],c[4*i + 3]); //2 vs 3
            }
        //случайным образом составим расписание матчей
        myRsort(m,18);

        //теперь матчи будут играться в этом порядке

        //ничьи не бывает одна команда забивает больше голов чем другая

        //либо программа сама случайно генерирует исход игры, либо мы сами вбиваем результат

        //матчи можно также играть не по порядку, и можно было бы юзать метод playGame(string a, string b)
        //он находил бы страны с именами a,b из массива стран и "играл бы матч"
        //можно сделать чтобы метод вызывался лишь один раз, т.е. поставить проверку какую-то
        //или же при повторном вызове может быть переигровка. Зависит от того как нам надо
        //но не будем заморачиваться. Пусть матчи просто играются по порядку и высвечиваются какие-то статы
        //в турнирной таблице


        //тут будут играться матчи
        for(Match mm : m)
        {
            mm.setPlayed();
        }


        A.SortByStats();
        B.SortByStats();
        C.SortByStats();

        A.printStats();
        B.printStats();
        C.printStats();

    }
}
