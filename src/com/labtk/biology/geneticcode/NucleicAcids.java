/* 
 * labtk - Toolkit for Lab-based High School Science Courses
 * Copyright (C) 2016  Noah Walker

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
