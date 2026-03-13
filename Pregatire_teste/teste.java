import java.util.ArrayList;

interface ITest{
   abstract public int getNumarTeste();
}

abstract class Suite implements ITest{}

class WrongQualityIndicatorException extends Exception{}
class WrongComponentComplexityIndicatorException extends Exception{}

abstract class Test implements ITest{
   protected String nume;
   protected int calitate;

   abstract public String toString();
   public Test(String nume, int calitate) throws WrongQualityIndicatorException{
      if (calitate < 1 || calitate > 10) throw new WrongQualityIndicatorException();
      this.calitate = calitate;
      this.nume = nume;
   }
}

class IntegrationTest extends Test{

   public IntegrationTest(String nume, int calitate) throws WrongQualityIndicatorException{
      super(nume,calitate);
   }

    public int getNumarTeste(){
       return 1;
    }

    public String toString(){
       return "IntegrationTest(name = " + nume + ", quality indicator = " + calitate + ")\n";
    }
}

class ComponentTest extends Test{
   private int complexitate;

   public ComponentTest(String nume, int calitate, int complexitate) throws WrongQualityIndicatorException, WrongComponentComplexityIndicatorException{
      super(nume,calitate);
      if (complexitate <= 0) throw new WrongComponentComplexityIndicatorException();
      this.complexitate = complexitate;
   }

   public int getNumarTeste(){
      return 1;
   }

   public String toString(){
       return "ComponentTest(name = " + nume + ", quality indicator = " + calitate + " complexitate = " + complexitate + ")\n";
    }
}

class TestSuite extends Suite{
   private ArrayList<ITest> teste = new ArrayList<ITest>();

   public TestSuite(ArrayList<ITest> teste){
      this.teste = teste;
   }

   public int getNumarTeste(){
      int rezultat = 0;
      for (ITest test : teste){
         rezultat = rezultat + test.getNumarTeste();
      }
      return rezultat;
   }

   public boolean addNewIntegrationTest(String nume, int calitate){
      try{
         IntegrationTest t = new IntegrationTest(nume,calitate);
         teste.add(t);
         return true;
      }
      catch (WrongQualityIndicatorException e){
         return false;
      }
   }

   public boolean addNewComponentTest(String nume, int calitate, int complexitate) throws WrongComponentComplexityIndicatorException{
      try{
         ComponentTest t = new ComponentTest(nume,calitate,complexitate);
         teste.add(t);
         return true;
      }
      catch(WrongQualityIndicatorException e){
         return false;
      }
      catch(WrongComponentComplexityIndicatorException e){
         throw new WrongComponentComplexityIndicatorException();
      }
   }

   public String toString(){
      String rez = "TestSuite \n";
      for (ITest t : teste){
         rez = rez + t.toString();
      }
      return rez;
   }
}

class Main{
   public static void main(String args[]){
      TestSuite ts = new TestSuite(new ArrayList<ITest>());
      try{
        ts.addNewIntegrationTest("IT1",9);
        ts.addNewIntegrationTest("IT2",6);
        ts.addNewComponentTest("CT1",7,100);
        ts.addNewComponentTest("CT2",7,90);

      }
      catch(WrongComponentComplexityIndicatorException e){
         System.out.println("A aparut o exceptie!");
      }
      System.out.println(ts.toString());
   }
}


