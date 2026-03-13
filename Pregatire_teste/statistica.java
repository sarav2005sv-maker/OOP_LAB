import java.util.ArrayList;


abstract class Statistica{

   protected ArrayList<String> cautate = new ArrayList<String>();
   protected String jurnal;

   public Statistica(){
      this.jurnal = "";
   }
   abstract public void calculeaza(ArrayList<String> secventa);
   abstract public String toString();
}

class StatisticaNumarAparitii extends Statistica{

   public StatisticaNumarAparitii(ArrayList<String> cautate){
      super();
      this.cautate = cautate;
   }

   public void calculeaza(ArrayList<String> cautam){
   int i = 0;
      for (String str : cautam){
         if (cautate.contains(str)) i++;
      }
      this.jurnal = this.jurnal + "In secventa " + cautam + " apar " + i + " siruri din secventa: " + cautate + "\n";
   }

   public String toString(){
      return jurnal;
   }
}

class StatisticaNumereNonReale extends Statistica{

   public StatisticaNumereNonReale(){
      super();
   }

   public void calculeaza(ArrayList<String> cautam){
      int i = 0;
      for (String str : cautam){
         try{
            java.lang.Double.parseDouble(str);
         }
         catch(RuntimeException e){
            i++;
         }
      }
      this.jurnal = this.jurnal + "In secventa " + cautam + " avem " + i + " siruri ce nu sunt numere reale " + "\n";
   }

   public String toString(){
      return this.jurnal;
   }
}

class Executor{
   private ArrayList<Statistica> s = new ArrayList<Statistica>();

   public Executor(ArrayList<Statistica> s){
      this.s = s;
   }

   public void executa(ArrayList<String> str){
      for (Statistica st : s){
         st.calculeaza(str);
         System.out.println(st.toString());
      }
   }
}

class Main{
   public static void main(String args[]){
      ArrayList<String> cautate = new ArrayList<String>();
      cautate.add("Ana");
      cautate.add("are");
      cautate.add("mere");
      ArrayList<String> cautam = new ArrayList<String>();
      cautam.add("Ana");
      cautam.add("are");
      cautam.add("pere");
      ArrayList<String> cautam1 = new ArrayList<String>();
      cautam1.add("123");
      cautam1.add("aaa");
      cautam1.add("44");
      StatisticaNumarAparitii s = new StatisticaNumarAparitii(cautate);
      StatisticaNumereNonReale s1 = new StatisticaNumereNonReale();
      ArrayList<Statistica> stat = new ArrayList<Statistica>();
      stat.add(s);
      stat.add(s1);
      Executor e = new Executor(stat);
      e.executa(cautam1);
   }
}
