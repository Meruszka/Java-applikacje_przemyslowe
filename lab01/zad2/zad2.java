package zad2;

public class zad2 {
    public static int power(int a, int b){
        int result = 1;
        for(int i = 0; i < b; i++){
            result *= a;
        }
        return result;
    }
    public static boolean isAmstrong(int number){
        int sum = 0;
        int digits = 0;
        int temp = number;
        while(temp > 0){
            temp /= 10;
            digits++;
        }
        temp = number;
        while(temp > 0){
            sum += power(temp % 10, digits);
            temp /= 10;
        }
        return sum == number;
    }
    public static void main(String[] args){
        while(true){
            System.out.println("Podaj liczbę: ");
            int number = Integer.parseInt(System.console().readLine());
            if(isAmstrong(number)){
                System.out.println("true");
                break;
            }else{
                System.out.println("false");
            }
        }
    }
}
