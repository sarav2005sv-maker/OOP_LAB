class Card{
  private String nr;
  private int sold;

  public Card(String nr, int sold){
    this.nr = nr;
    this.sold = sold;
  }

  public String toString(){
    return nr + " - " + sold + "\n";
    }

  public String getNr(){
    return this.nr;
  }
}

class Portofel{
  private String proprietar;
  private Card[] carduri;
  private int nrCarduri;

  public Portofel(String proprietar){
    this.proprietar = proprietar;
    carduri = new Card[6];
  }

  public boolean AdaugaCard(String nr, int sold){
    if (nrCarduri == 6) return false;
    String s;
    for (int i = 0; i < nrCarduri; i++){
      if (nr.equals((s = (carduri[i].getNr())))) return false;
    }
     carduri[nrCarduri] = new Card(nr,sold);
     nrCarduri++;
     return true;
    }

    public String toString(){
    String str = "";
      for (int i = 0; i < nrCarduri; i++){
       String str1 = proprietar + ": Card " + i + "-> " + carduri[i].toString();
       str = str + str1;
      }
      return str;
    }
}

class Main{
   public static void main(String args[]){
     Portofel p1 = new Portofel("Ion");
     p1.AdaugaCard("A101",2000);
     p1.AdaugaCard("A101",3500);
     Portofel p2 = new Portofel("Maria");
     p2.AdaugaCard("B501",2000);
     p2.AdaugaCard("A802",3500);
     p2.AdaugaCard("B501",2000);
     p2.AdaugaCard("C452",3500);
     p2.AdaugaCard("N591",2000);
     p2.AdaugaCard("K682",3500);
     System.out.println(p1.toString());
     System.out.println(p2.toString());
   }
}
