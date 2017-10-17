/* 
 * MIT License

 * Copyright (c) 2016 Noah Walker

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.labtk.labtk;

import com.labtk.biology.punnett.DihybridPunnettSquare;
import com.labtk.biology.punnett.MonohybridPunnettSquare;
import com.labtk.biology.geneticcode.NucleicAcids;
import java.util.Scanner;
import com.labtk.physics.Equations;
import com.labtk.chemistry.Chem_equations;
/**
 *
 * @author noah
 */
public class Main {
    //Set up my scanner.
    static Scanner scanner = new Scanner(System.in);
    static String[] cArgs;
    static int inputIter = 0;
    /**
     * Returns text from either command line flags
     * or from the user through scanner. This form
     * does not allow consumption of all characters
     * at the end. This method makes it possible to
     * automate testing of the labtk interface easily.
     * 
     * @return User Input from Scanner or Command-line Arguments
     */
    static String getNextInput() {
        if (cArgs.length == 0) {
            return scanner.next();
        } else if (cArgs[0].equals("--help") || cArgs[0].equals("-h")) {
            System.out.println("--<flag> = Represents decision tree. --b would choose biology, then switch over to interactive mode");
            Runtime.getRuntime().exit(0);
            return "";
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
     * Form of getNextInput that will consume
     * the remainder of the string. Best for passing
     * multi-letter data in tests like DNA or RNA.
     * Special note: the string can still be processed by
     * getNextInput if multichar is true.
     * 
     * @param multichar Boolean that sets apart Split by comma or Consume all. Set true for comma split, false for final on string.
     * @return Remainder of the string
     */
    static String getNextInput(Boolean multichar) {
        if (cArgs.length == 0) {
            return scanner.next();
        } else if (cArgs[0].equals("--help") || cArgs[0].equals("-h")) {
            System.out.println("--<flag> = Represents decision tree. --b would choose biology, then switch over to interactive mode");
            Runtime.getRuntime().exit(0);
            return "";
        } else {
            if (cArgs[0].length() - 2 > inputIter) {
                if (multichar) {
                    //Process until comma
                    String[] preStr = cArgs[0].substring(inputIter+2).split(",");
                    System.out.println(preStr[0]);
                    //Swallow the comma!
                    inputIter += preStr[0].length()+1;
                    return preStr[0];
                } else {
                    //Consume all
                    System.out.println(cArgs[0].substring(inputIter+2));
                    if (multichar)
                        inputIter += cArgs[0].length();
                    return cArgs[0].substring(inputIter+2-cArgs[0].length());
                }       
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
                        String mygc = getNextInput(true);
                        System.out.println(nca.FindComplement(mygc, false));
                    } else {
                        NucleicAcids nca = new NucleicAcids();
                        System.out.print("Enter your genetic code: ");
                        String mygc = getNextInput(true);
                        System.out.println(nca.FindComplement(mygc));
                    }
                } else if (bioResp.equals("P")) {
                    System.out.print("Monohybrid or Dihybrid? (M or D): ");
                    if (getNextInput().equals("M")) {
                        MonohybridPunnettSquare mps = new MonohybridPunnettSquare();
                        //Get parental data
                        System.out.print("Parent 1: ");
                        String p1_string = getNextInput(true);
                        System.out.print("Parent 2: ");
                        String p2_string = getNextInput(true);
                        System.out.println(mps.GetPunnettSquare(p1_string, p2_string));
                    } else {
                        DihybridPunnettSquare dps = new DihybridPunnettSquare();
                        //Get parental data
                        System.out.print("Parent 1: ");
                        String p1_string = getNextInput(true);
                        System.out.print("Parent 2: ");
                        String p2_string = getNextInput(true);
                        System.out.println(dps.GetPunnettSquare(p1_string, p2_string));
                    }
                }
                break;
            case "C":
                System.out.print("Chemistry");
                System.out.print("Molarity or Molality? (M or N): ");
                String chemResp = getNextInput();
                if(chemResp.equals("M")) {
                    System.out.println("No. of moles: ");
                    String m = getNextInput(true);
                    int moles = Integer.parseInt(m);
                    System.out.println("Volume in litres: ");
                    String v = getNextInput(true);
                    int volume = Integer.parseInt(v);
                    Chem_equations.GetMolarity(moles, volume);
                }
                if(chemResp.equals("N")) {
                    System.out.println("Not yet built");
                }
                break;
            case "H":
                System.out.println("Physics");
                System.out.print("Force or Pressure? (F or P): ");
                String phyResp = getNextInput();
                if(phyResp.equals("F")) {
                    System.out.println("Mass: ");
                    String m = getNextInput(true);
                    int mass = Integer.parseInt(m);
                    System.out.println("Acceleration: ");
                    String a = getNextInput(true);
                    int accel = Integer.parseInt(a);
                    Equations.GetForce(mass, accel);
                }
                if(phyResp.equals("P")) {
                    System.out.println("Force: ");
                    String f = getNextInput(true);
                    int force = Integer.parseInt(f);
                    System.out.println("Area: ");
                    String a = getNextInput(true);
                    int area = Integer.parseInt(a);
                    Equations.GetPressure(force, area);
                }
                break;
        }
        scanner.close();
    }
}
