/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labtk.biology.geneticcode;

import org.apache.commons.lang3.ArrayUtils;
/**
 *
 * @author noah
 */
public class NucleicAcids {
    /**
     * Find Complement (with boolean) allows you to decide if you would like
     * DNA as a complement or RNA as a complement. This method finds the opposite
     * side of a DNA or RNA sequence and outputs it as DNA or RNA.
     * 
     * @param myCode Genetic Code (all caps)
     * @param isDNA True for DNA output, false for RNA output.
     * @return Complement Strand of DNA
     */
    public String FindComplement(String myCode, Boolean isDNA) {
        StringBuilder sb = new StringBuilder();
        for (Character l : ArrayUtils.toObject(myCode.toCharArray())) {
            switch (l) {
                case 'A':
                    if (!isDNA)
                        sb.append('U');
                    else
                        sb.append('T');
                    break;
                case 'T':
                    sb.append('A');
                    break;
                case 'U':
                    sb.append('A');
                    break;
                case 'C':
                    sb.append('G');
                    break;
                case 'G':
                    sb.append('C');
                    break;
                default:
                    System.out.println("Invalid Character Found!");
                    break;
            }
        }
        return sb.toString();
    }
    /**
     * Find Complement (short form, no boolean). Generates opposite strand of DNA
     * or RNA and outputs DNA only.
     * 
     * @param myCode Genetic Code to find complement of (All Caps).
     * @return DNA complement of myCode.
     */
    public String FindComplement(String myCode) {
        Boolean isDNA = true;
        StringBuilder sb = new StringBuilder();
        for (Character l : ArrayUtils.toObject(myCode.toCharArray())) {
            switch (l) {
                case 'A':
                    if (!isDNA)
                        sb.append('U');
                    else
                        sb.append('T');
                    break;
                case 'T':
                    sb.append('A');
                    break;
                case 'U':
                    sb.append('A');
                    break;
                case 'C':
                    sb.append('G');
                    break;
                case 'G':
                    sb.append('C');
                    break;
                default:
                    System.out.println("Invalid Character Found!");
                    break;
            }
        }
        return sb.toString();
    }
}
