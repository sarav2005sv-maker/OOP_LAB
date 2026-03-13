class Jucator{
  private String nume;
  private int nr;

  public Jucator(String nume, int nr){
    this.nume = nume;
    this.nr = nr;
  }

  public String toString(){
    return nume + " - " + nr + "\n";
  }

  public int getNr(){
    return this.nr;
  }

  public boolean equals(Object o){
    if (o instanceof Jucator){
      if (this.nume.equals(((Jucator) o).nume) && this.nr == (((Jucator) o).nr))
 return true;
    }
    return false;
  }
}

class Echipa{
  private Jucator[] rezerve;
  private Jucator[] titulari;
  private int nrRezerve;
  private int nrTitulari;

  public Echipa(){
    rezerve = new Jucator[10];
    titulari = new Jucator[10];
  }

  public void adaugaRezerva(Jucator r){
    if (nrRezerve < 10){
      rezerve[nrRezerve] = r;
      nrRezerve++;
    }
    else {
      Jucator[] j1 = new Jucator[nrRezerve + 1];
      for (int i = 0; i < nrRezerve; i++){
        j1[i] = rezerve[i];
      }
      j1[nrRezerve] = r;
      rezerve = j1;
      nrRezerve++;
    }
  }

  public void adaugaTitular(Jucator r){
    if (nrTitulari < 10){
      titulari[nrTitulari] = r;
      nrTitulari++;
    }
    else {
      Jucator[] j1 = new Jucator[nrTitulari + 1];
      for (int i = 0; i < nrTitulari; i++){
        j1[i] = titulari[i];
      }
      j1[nrTitulari] = r;
      titulari = j1;
      nrTitulari++;
    }
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < nrTitulari; i++){
      String str2 = "Titulari: " + titulari[i].toString();
      str = str + str2;
    }
    for (int i = 0; i < nrRezerve; i++){
      String str1 = "Rezerve: " + rezerve[i].toString();
      str = str + str1;
    }
    return str;
  }

  public boolean efectueazaSchimbare(Jucator j1, Jucator j2){
    int nr = 0,i,j,ind1 = -1,ind2 = -1;
    for (i = 0; i < nrTitulari; i++){
      if (j1.equals(titulari[i])) {
      ind1 = i;
      nr++;
      break;
     }
    }
    for (j = 0; j < nrRezerve; j++){
      if (j2.equals(rezerve[j])) {
      ind2 = j;
      nr++;
      break;
     }
    }
    if (ind1 == -1 || ind2 == -1) return false;
    Jucator m = titulari[ind1];
    titulari[ind1] = rezerve[ind2];
    rezerve[ind2] = m;
    return true;
  }
}

class Main{
  public static void main(String args[]){
    Jucator j1 = new Jucator("Ion",10);
    Jucator j2 = new Jucator("Marcel",12);
    Jucator j3 = new Jucator("George",23);
    Jucator j4 = new Jucator("Marin",53);
    Echipa e = new Echipa();
    e.adaugaRezerva(j1);
    e.adaugaRezerva(j2);
    e.adaugaTitular(j3);
    e.adaugaTitular(j4);
    System.out.println(e.toString());
    e.efectueazaSchimbare(j3,j1);
    System.out.println(e.toString());
  }
}
