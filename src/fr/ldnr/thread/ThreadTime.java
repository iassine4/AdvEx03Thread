package fr.ldnr.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTime {

  private static class MonRunnable implements Runnable {

    private int id;
    //private long delai;
    private int repeatCount;

    public MonRunnable(int id, int repeatCount) {
      this.id = id;
      //this.delai = delai;
      this.repeatCount = repeatCount;
    }

    @Override
    public void run() {

      // On construit une seule fois ce que le thread doit afficher : ex "3---"
      String token = buildToken();
      StringBuilder line = new StringBuilder();

      // On répète l'affichage un nombre fini de fois pour pouvoir tester facilement
      for (int i = 0; i < repeatCount; i++) {
    	  line.append(token).append(" ");
      }
      System.out.println(line.toString());
    }

    private String buildToken() {
      StringBuilder sb = new StringBuilder();
      sb.append(id);                // ex: "3"
      for (int i = 0; i < id; i++)  // ajoute id tirets => 3 fois '-'
        sb.append("-");
      return sb.toString();         // ex: "3---"
    }
  }
  
  public static void main(String[] args) {

	    DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    System.out.println(df.format(new Date()));

	    int repeatCount = 5; // nombre d'affichages par thread (augmente si tu veux une sortie plus longue)

	    // On lance 5 threads : 1- 2-- 3--- 4---- 5-----
	    for (int id = 1; id <= 5; id++) {

	      // Plus id est petit, plus le délai est court => 1- s'affiche très souvent
	      //long delai = 120L * id;

	      Thread thread = new Thread(new MonRunnable(id, repeatCount));
	      thread.start();
	    }
	  }
}
