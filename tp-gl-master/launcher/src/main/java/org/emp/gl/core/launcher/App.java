package org.emp.gl.core.launcher;

import java.util.Random;
import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

public class App {

    public static void main(String[] args) {
        
        TimerService tm = new DummyTimeServiceImpl();
        
        // Plusieurs horloges
        Horloge horloge1 = new Horloge("Horloge-1", tm);
        Horloge horloge2 = new Horloge("Horloge-2", tm);
        Horloge horloge3 = new Horloge("Horloge-3", tm);
        
        // Compte à rebours de 5
        CompteARebours compte5 = new CompteARebours("Compte-5", 5, tm);
        
        // 10 comptes à rebours aléatoires (10-20)
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int valeur = 10 + random.nextInt(11);
            new CompteARebours("Compte-" + i, valeur, tm);
        }
    }

    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}