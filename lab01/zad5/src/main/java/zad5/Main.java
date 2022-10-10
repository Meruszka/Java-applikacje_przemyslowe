package zad5;

public class Main {
    public static void main(String[] args){
        Author a = new Author("Jan", "mail@qp.pl", Gender.Male);
        Book b = new Book("1984", a, 190d);
        System.out.println(b.toString());
    }
}
