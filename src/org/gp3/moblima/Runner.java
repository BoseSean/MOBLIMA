package org.gp3.moblima;

import org.gp3.moblima.view.MainMenu;
import org.gp3.moblima.view.MenuLoop;
//
//import static org.gp3.moblima.model.Constant.TableName.MOVIE;

public class Runner {
//    public static void main(String[] args) {
//        Manager man = Manager.getInstance();
//        Movie mov = new Movie();
//        mov.setTitle("HI moon");
//        man.add(MOVIE, mov);
//        Scanner sc = new Scanner(System.in);
//        final String s = sc.nextLine();
//
//        ArrayList<Movie> mov2 = man.getEntries(MOVIE, (Movie movie) -> (movie.getTitle().equals(s)) );
//
//        System.out.println(mov2.get(0).getTitle());
//        final String b = sc.nextLine();
//        man.delete(MOVIE, (Predicate<Movie>) (Movie e) -> (e.getTitle().equals(b)));
//
//    //    }
    public static void main(String[] args) {
        MenuLoop loop = new MenuLoop(new MainMenu(null));
        loop.start();

    }
}
