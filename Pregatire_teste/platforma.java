import java.util.ArrayList;

abstract class Utilizator{
   protected String nume;

   public Utilizator(String nume){
      this.nume = nume;
   }
   abstract public double calculeazaVenit(int n);
}

class Subscriber extends Utilizator{
   private int nivel;

   public Subscriber(String nume, int nivel){
      super(nume);
      this.nivel = nivel;
   }

   public double calculeazaVenit(int n){
      return n * 1.5 * nivel;
   }

   public String toString(){
      return nume + " - subscriber - " + nivel + "\n";
   }
}

class Creator extends Utilizator{
   ArrayList<Subscriber> subs = new ArrayList<Subscriber>();

   public Creator(String nume){
      super(nume);
   }

   public void adaugaSubscriber(Subscriber sub){
      subs.add(sub);
   }

   public double calculeazaVenit(int n){
      double rez = 0;
      for(Subscriber s : subs){
         rez = rez + s.calculeazaVenit(n);
      }
      return rez;
   }

   public String toString(){
      String rez = "";
      rez = rez + nume + " - creator:\n";
      for (Subscriber s : subs){
         rez = rez + s.toString();
      }
      return rez;
   }
}

class Platforma{
   private Utilizator[] array = new Utilizator[1000];
   private int size;

   public boolean adaugaUtilizator(Utilizator user){
      if (size < 999){
         array[size] = user;
         size++;
         return true;
      }
      else return false;
   }

   public Utilizator determinaVIP(int n){
   Utilizator max;
      if (size == 0) return null;
      else{
        max = array[0];
         for (int i = 1; i < size; i++){
            if (array[i].calculeazaVenit(n) > max.calculeazaVenit(n)){
               max = array[i];
            }
         }
      }
      return max;
   }
}

class Main{
   public static void main(String args[]){
      Subscriber s1 = new Subscriber("Maria",5);
      Subscriber s2 = new Subscriber("Ion",2);
      Subscriber s3 = new Subscriber("Mara",6);
      Subscriber s4 = new Subscriber("Ionela",9);
      Subscriber s5 = new Subscriber("Luca",7);
      Creator c1 = new Creator("C1");
      c1.adaugaSubscriber(s1);
      c1.adaugaSubscriber(s2);
      Creator c2 = new Creator("C2");
      c2.adaugaSubscriber(s3);
      c2.adaugaSubscriber(s4);
      Platforma p = new Platforma();
      p.adaugaUtilizator(c1);
      p.adaugaUtilizator(c2);
      p.adaugaUtilizator(s5);
      System.out.println((p.determinaVIP(30)).toString());
   }
}
