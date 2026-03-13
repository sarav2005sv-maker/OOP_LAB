class Figura{
  private int arie;

  public Figura(int arie){
    this.arie = arie;
  }

  public String toString(){
    return " - Arie: " + arie + "\n";
  }

  public int getArie(){
    return arie;
  }
}

class Desen{
  private String titlu;
  private Figura[] figuri;
  private int nrFiguri;

  public Desen(String titlu){
    this.titlu = titlu;
    figuri = new Figura[1024];
  }

  public boolean adaugaFigura(Figura fig){
    for (int i = 0; i < nrFiguri; i++){
      if (fig == figuri[i]) return false;
      if (nrFiguri == 1024) return false;
    }
    figuri[nrFiguri] = fig;
    nrFiguri++;
    return true;
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < nrFiguri; i++){
      String str1 = titlu + ": " + "Figura" + i + figuri[i].toString();
      str = str + str1;
    }
    return str;
  }

  public int medieArie(){
    if (nrFiguri == 0) return 0;
    int medie = 0;
    for (int i = 0; i < nrFiguri; i++){
      medie = medie + figuri[i].getArie();
    }
    return medie/nrFiguri;
  }
}

class Main{
  public static void main(String args[]){
    Figura f1 = new Figura(10);
    Figura f2 = new Figura(20);
    Figura f3 = new Figura(30);
    Desen d = new Desen("Peisaj");
    d.adaugaFigura(f1);
    d.adaugaFigura(f2);
    d.adaugaFigura(f3);
    d.adaugaFigura(f2);
    System.out.println(d.toString());
    System.out.println(d.medieArie());
  }
}
