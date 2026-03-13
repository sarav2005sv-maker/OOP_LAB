class Remorca{
  private int nr_cutii;
  private String nrInmatriculare;
  private static Remorca prevRem;

  public Remorca(int nr_cutii, String nrInmatriculare){
    this.nr_cutii = nr_cutii;
    this.nrInmatriculare = nrInmatriculare;
    prevRem = this;
  }

  public Remorca(String nrInmatriculare){
    if (prevRem == null){
      this.nr_cutii = 10;
      this.nrInmatriculare = nrInmatriculare;
    }
    else {
      this.nr_cutii = 1 + prevRem.nr_cutii;
      this.nrInmatriculare = nrInmatriculare;
    }
    prevRem = this;
  }

  public String getNrInmatriculare(){
    return this.nrInmatriculare;
  }

  public int getCutii(){
    return this.nr_cutii;
  }

  public void afiseaza(){
    System.out.println("Numar cutii remorca: " + nr_cutii + "\n" + "NrInmatriculare: " + nrInmatriculare);
  }

  public String toString(){
    return "R(" + nrInmatriculare + "," + nr_cutii + ")";
  }
}

class Tir{
  private Remorca r[] = new Remorca[5];
  private int nrRemorci = 0;

  public boolean adaugaRemorca(int nr_cutii,String nrInmatriculare){
    if(nrRemorci < 5){
      r[nrRemorci] = new Remorca(nr_cutii,nrInmatriculare);
      nrRemorci = nrRemorci + 1;
      return true;
    }
    else{
      return false;
    }
  }

  public boolean adaugaRemorca(Remorca rem){
    if (nrRemorci < 5){
      r[nrRemorci] = rem;
      nrRemorci = nrRemorci + 1;
      return true;
    }
    else{
      return false;
    }
  }

  public Remorca stergeRemorca(String nrInmatriculare){
    for (int i = 0; i < nrRemorci; i++){
      String aux = r[i].getNrInmatriculare();
      if(nrInmatriculare.equals(aux) == true){
        Remorca remStearsa = r[i];
        if (i == nrRemorci - 1){
          r[i] = null;
          nrRemorci--;
        }
        else {
        for (int j = i; j < nrRemorci; j++){
          r[j] = r[j + 1];
        }
        nrRemorci--;
        return remStearsa;
        }
      }
    }
    return null;
  }

  public boolean equals(Object o){
    int nr1 = 0;
    int nr2 = 0;
    if(o instanceof Tir){
    for (int i = 0 ; i < ((Tir)o).nrRemorci; i++)
    {
      int m = (((Tir)o).r[i]).getCutii();
      nr1 = nr1 + m;
    }
    for (int k = 0; k < this.nrRemorci; k++){
      int n = (this.r[k]).getCutii();
      nr2 = nr2 + n;
    }
  }
  return nr1 == nr2;
  }

  public void afiseaza(){
    System.out.println("NrRemorci: " + nrRemorci);
    for(int i = 0; i < nrRemorci; i++){
      r[i].afiseaza();
    }
  }

  public String toString(){
    String s = "T -> ";
    for(int i = 0; i < nrRemorci; i++){
      String s1 = r[i].toString();
      s = s + s1;
    }
    return s;
    }
}

class Main{
  public static void main(String args[]){
    Tir t1 = new Tir();
    t1.adaugaRemorca(10,"AR2356");
    t1.adaugaRemorca(10,"CT3856");
    Remorca r = new Remorca(7,"TM5734");
    t1.adaugaRemorca(r);
    //t1.stergeRemorca("AR2356");
    //t1.stergeRemorca("TM5734");
    t1.afiseaza();
    System.out.println("");
    Tir t2 = new Tir();
    t2.adaugaRemorca(20,"TM4579");
    t2.afiseaza();
    System.out.println(t1.equals(t2));
    System.out.println("");
    String str = t1.toString();
    System.out.println(str);
  }
}
