public class Lab10z1 {
    public static void main(String[] args) {
    Trojkat trojkat = new Trojkat();
    Kwadrat kwadrat = new Kwadrat();
    Prostokat prostokat = new Prostokat();
    Trapez trapez = new Trapez();
    trojkat.a = 3;
    trojkat.h = 4;
    kwadrat.a = 7;
    prostokat.a=2;
    prostokat.b=8;
    trapez.a = 4;
    trapez.b = 5;
    trapez.h = 7;
        System.out.println("Pole trojkata wynosi: "+trojkat.poleTrojkata());
        System.out.println("Pole kwadratu wynosi: "+kwadrat.poleKwadratu());
        System.out.println("Pole prostokatu wynosi: "+prostokat.poleProstokata());
        System.out.println("Pole trapezu wynosi: "+trapez.poleTrapezu());
    }
}
interface Obliczenia{
    int poleTrojkata();
    int poleKwadratu();
    int poleProstokata();
    int poleTrapezu();
}
class Adapt implements Obliczenia{
    int a; int b; int h;
    int pTroj;
    int pK;
    int pP; int pTr;

   @Override
    public int poleTrojkata(){
    pTroj = (a*h)/2;
    return pTroj;
   }
   @Override
    public int poleKwadratu(){
    pK = a*a;
    return pK;
   }
   @Override
    public int poleProstokata(){
    pP = a*b;
    return pP;
   }
   @Override
    public int poleTrapezu(){
    pTr = ((a+b)*h)/2;
    return pTr;
   }
}
class Trojkat extends Adapt{
    @Override
    public int poleTrojkata() {
        return super.poleTrojkata();
    }
}
class Kwadrat extends Adapt{
    @Override
    public int poleKwadratu(){
        return super.poleKwadratu();
    }
}
class Prostokat extends Adapt{
    @Override
    public int poleProstokata(){
        return super.poleProstokata();
    }
}
class Trapez extends Adapt{
    @Override
    public int poleTrapezu(){
        return super.poleTrapezu();
    }
}