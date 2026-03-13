class DestinatarDuplicat extends Exception{}

abstract class Destinatar{
   protected String nume;

   public Destinatar(String nume){
      this.nume = nume;
   }
   public String getNume(){
      return this.nume;
   }
   abstract public void receptioneaza(Utilizator u, String mesaj);

   public boolean equals(Object o){
      if (o instanceof Destinatar){
          return (((Destinatar)o).nume).equals(this.nume);
      }
      return false;
   }
}

class Utilizator extends Destinatar{
   private String jurnal;

   public Utilizator(String nume){
      super(nume);
      this.jurnal = "";
   }

   public String getNume(){
      return this.nume;
   }

   public void receptioneaza(Utilizator u, String mesaj){
      this.jurnal = this.jurnal + "Primit de la " + u.getNume() + " mesajul: " + mesaj + "\n";
   }

   public void trimite(Destinatar d, String mesaj){
      this.jurnal = this.jurnal + "Trimis catre " + d.getNume() + " mesajul: " + mesaj + "\n";
      d.receptioneaza(this,mesaj);
   }

   public String toString(){
      return this.nume + ": \n" + jurnal;
   }
}

class Grup extends Destinatar{
   private Destinatar[] array;
   private int i;

   public Grup(String nume){
      super(nume);
      array = new Destinatar[50];
   }

   public void inscrie(Destinatar d) throws DestinatarDuplicat{
      if (i < 49){
      boolean exists = false;
          for (int j = 0; j < i; j++){
             if (d.equals(array[j])){
                exists = true;
                break;
             }
          }
          if (exists == false){
             array[i] = d;
             i++;
          }
          else{
             throw new DestinatarDuplicat();
          }
      }
      else{
         System.out.println("Nu mai e loc!");
      }
   }

   public void receptioneaza(Utilizator u, String mesaj){
      for (int j = 0; j < i; j++){
         if (!(u.equals(array[j]))){
            array[j].receptioneaza(u,mesaj);
         }
      }
   }
}

class Main{
   public static void main(String[] args){
     Utilizator u1 = new Utilizator("Dan");
     Utilizator u2 = new Utilizator("Marius");
     Utilizator u3 = new Utilizator("Alex");
     Grup g = new Grup("Carnivorii");

     try{
     g.inscrie(u1);
     g.inscrie(u2);
     g.inscrie(u3);
     g.inscrie(u3);
     }
     catch(DestinatarDuplicat e){
         System.out.println("Destinatarul deja exista!");
     }

     u3.trimite(g,"Am deschis magazinul!");
     u2.trimite(g,"Vin acuma!");

     System.out.println(u1.toString());
     System.out.println(u2.toString());
     System.out.println(u3.toString());
   }
}
