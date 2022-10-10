package zad3;

public class zad3 {
    public enum PLANET{
        EARTH(1),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132),
        VENUS(0.90718474),
        MERCURY(0.37796447);

        private final double orbitalPeriod;
        
        private PLANET(double orbitalPeriod){
            this.orbitalPeriod = orbitalPeriod;
        }
    
        public final double calulateAge(int age){
            return age * this.orbitalPeriod;
        };
    
    
    }
    public static void main(String[] args){
        System.out.println("Podaj wiek w sekundach: ");
        int sekundy = Integer.parseInt(System.console().readLine());
        for (PLANET p : PLANET.values()){
            System.out.println("Wiek na planecie " + p + " wynosi " + p.calulateAge(sekundy) + " sekund");
        }
    }
}
