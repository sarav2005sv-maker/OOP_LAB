class Angajat{
  private String nume;
  private int salariu;

  public Angajat(String nume, int salariu){
    this.nume = nume;
    this.salariu = salariu;
  }

  public String toString(){
    return nume + " - " + salariu + "\n";
  }

  public int getSalariu(){
    return salariu;
  }
}

class Firma{
  private String numeFirma;
  private int buget;
  private Angajat[] angajati;
  private int nrAngajati;

  public Firma(String numeFirma, int buget){
    this.numeFirma = numeFirma;
    this.buget = buget;
    this.angajati = new Angajat[30];
  }

  public boolean adaugaAngajat(Angajat a){
    if (nrAngajati == 30) return false;
    for(int i = 0; i < nrAngajati; i++){
      if (a == angajati[i]) return false;
    }
    angajati[nrAngajati] = a;
    nrAngajati++;
    return true;
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < nrAngajati; i++){
      String str1 = numeFirma + ": " + "Angajat" + i + "-> " + angajati[i].toString();
      str = str + str1;
      }
      return str;
  }

  public int platesteSalarii(){
  int salarii = 0;
    for (int i = 0; i < nrAngajati; i++){
      salarii = salarii + angajati[i].getSalariu();
    }
    return buget - salarii;
  }
}

class Main{
  public static void main(String args[]){
    Firma f = new Firma("Nokia",20000);
    Angajat a1 = new Angajat("Ion",5000);
    Angajat a2 = new Angajat("Maria",5000);
    Angajat a3 = new Angajat("Marcela",13000);
    f.adaugaAngajat(a1);
    f.adaugaAngajat(a2);
    f.adaugaAngajat(a3);
    System.out.println(f.toString());
    int n = f.platesteSalarii();
    System.out.println(n);
  }
}




