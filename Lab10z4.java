public class Lab10z4{
    public static void main(String[] args) {
    Szescian szescian = new Szescian(2);
   int objetosc = szescian.objetosc(2,3,4);
        System.out.println(szescian.toString(objetosc));
    }
}
class Pudelko{
    protected int dlugosc;
    protected int szerokosc;
    protected int wysokosc;
    public Pudelko(int dlugosc,int szerokosc,int wysokosc){
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }
    public int objetosc(int dlugosc,int szerokosc,int wysokosc){
        int obj = this.dlugosc * this.szerokosc * this.wysokosc;
        return obj;
    }
    public String toString(int objetosc){
        return "Dlugosc: " + dlugosc +" Szerokosc: "+szerokosc+" Wysokosc: "+wysokosc+" Objetosc: "+objetosc;
    }
}
class Szescian extends Pudelko{
    Szescian(int wartosc){
        super(wartosc,wartosc,wartosc);
    }
}