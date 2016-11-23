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
package com.labtk.biology.punnett;

import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author noah
 */
public class MonohybridPunnettSquare {
    /**
     * Creates the top of the table for a Monohybrid Punnett Square.
     * 
     * @param p1g Parent 1's gametes to populate table top with.
     * @return Tabletop in string form with newlines.
     */
    public String CreateTableTop(Character[] p1g) {
        StringBuilder sb = new StringBuilder();
        sb.append(" |");
        sb.append(p1g[0]);
        sb.append(" |");
        sb.append(p1g[1]);
        sb.append(" |\n--------");
        return sb.toString();
    }
    /**
     * Monohybrid Punnett Square Builder. This takes the 2 parent strings,
     * something similar to "Aa" and "aa". It performs the genetic cross, then
     * builds the fancy table.
     * @param p1_string First Parental Genotype
     * @param p2_string Second Parental Genotyoe
     * @return Fancy Monohybrid Punnett Square.
     */
    public String GetPunnettSquare(String p1_string, String p2_string) {
        //Check parental data for violations
        if (p1_string.length() != 2) {
            return "Invalid Length on Parent 1!";
        }
        if (p2_string.length() != 2) {
            return "Invalid Length on Parent 2!";
        }
        //Determine Gametes
        Character[] p1 = ArrayUtils.toObject(p1_string.toCharArray());
        Character[] p2 = ArrayUtils.toObject(p2_string.toCharArray());
        //Set up offspring
        ArrayList<Character[]> offspring = new ArrayList<>();
        //Perform genetic cross
        for (Character allele : p1) {
            for (Character allele2 : p2) {
                Character[] geneArray = {allele2, allele};
                offspring.add(geneArray);
            }
        }
        //Prepare StringBuilder and Iterator
        StringBuilder sb = new StringBuilder();
        int myIter = 0;
        //Build the tabletop
        String tt = CreateTableTop(p1);
        sb.append(tt);
        //Output Offspring
        for (Character[] child : offspring) {
            if (myIter % 2 == 0) {
                sb.append('\n');
                sb.append(p2[myIter/2]);
                sb.append('|');
            }
            if (!Character.isUpperCase(child[0]) && Character.isUpperCase(child[1])) {
                sb.append(child[1]);
                sb.append(child[0]);
            } else {
                sb.append(child[0]);
                sb.append(child[1]);
            }
            sb.append('|');
            myIter++;
        }
        //Get any leftover out
        return sb.toString();
    }
}
