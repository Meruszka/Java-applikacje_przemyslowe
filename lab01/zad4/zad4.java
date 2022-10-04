package zad4;

public class zad4 {
    public static void main(String[] args){
        System.out.println("Podaj liczbę: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i = 0; i < n; i++){
            for(int j = i+1; j > 0; j--){
                System.out.print("x");
            }
            System.out.println();
        }
        for(int i = n; i > 0; i--){
            for(int j = i; j > 0; j--){
                System.out.print("x");
            }
            System.out.println();
        }

        for(int i=0; i<n; i++){
            for(int k=i; k>0; k--){
                System.out.print(" ");
            }
            for(int j=n-i; j>0; j--){
                System.out.print("x");
            }
            System.out.println();
        }
        for(int i=n; i>0; i--){
            for(int k=i-1; k>0; k--){
                System.out.print(" ");
            }
            for(int j=n-i+1; j>0; j--){
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
