/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labtk.labtk;

import com.labtk.biology.punnett.DihybridPunnettSquare;
import com.labtk.biology.punnett.MonohybridPunnettSquare;
import com.labtk.biology.geneticcode.NucleicAcids;
import java.util.Scanner;
/**
 *
 * @author noah
 */
public class Main {
    //Set up my scanner.
    static Scanner scanner = new Scanner(System.in);
    static String[] cArgs;
    static int inputIter = 0;
    static String getNextInput() {
        if (cArgs.length == 0) {
            return scanner.next();
        } else {
            if (cArgs[0].length() - 2 > inputIter) {
                //Increment Early (why there are protectors down there)
                inputIter++;
                //Make sure user can see flag input
                System.out.println(new Character(cArgs[0].toUpperCase().toCharArray()[inputIter+1]).toString());
                //Nasty code processing unit
                return new Character(cArgs[0].toUpperCase().toCharArray()[inputIter+1]).toString();
            } else {
                return scanner.next();
            }   
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cArgs = args;
        
        //Output labtk Header
        System.out.println("labtk - Lab-Based Science Toolkit (Biology only, currently)");
        //Query User
        System.out.print("Biology, Chemistry or Physics? (B,C,or H): ");
        String response = getNextInput();
        if (response.length() != 1) {
            System.out.println("Error, did not input B, C, or H.");
            return;
        }
        switch (response) {
            case "B":
                System.out.println("Biology");
                System.out.print("Genetic Code or Punnett Squares? (G or P): ");
                String bioResp = getNextInput();
                if (bioResp.equals("G")) {
                    System.out.print("Should the complement be DNA or RNA? (D or R): ");
                    String dnaPick = getNextInput();
                    if (dnaPick.equals("R")) {
                        NucleicAcids nca = new NucleicAcids();
                        System.out.print("Enter your genetic code: ");
                        String mygc = getNextInput();
                        System.out.println(nca.FindComplement(mygc, false));
                    } else {
                        NucleicAcids nca = new NucleicAcids();
                        System.out.print("Enter your genetic code: ");
                        String mygc = getNextInput();
                        System.out.println(nca.FindComplement(mygc));
                    }
                } else if (bioResp.equals("P")) {
                    System.out.print("Monohybrid or Dihybrid? (M or D): ");
                    if (getNextInput().equals("M")) {
                        MonohybridPunnettSquare mps = new MonohybridPunnettSquare();
                        //Get parental data
                        System.out.print("Parent 1: ");
                        String p1_string = getNextInput();
                        System.out.print("Parent 2: ");
                        String p2_string = getNextInput();
                        System.out.println(mps.GetPunnettSquare(p1_string, p2_string));
                    } else {
                        DihybridPunnettSquare dps = new DihybridPunnettSquare();
                        //Get parental data
                        System.out.print("Parent 1: ");
                        String p1_string = getNextInput();
                        System.out.print("Parent 2: ");
                        String p2_string = getNextInput();
                        System.out.println(dps.GetPunnettSquare(p1_string, p2_string));
                    }
                }
                break;
        }
        scanner.close();
    }
}
