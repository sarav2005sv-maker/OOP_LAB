import java.io.*;
import java.util.Random;

class Telefon{
  private String nume;
  private String[] apelanti;
  private int nrProprietari;

  public Telefon(String nume){
    this.nume = nume;
    this.apelanti = new String[100];
  }

  public boolean apeleaza(Telefon t){
    if (t.nrProprietari < 100){
      t.apelanti[t.nrProprietari] = this.nume;
      (t.nrProprietari)++;
      return true;
    }
    return false;
  }

  public Integer numarDeApeluri(String nume){
  int j = 0;
    for(int i = 0; i < nrProprietari; i++){
      if (nume.equals(this.apelanti[i])){
        j++;
      }
      continue;
    }
    return j;
  }

  public String toString(){
    String s1 = "";
    for (int m = 0; m < nrProprietari; m++){
      s1 = s1 + " " + apelanti[m];
    }
    return nume + " :" + s1;
  }
}

class Main{
   public static void main(String[] args){
     int n,a;
     Telefon[] tel;
     try{
     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
     n = Integer.parseInt(bfr.readLine());
     tel = new Telefon[n];
     for (int i = 0; i < n; i++){
       String st = bfr.readLine();
       tel[i] = new Telefon(st);
     }
     a = Integer.parseInt(bfr.readLine());
     Random b = new Random();
     for(int j = 0; j < a; j++){
       int m1 = b.nextInt(n);
       int m2 = b.nextInt(n);
       if (m1 != m2){
       tel[m1].apeleaza(tel[m2]);
       }
     }
     for (int g = 0; g < n; g++){
       System.out.println(tel[g].toString());
     }
     }catch (IOException e){
       System.out.println("Eroare");
       System.exit(1);
     }
   }
}
