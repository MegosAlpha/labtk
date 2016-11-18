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
    //FindComplement classes find the Complement Strands of DNA. Default is to
    //assume it's DNA (with only one parameter). With 2, you can specify true
    //if it is DNA or false if it's RNA.
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
