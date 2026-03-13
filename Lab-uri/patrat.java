class Patrat{
  private int latura;

  public Patrat(){
    this.latura = 10;
  }

  public Patrat(int latura){
    this.latura = latura;
  }

  public String toString(){
    return "Patrat " + latura + " Aria " + latura*latura + "\n";
  }
}

class Main{
  public static void main(String[] args){
    Patrat p1 = new Patrat();
    Patrat p2 = new Patrat(20);
    Patrat p3 = new Patrat(13);
    String s1 = p1.toString();
    String s2 = p2.toString();
    String s3 = p3.toString();
    System.out.print(s1);
    System.out.print(s2);
    System.out.print(s3);
  }
}
