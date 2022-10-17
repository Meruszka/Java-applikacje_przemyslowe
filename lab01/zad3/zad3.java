package zad3;

public class zad3 {
    public static void main(String[] args){
        System.out.println("Podaj wiek w sekundach: ");
        int sekundy = Integer.parseInt(System.console().readLine());
        for (Planets p : Planets.values()){
            System.out.println("Wiek na planecie " + p + " wynosi " + p.calulateAge(sekundy) + " sekund");
        }
    }
}
