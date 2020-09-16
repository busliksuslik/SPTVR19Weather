/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19weatherreport;

import java.awt.Canvas;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
class App {
    private final Scanner scan = new Scanner(System.in);
    private final Random rand = new Random();
    public void run(){
        int month;
        int day;
        int max = 0;
        int [] maxday = new int[2];
        int min = 50;
        int [] average = new int[12];
        int [] minday = new int[2];
        int [][] Months = new int[12][];
        
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Canvas();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        g.fillOval(100, 100, 200, 200);
    
        for (int i = 0; i < 7; i++){
            if (i % 2 == 1 && i !=1){
                Months[i] = new int[30];
            } else if (i%2 != 1){
                Months[i] = new int[31];
            } else if (i == 1){
                Months[i] = new int[28];
            }
        }
        for (int i = 7; i < 12; i++){
            if (i % 2 == 0){
                Months[i] = new int[30];
            } else if (i%2 != 0){
                Months[i] = new int[31];
            }
        }
        // заполняем массив числами
        for(int i = 0;i< Months.length;i++){
            for (int j = 0 ; j <Months[i].length;j++){
                switch(i){
                    case 0:{
                        Months[i][j]= rand.nextInt(10)-10;
                        break;
                    }
                    case 1:{
                        Months[i][j]= rand.nextInt(10)-9;
                        break;
                    }
                    case 2:{
                        Months[i][j]= rand.nextInt(10)-5;
                        break;
                    }
                    case 3:{
                        Months[i][j]= rand.nextInt(10)-3;
                        break;
                    }
                    case 4:{
                        Months[i][j]= rand.nextInt(10)+5;
                        break;
                    }
                    case 5:{
                        Months[i][j]= rand.nextInt(10)+15;
                        break;
                    }
                    case 6:{
                        Months[i][j]= rand.nextInt(10)+17;
                        break;
                    }
                    case 7:{
                        Months[i][j]= rand.nextInt(10)+18;
                        break;
                    }
                    case 8:{
                        Months[i][j]= rand.nextInt(10)+12;
                        break;
                    }
                    case 9:{
                        Months[i][j]= rand.nextInt(10)+5;
                        break;
                    }
                    case 10:{
                        Months[i][j]= rand.nextInt(10);
                        break;
                    }
                    case 11:{
                        Months[i][j]= rand.nextInt(10)-5;
                        break;
                    }
                } 
            }
        }
                
        // ищем экстремумы
        for(int i = 0;i< Months.length;i++){
            for (int j = 0 ; j <Months[i].length;j++){
                if (Months[i][j] > max){
                    max = Months[i][j];
                    maxday[0]=i;
                    maxday[1]=j;
                } else if (Months[i][j] < min){
                    min = Months[i][j];
                    minday[0]=i;
                    minday[1]=j;
                }
            } 
        }
        for(int i = 0;i< Months.length;i++){
            int sum = 0;
            for (int j = 0 ; j <Months[i].length;j++){
                sum+=Months[i][j];
            } 
            average[i] = sum/Months[i].length;
        }
        /*for(int i = 0; i<Months.length;i++){
            System.out.printf("%3d",Months[i].length);
        }*/
        System.out.print("Введите номер месяца(1-12): ");
        month = scan.nextInt() - 1;
        System.out.println("");
        System.out.print("Введите день: ");
        day = scan.nextInt() - 1;
        System.out.println("");
        System.out.printf("температура на тот день составляла: %3d C%n", Months[month][day]);
        System.out.printf("самый холодный день:%d месяца %d дня: %d С%n",minday[0],minday[1],min);
        System.out.printf("самый жаркий день:%d месяца %d дня: %d С%n",maxday[0],maxday[1],max);
        System.out.println("Средние по месяцам");
        for(int i = 0; i<average.length;i++){
            System.out.printf("%3d",average[i]);
        }
        
        
    }
    
}
