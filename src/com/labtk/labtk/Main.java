/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labtk.labtk;
import com.labtk.biology.punnett.DihybridPunnettSquare;
/**
 *
 * @author noah
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set up labtk base
        System.out.println("labtk - Lab-Based Science Toolkit");
        DihybridPunnettSquare dps = new DihybridPunnettSquare();
        dps.GetPunnettSquare();
    }
    
}
