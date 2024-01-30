public class Lab10z5{
    public static void main(String[] args) {
    Uczen uczen = new Uczen();
    Student student = new Student(4);
        System.out.println(uczen.toString("Kugler",student.srednia(4,3)));
        System.out.println(student.toString("Bednarek",student.sredniaWazona(4,3,2)));
    }
}
class Uczen{
    protected String nazwisko;
    protected int ocena1;
    protected int ocena2;
    public Uczen(){}
    public double srednia(int ocena1,int ocena2){
       this.ocena1 = ocena1;
       this.ocena2 = ocena2;
       double srednia = ((double)ocena1+(double)ocena2)/2;
       return srednia;
    }
    public String toString(String nazwisko, double srednia){
        this.nazwisko = nazwisko;
        return "Nazwisko: "+nazwisko+" Srednia: "+srednia;
    }
}
class Student extends Uczen{
    protected int waga1;
    public Student(int waga1){
        super();
        this.waga1 = waga1;
    }
    double sredniaWazona(int ocena1, int ocena2, int waga1){
    return ((double)ocena1 + ((double)waga1 * (double)ocena2))/(1 + (double)waga1);
    }
}