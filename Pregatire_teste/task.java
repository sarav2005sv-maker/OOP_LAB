import java.util.ArrayList;

abstract class Task{
   protected String nume;
   abstract public boolean execute(double secunde);
   public Task(String nume){
      this.nume = nume;
   }
}

class SimpleTask extends Task{
   private double timp;

   public SimpleTask(String nume, double timp){
      super(nume);
      this.timp = timp;
   }

   public boolean execute(double sec){
      if(timp <= 0) return true;
      if(sec >= timp) return true;
      timp = timp - sec;
         return false;
      }

   public String toString(){
      return "Nume: " + nume + ", Timp: " + timp + "\n";
   }
}

class ComposedTask extends Task{
   private ArrayList<SimpleTask> taskuri = new ArrayList<SimpleTask>();

   public ComposedTask(String nume, ArrayList<SimpleTask> array){
      super(nume);
      this.taskuri = array;
   }

   public boolean execute(double sec){
      double n = sec/(taskuri.size());
      for (SimpleTask task : taskuri){
         if (!(task.execute(n))) return false;
      }
      return true;
   }

   public String toString(){
      String rez = "Nume: " + nume + ", Content: \n";
      for (SimpleTask task : taskuri){
         rez = rez + task.toString();
      }
      return rez;
   }
}

class Procesor{
   private ArrayList<Task> list = new ArrayList<Task>();

   public Procesor(ArrayList<Task> list){
      this.list = list;
   }

   public void finishAllTasks(){
      boolean i = false;
      while(!i){
       i = true;
         for(Task task : list){
            boolean j = task.execute(5);
            if (j == false){
               i = false;
               break;
            }
         }
      }
   }

   public String toString(){
      String rez = "Procesor: \n";
      for (Task task : list){
         rez = rez + task.toString();
      }
      return rez;
   }
}

class Main{
   public static void main(String[] args){
      SimpleTask st1 = new SimpleTask("st1", 5);
      SimpleTask st2 = new SimpleTask("st2", 10);
      ArrayList<SimpleTask> st = new ArrayList<SimpleTask>();
      st.add(st1);
      st.add(st2);
      ComposedTask ct = new ComposedTask("ct", st);
      ArrayList<Task> tasks = new ArrayList<Task>();
      tasks.add(ct);
      Procesor p = new Procesor(tasks);
      p.finishAllTasks();
      System.out.println(p.toString());
   }
}
