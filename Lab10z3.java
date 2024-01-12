public class Lab10z3{
    public static void main(String[] args) {
    Ksiazka ksiazka = new Ksiazka(1);
    Czasopismo czasopismo = new Czasopismo(2);
    Wolumin[] tabObj = new Wolumin[2];
    tabObj[0] = ksiazka;
    tabObj[1] = czasopismo;
    if(tabObj[0] instanceof Ksiazka){
        System.out.println("tabObj[0] jest instancja klasy Ksiazka");
    }
    if(tabObj[1] instanceof Czasopismo){
            System.out.println("tabObj[1] jest instancja klasy Czasopismo");
        }
    }
}
abstract class Wolumin{
    protected int id;
    Wolumin(int id){
        this.id = id;
    }
}
class Ksiazka extends Wolumin{
    Ksiazka(int id){
        super(id);
    }
    String tytul;
    String autor;
}
class Czasopismo extends Wolumin{
    Czasopismo(int id){
        super(id);
    }
    String tytul;
    int numer_wydania;
}