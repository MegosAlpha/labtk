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
