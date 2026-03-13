class Sertar{
    private int l;
    private int L;
    private int H;

    public Sertar(int l, int L, int H){
        if (l > 0 && L > 0 && H > 0)
        {
          this.l = l;
          this.L = L;
          this.H = H;
        }
    }
    public void tipareste(){
      System.out.println("Sertar " + l + " " + L + " "+ H);
    }
}
class Birou{
    private int l;
    private int L;
    private int H;
    private Sertar s1;
    private Sertar s2;

    public Birou(int l,int L,int H,Sertar s1, Sertar s2){
      if (l > 0 && L > 0 && H > 0)
        {
          this.l = l;
          this.L = L;
          this.H = H;
          this.s1 = s1;
          this.s2 = s2;
        }
    }
    public void tipareste(){
      System.out.println("Birou " + l + " " + L + " "+ H);
      s1.tipareste();
      s2.tipareste();
    }
}
class Main{
  public static void main(String[] args)
  {
    Sertar ser1 = new Sertar(2,3,4);
    Sertar ser2 = new Sertar(3,4,5);
    Birou bir = new Birou(10,20,15,ser1,ser2);
    bir.tipareste();
  }
}
