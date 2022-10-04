package zad3;

public class zad3 {
    public static float wiekNaZiemi(int sekundy){
        return sekundy / 31557600f;
    }
    public static float wiekNaMerkury(int sekundy){
        return wiekNaZiemi(sekundy) / 0.2408467f;
    }
    public static float wiekNaWenus(int sekundy){
        return wiekNaZiemi(sekundy) / 0.61519726f;
    }
    public static float wiekNaMars(int sekundy){
        return wiekNaZiemi(sekundy) / 1.8808158f;
    }
    public static float wiekNaJowisz(int sekundy){
        return wiekNaZiemi(sekundy) / 11.862615f;
    }
    public static float wiekNaSaturn(int sekundy){
        return wiekNaZiemi(sekundy) / 29.447498f;
    }
    public static float wiekNaUran(int sekundy){
        return wiekNaZiemi(sekundy) / 84.016846f;
    }
    public static float wiekNaNeptun(int sekundy){
        return wiekNaZiemi(sekundy) / 164.79132f;
    }
    public static void main(String[] args){
        System.out.println("Podaj wiek w sekundach: ");
        int sekundy = Integer.parseInt(System.console().readLine());
        System.out.println("Wiek na Ziemi: " + wiekNaZiemi(sekundy));
        System.out.println("Wiek na Merkury: " + wiekNaMerkury(sekundy));
        System.out.println("Wiek na Wenus: " + wiekNaWenus(sekundy));
        System.out.println("Wiek na Mars: " + wiekNaMars(sekundy));
        System.out.println("Wiek na Jowisz: " + wiekNaJowisz(sekundy));
        System.out.println("Wiek na Saturn: " + wiekNaSaturn(sekundy));
        System.out.println("Wiek na Uran: " + wiekNaUran(sekundy));
        System.out.println("Wiek na Neptun: " + wiekNaNeptun(sekundy));
    }
}
