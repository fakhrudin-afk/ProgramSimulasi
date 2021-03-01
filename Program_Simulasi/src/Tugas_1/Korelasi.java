/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Korelasi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Nama : Fakhrudin Rizky Husaini");
        System.out.println("NRP  : 152017113");
        System.out.println("Tugas Korelasi");
        System.out.println("");
        
        int n = 0;
        
        double X2 = 0, Y2 = 0,SigmaX = 0, SigmaY = 0, XY = 0, SigmaXY = 0, SigmaX2 = 0, SigmaY2 = 0;
        double paket1 = 0, paket2 = 0, paket3 = 0, paket4 = 0, atas = 0, bawah = 0, r = 0;
        
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukan jumlah data : ");
        n = input.nextInt();
        
        double[] dataX = new double[n];
        double[] dataY = new double[n];
        
        for(int i=0;i<n;i++)
        {
            System.out.print("Masukan data X ke-"+(i+1)+" : ");
            dataX[i] = input.nextDouble();
            System.out.print("Masukan data Y ke-"+(i+1)+" : ");
            dataY[i] = input.nextInt();
            
            SigmaX = SigmaX + dataX[i];
            SigmaY = SigmaY + dataY[i];
            X2 = Math.pow(dataX[i], 2);
            Y2 = Math.pow(dataY[i], 2);
            SigmaX2 = SigmaX2 + X2;
            SigmaY2 = SigmaY2 + Y2;
            XY = dataX[i]*dataY[i];
            SigmaXY = SigmaXY + XY;
            
            paket1 = n * SigmaXY;
            paket2 = SigmaX * SigmaY;
            paket3 = (n * SigmaX2) - Math.pow(SigmaX, 2);
            paket4 = (n * SigmaY2) - Math.pow(SigmaY, 2);
            
            atas = paket1 - paket2;
            bawah = Math.sqrt(paket3 * paket4);
            r = atas/bawah;
        }
        
        System.out.println("");
        
        if(r<0){
            System.out.println("Korelasi(r) = "+df.format(r)+" (Nilai korelasi negatif(-) menunjukan hubungan yang terbalik)");
        }else{
            System.out.println("Korelasi(r) = "+df.format(r)+" (Nilai korelasi positif(+) menunjukan hubungan yang lurus/linear)");
        }
        
        if(r>=0 && r<0.2){
            System.out.println("Skala Guilford = Sangat Lemah");
        }else if(r>=0.2 && r<0.4){
            System.out.println("Skala Guilford = Lemah");
        }else if(r>=0.4 && r<0.6){
            System.out.println("Skala Guilford = Sedang");
        }else if(r>=0.6 && r<0.8){
            System.out.println("Skala Guilford = Kuat");
        }else if(r>=0.8 && r<=1){
            System.out.println("Skala Guilford = Sangat Kuat");
        }
        
        double koef_det = 0;
        koef_det = Math.pow(r, 2) * 100;
        
        System.out.println("Nilai Kontribusi variable bebas terhadap variable terikat = "+df.format(koef_det)+"%");
        System.out.println("Nilai Kontribusi dari faktor lain terhadap variable terikat = "+df.format(100-koef_det)+"%");
    }
    
}
