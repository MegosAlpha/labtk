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
