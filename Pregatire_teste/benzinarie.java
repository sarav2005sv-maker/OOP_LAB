class Masina{
  private String nrInmatriculare;
  private int litri;

  public Masina(String nr, int l){
    this.nrInmatriculare = nr;
    this.litri = l;
  }

  public int getLitri(){
    return litri;
  }

  public String toString(){
    return nrInmatriculare + " - " + litri + "\n";
  }
}

class Benzinarie{
  private int cantitate;
  private Masina[] masini;
  private int nrMasini;

  public Benzinarie(int cantitate){
    this.cantitate = cantitate;
    masini = new Masina[10];
  }

  public boolean alimenteazaMasina(Masina m){
    if (m.getLitri() <= cantitate){
      cantitate = cantitate - m.getLitri();
      return true;
    }
    else {
      if (nrMasini == 10) return false;
      else {
        masini[nrMasini] = m;
        nrMasini++;
      }
    }
    return true;
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < nrMasini; i++){
      String str1 = "Masina " + i + ":" + masini[i].toString();
      str = str + str1;
    }
    return str;
  }

  public void alimenteazaBenzinarie(int cantitate){
    this.cantitate = this.cantitate + cantitate;
    if (nrMasini != 0){
      for (int i = 0; i < nrMasini; i++){
        if (masini[i].getLitri() <= this.cantitate){
          this.cantitate = this.cantitate - masini[i].getLitri();
          masini[i + 1] = masini[i];
          nrMasini--;
          continue;
        }
        break;
      }
    }
  }
}

class Main{
  public static void main(String[] args){
    Masina m1 = new Masina("AR10NLW",5);
    Masina m2 = new Masina("TM09HSZ",10);
    Masina m3 = new Masina("MH07KSZ",15);
    Benzinarie b = new Benzinarie(10);
    b.alimenteazaMasina(m1);
    b.alimenteazaMasina(m2);
    b.alimenteazaMasina(m3);
    System.out.println(b.toString());
    b.alimenteazaBenzinarie(15);
    System.out.println(b.toString());
  }
}
