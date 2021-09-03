package poo;
import robocode.*;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.HitByBulletEvent;
import java.awt.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Ultron_O_Comedor_de_Máquinas - a robot by (your name here)
 */
public class Ultron_O_Comedor_de_Máquinas extends AdvancedRobot{
//	int turnDirection = 1;
	/**
	 * run: Ultron_O_Comedor_de_Máquinas's default behavior
	 */
	public void run() {
		//Definem as cores do robô	
      	setBodyColor(Color.black);   //corpo
	  	setGunColor(Color.black);	//arma
	  	setRadarColor(Color.red);	//radar
	  	setScanColor(Color.red);	//varredura
	  	setBulletColor(Color.red); //bala
		
		while(true) {
			//turnRight(5 * turnDirection);
			turnRadarRight(360); // rada vai gira 360 graus para direita
	     	ahead(100);			// robo vai anda 100 pixels
	     	turnGunRight(360);	// canhão vai gira 360 graus para direita
	     	back(100);			// robo anda 100 pixels para atrás
		}
	}

	//Detecta os outros robôs
	public void onScannedRobot(ScannedRobotEvent e) {
		double max = 100; //Defenir uma variavel de valor 100
		 //Faz um controle da energia que é gasta no que diz 
	 	 //respeito à potência do tiro
		//mira canhão fução abaixo do codigo 
      if(e.getEnergy() < max){		//se minha energia for menos que max 
         max = e.getEnergy();		//faça atira
         miraCanhao(e.getBearing(), max, getEnergy()); // obter comportamento, valor, obter energia
      }else if(e.getEnergy() >= max){	
         max = e.getEnergy();
         miraCanhao(e.getBearing(), max, getEnergy());
      }else if(getOthers() == 1){ // get others , Retorna quantos oponentes são deixados na rodada atual. 	
         max = e.getEnergy();	//getEnergy, Retorna a energia atual do robô.
         miraCanhao(e.getBearing(), max, getEnergy());
	  }
	}

	//Quando meu robô leva um tiro faça
	public void onHitByBullet(HitByBulletEvent e) {
		//turnRight(5 * turnDirection);
		turnLeft(90);		//andar para esquerda 90 pixels
	   	back(100); 			//andar para frente 100 pixels
		
		
	}
	//quando o meu robo colide com outro robo ou parede  //É chamado quando o robô bate na parede, ou colide
	public void onHitWall(HitWallEvent e) {
		ahead(50);
		back(10);	//obtém o comportamento do outro robo, e atira 
	}	
	//Fornece as coordenadas para o ajuste do canhão.
    public void miraCanhao(double PosIni, double energiaIni, double minhaEnergia) {
       double Distancia = PosIni;	//distância do meu robo 	//getGunHeading() == Retorna a direção que a arma do robô está enfrentando, em graus.
	   double Coordenadas = getHeading() + PosIni - getGunHeading(); //getHeading() == Retorna a direção em que o corpo do robô está voltado, em graus.
	   double PontoQuarenta = (energiaIni / 4) + .1;	//para atira 40 pontos de energia
	   	//usando tudo que ta acima
		//Aqui básicamente saber onde meu robo ta e o outro robo
	   if (!(Coordenadas > -180 && Coordenadas <= 180)) {
	      while (Coordenadas <= -180) {
		     Coordenadas += 360;
		  }
		  while (Coordenadas > 180) {
		     Coordenadas -= 360;
		  }
	   }
	   turnGunRight(Coordenadas); //gira meu canhão para direita de acordo com as coordenadas
	//se minha distância for maior que 200 ou minha energia menor que 15 ou minha energia inicial maior que minha energia então 	
	   if (Distancia > 200 || minhaEnergia < 15 || energiaIni > minhaEnergia){
          fire(1); // atira com 1 de energia
       } else if (Distancia > 50 ) {
          fire(2);	//atira com 2 de energia
       } else {
          fire(PontoQuarenta);	//Senta o dedo no Filho da P###
       }
   }
     
   //Dança da vitória
   public void onWin(WinEvent e) {	
      turnRight(72000);
   }
   //função para meu tiro fatal
   public void tiroFatal(double PosIni, double energiaIni, double minhaEnergia) {
      double Distancia = PosIni;
	  double Coordenadas = getHeading() + PosIni - getGunHeading(); 
	  double PontoQuarenta = (energiaIni / 4) + .1; 
	  if (!(Coordenadas > -180 && Coordenadas <= 180)) {
	     while (Coordenadas <= -180) {
	        Coordenadas += 360;
		 }
		 while (Coordenadas > 180) {
	        Coordenadas -= 360;
	     }
	  }
	  turnGunRight(Coordenadas);  //gira o canhão para direita de acordo com as coordenadas
	  fire(PontoQuarenta); //atira 
       
   }
}

