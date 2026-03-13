abstract class Angajat{
    protected String nume;

    public Angajat(String nume){
       this.nume = nume;
    }
    abstract public double calculSalar();
    public boolean equals(Object o){
       if (o instanceof Angajat){
          return (this.nume).equals(((Angajat)o).nume);
       }
       else{
          return false;
       }
    }
}

class AngajatCuSalarFix extends Angajat{
   private double salar_fix;

   public AngajatCuSalarFix(String nume, double salar_fix){
      super(nume);
      this.salar_fix = salar_fix;
   }

   public double calculSalar(){
      return this.salar_fix;
   }

   public void schimbaSalarFix(double salar_fix_nou){
      this.salar_fix = salar_fix_nou;
   }
}

class AngajatCuOra extends Angajat{
   private double salar_ora;
   private double[] ore_lucrate;
   private double suma; //contorizeaza cate ore lucrate s-au introdus in tablou
   private int count;

   public AngajatCuOra(String nume, double salar_ora){
      super(nume);
      this.salar_ora = salar_ora;
      ore_lucrate = new double[31];
   }

   public void schimbaSalarPeOra(double salar_ora){
      this.salar_ora = salar_ora;
   }

   public void adaugaOre(double nr_ore){
         if (nr_ore <= 31 - suma){
            ore_lucrate[count] = nr_ore;
            count++;
            suma = suma + nr_ore;
         }
      }

   public double calculSalar(){
      return suma * salar_ora;
   }
}

class Firma{
   private Angajat[] angajati;
   private int count;

   public Firma(){
      angajati = new Angajat[1024];
   }

   public int angajeaza(Angajat a){
      if (count > 1024) return -1;
      for (int i = 0; i < count; i++){
         if (a.equals(angajati[i])) {
         System.out.println("Incercare adaugare angajat existent!");
         return -2;
         }
      }
      angajati[count] = a;
      count++;
      return 0;
   }

   public double salarMediu(){
      double suma = 0;
      if (count == 0) return 0;
      for (int i = 0; i < count; i++){
         suma = suma + (angajati[i]).calculSalar();
      }
      return suma/count;
   }
}

class Main{
   public static void main(String args[]){
      AngajatCuSalarFix af1 = new AngajatCuSalarFix("Ana",1000);
      AngajatCuSalarFix af2 = new AngajatCuSalarFix("Maria",2000);
      AngajatCuOra ao1 = new AngajatCuOra("Carla",300);
      AngajatCuOra ao2 = new AngajatCuOra("Daniela",400);
      Firma f = new Firma();
      ao1.adaugaOre(2);//600 - salar total
      ao2.adaugaOre(2);//800 - salar total
      ao2.adaugaOre(1);//800 + 400 = 1200
      f.angajeaza(af1);
      f.angajeaza(af2);
      f.angajeaza(ao1);
      f.angajeaza(ao2);
      //f.angajeaza(ao2); - nu il adauga
      System.out.println("Salar mediu = " + f.salarMediu());
      ao1.schimbaSalarPeOra(500);
      System.out.println("Salar mediu = " + f.salarMediu());
   }
}


















