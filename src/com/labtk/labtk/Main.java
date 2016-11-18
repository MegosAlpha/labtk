/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labtk.labtk;

import com.labtk.biology.punnett.DihybridPunnettSquare;
import com.labtk.biology.punnett.MonohybridPunnettSquare;

/**
 *
 * @author noah
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //labtk Header
        System.out.println("labtk - Lab-Based Science Toolkit");
        //Args Check
        if (args.length < 1) {
            System.out.println("Not long enough.");
        } else {
            //Handle flags
            switch (args[0]) {
                case "--help":
                    System.out.println("--dps - Begin Interactive Dihybrid Punnett Square");
                    System.out.println("--mps - Begin Interactive Monohybrid Punnett Square");
                    break;
                case "--dps":
                    DihybridPunnettSquare dps = new DihybridPunnettSquare();
                    dps.GetPunnettSquare();
                    break;
                case "--mps":   
                    MonohybridPunnettSquare mps = new MonohybridPunnettSquare();
                    mps.GetPunnettSquare();
                    break;
                default:
                    System.out.println("Flag not detected.");
                    break;
            }
        }
    }
}
