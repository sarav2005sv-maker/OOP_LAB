class Carte{
  private int nrPagini;

  public Carte(int nrPagini){
    if (nrPagini > 0){
      this.nrPagini = nrPagini;
    }
  }

  public boolean equals(Object o){
    if (o instanceof Carte){
      return this.nrPagini == ((Carte)o).nrPagini;
    }
    return false;
  }
}

class Main{
  public static void main(String[] args){
    Carte c1 = new Carte(300);
    Carte c2 = new Carte(350);
    Carte c3 = new Carte(300);
    System.out.println(c1.equals(c2));
    System.out.println(c1.equals(c3));
  }
}
