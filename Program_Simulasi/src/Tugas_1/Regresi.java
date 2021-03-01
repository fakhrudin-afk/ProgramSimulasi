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
public class Regresi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Nama : Fakhrudin Rizky Husaini");
        System.out.println("NRP  : 152017113");
        System.out.println("Tugas Regresi");
        System.out.println("");
        
        int n = 0;
        
        double X2 = 0, Y2 = 0,SigmaX = 0, SigmaY = 0, XY = 0, SigmaXY = 0, SigmaX2 = 0, SigmaY2 = 0;
        double paket1_konst = 0, paket2_konst = 0, paket3_konst = 0, paket4_konst = 0, atas_konst = 0, bawah_konst = 0, konstanta = 0;
        double paket1_koef = 0, paket2_koef = 0, paket3_koef = 0, paket4_koef = 0, atas_koef = 0, bawah_koef = 0, koefisien = 0;
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
            
            paket1_konst = SigmaY * SigmaX2;
            paket2_konst = SigmaX * SigmaXY;
            paket3_konst = n * SigmaX2;
            paket4_konst = Math.pow(SigmaX, 2);
            
            atas_konst = paket1_konst - paket2_konst;
            bawah_konst = paket3_konst - paket4_konst;
            konstanta = atas_konst/bawah_konst;
            
            paket1_koef = n * SigmaXY;
            paket2_koef = SigmaX * SigmaY;
            paket3_koef = n * SigmaX;
            paket4_koef = Math.pow(SigmaX, 2);
            
            atas_koef = paket1_koef - paket2_koef;
            bawah_koef = paket3_koef - paket4_koef;
            koefisien = atas_koef/bawah_koef;
        }
        
        System.out.println("");
        System.out.println("Konstanta = "+df.format(konstanta));
        System.out.println("Koefisien = "+df.format(koefisien));
        
        double x,y,a,b;
        System.out.print("Masukan X : ");
        x = input.nextDouble();
        
        a = konstanta;
        b = koefisien;
        y = a + (b*x);
        System.out.println("Y = "+df.format(y));
    }
    
}
