package carreravagosori;

import java.util.Scanner;

class Hilo extends Thread {

    private String L;
	private int tiempoDormido;
        
	public Hilo(String str) {
            super(str);
	}
        
        public void dormir() throws InterruptedException{
            sleep((long)(Math.random() * 1000));
        }

        @Override
	public void run() {
            for (int i=0; i<5; i++){
                try{
                    dormir();
                    tiempoDormido++;
                    L = getName() + " ha dormido: " + tiempoDormido + " segundos"; 
                } catch(InterruptedException e){}
            }

            if(tiempoDormido == 5 && getName().equals("Juferoga")){         
                L ="-- Juferoga ha ganado --";

            }

            else if(tiempoDormido == 5 && getName().equals("Flash")){
                L ="-- flash ha ganado --";
                }
        }
	
	public int getTiempoDormido(){
            return tiempoDormido;
	}
}