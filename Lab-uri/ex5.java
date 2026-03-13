class Complex {
 private double re;
 private double im;

 public static int nrCom = 0;

 public Complex(double re, double im){
   nrCom++;
   this.re = re;
   this.im = im;
 }

 public double modul(){
   return Math.sqrt(re*re + im*im);
 }

 public void afisare()
 {
   System.out.println(re + " + " + "i*" + im);
   System.out.println(nrCom);
 }

 public Complex suma(Complex numar){
   double e1 = this.re+numar.re;
   double e2 = this.im+numar.im;
   Complex suma = new Complex(e1,e2);
   return suma;
 }
}

class main{
    public static void main(String[] args)
    {
      Complex nr = new Complex(1,2);
      nr.afisare();
      //System.out.println(nr.modul());
      Complex a = new Complex(2,1);
      a.afisare();
      //Complex suma = a.suma(nr);
      //suma.afisare();
    }
}
