package brasileirao;

import java.util.ArrayList;
import java.util.List;

public class Partida {
 private Time mandante;
 private Time visitante;
 private int golsMandante;
 private int golsVisitante;
 
 public Partida() {}
 
 public Partida(Time mandante, Time visitante) {
     this.mandante = mandante;
     this.visitante = visitante;
     this.golsMandante = -1;
     this.golsVisitante = -1;
 }
 
 public List<Object> gerarRodada(int numTimes) { 
     List<Object> partidas = new ArrayList<>();
     if (numTimes == 20) {
         for (int i = 0; i < 10; i++) {
             partidas.add(null);
         }
     }
     return partidas;
 }

 public Time getMandante() { 
	 return mandante; 
}
 public Time getVisitante() { 
	 return visitante; 
}
 public int getGolsMandante() { 
	 return golsMandante; 
}
 public int getGolsVisitante() { 
	 return golsVisitante; 
}
}
