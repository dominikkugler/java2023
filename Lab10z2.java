public class Lab10z2 {
    public static void main(String[] args) {
    Bankier bankier = new Bankier("Michał") {
      @Override
        double licz(double num1,double num2){
          return num1+num2;
      }
    };
    PodstepnyBankier podBankier = new PodstepnyBankier("Marek");
    System.out.println("Bankier "+bankier.imie+" = "+bankier.licz(10,20));
    System.out.println("Podstepny Bankier "+podBankier.imie+" = "+podBankier.licz(10,20));
    }
}
abstract class Bankier{
    String imie;
    Bankier(String imie){
        this.imie = imie;
    }
    abstract double licz(double num1, double num2);

}
class UczciwyBankier extends Bankier{
    UczciwyBankier(String imie) {
        super(imie);
    }

    @Override
    double licz(double num1, double num2) {
        return num1+num2;
    }
}
class PodstepnyBankier extends Bankier{
    PodstepnyBankier(String imie){
        super(imie);
    }
    @Override
    double licz(double num1,double num2){
        double zmniejsz = (num1+num2) * 0.8;
        return zmniejsz;
    }
}
