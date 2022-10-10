package zad4;

public class zad4 {
    public static String drawTriangle(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j > 0; j--){
                sb.append("x");
            }
            sb.append("\n");
        }
        for(int i = n; i > 0; i--){
            for(int j = i; j > 0; j--){
                sb.append("x");
            }
            sb.append("\n");
        }

        for(int i=0; i<n; i++){
            for(int k=i; k>0; k--){
                sb.append(" ");
            }
            for(int j=n-i; j>0; j--){
                sb.append("x");
            }
            sb.append("\n");
        }
        for(int i=n; i>0; i--){
            for(int k=i-1; k>0; k--){
                sb.append(" ");
            }
            for(int j=n-i+1; j>0; j--){
                sb.append("x");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println("Podaj liczbę: ");
        int n = Integer.parseInt(System.console().readLine());
        System.out.println(drawTriangle(n));
        
    }
}
