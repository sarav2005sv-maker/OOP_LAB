class Fisier{
  private String nume;
  private String continut;
  private int id;
  private Fisier prevVer;

  private static int i = 1;
  private static int nrCat = 0;

  public Fisier(String nume,String continut){
    this.nume = nume;
    this.continut = continut;
    this.id = i;
    i = i + 1;
  }

  public void salveazaVersiune(){
    String s = this.nume + "bak";
    Fisier m = new Fisier(s,this.continut);
    m.prevVer = this.prevVer;
    this.prevVer = m;
  }

  public void concateneaza(Fisier f){
    salveazaVersiune();
    this.continut = this.continut + f.continut;
    nrCat = nrCat + 1;
  }

  public String toString(){
   if (prevVer == null)
    return this.id + "." + " " + this.nume + " " + this.continut;
    else
    return this.id + "." + " " + this.nume + " " + this.continut + " " + this.prevVer;
  }

}

class Main{
  public static void main(String[] args){
    Fisier f = new Fisier("file1","Hallo");
    f.salveazaVersiune();
    Fisier m = new Fisier("file2","Hola");
    m.salveazaVersiune();
    f.concateneaza(m);
    System.out.println(f);
    System.out.println(m);
  }
}
