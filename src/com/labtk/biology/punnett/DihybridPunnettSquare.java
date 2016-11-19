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

/**
 *
 * @author noah
 */
public class DihybridPunnettSquare {
    /**
     * Genetic Formatter to create the array used for genetic crosses
     * 
     * @param parentStr Genotype of parent that is not yet processed.
     * @return Ready to use Character[][] for gamete calculation
     * @see CalculateGametes
     */
    public Character[][] GetProperGeneticFormat(String parentStr) {
        return new Character[][]{
            new Character[]{
                parentStr.toCharArray()[0], parentStr.toCharArray()[1]
            },
            new Character[]{
                parentStr.toCharArray()[2], parentStr.toCharArray()[3]
            }
        };
    }
    /**
     * Gamete Calculator for Dihybrid Punnett Squares. Could have done it with
     * for loops, but didn't.
     * 
     * @param parent Proper format parental genotype.
     * @return All possible parent gametes.
     */
    public Character[][] CalculateGametes(Character[][] parent) {
        return new Character[][]{
            new Character[] {
                parent[0][0], parent[1][0] 
            },
            new Character[] {
                parent[0][1], parent[1][0] 
            },
            new Character[] {
                parent[0][0], parent[1][1] 
            },
            new Character[] {
                parent[0][1], parent[1][1] 
            }
        };
    }
    /**
     * Punnett Square Tabletop Creator for Dihybrid
     * Punnett Squares. Builds the fancy table header.
     * 
     * @param p1g Parent 1's gametes.
     * @return Fancy table header.
     */
    public String CreateTableTop(Character[][] p1g) {
        //Set up StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        sb.append('|');
        //Start up tabletop creation
        for (Character[] g : p1g) {
            sb.append(' ');
            sb.append(g[0]);
            sb.append(g[1]);
            sb.append(' ');
            sb.append('|');
        }
        //Print out first row and hyphen seperator
        sb.append('\n');
        sb.append("-----------------------");
        return sb.toString();
    }
    /**
     * Dihybrid Punnett Square Calculator. Outputs fancy Dihybrid Punnett Square,
     * determines gametes, performs genetic cross.
     * 
     * @param p1_string Parent 1's genotype.
     * @param p2_string Parent 2's genotype.
     * @return Fancy Punnett Square.
     */
    public String GetPunnettSquare(String p1_string, String p2_string) {
        //Check parent's genotypes for proper length
        if (p1_string.length() != 4) {
            return "Invalid Length on Parent 1!";
        }
        if (p2_string.length() != 4) {
            return "Invalid Length on Parent 2!";
        }
        //Create the proper genetic format
        Character[][] p1 = GetProperGeneticFormat(p1_string);
        Character[][] p2 = GetProperGeneticFormat(p2_string);
        //Calculate Gametes
        Character[][] p1g = CalculateGametes(p1);
        Character[][] p2g = CalculateGametes(p2);
        //Create Offspring ArrayList
        ArrayList<Character[][]> offspring = new ArrayList<>();
        //Perform Genetic Cross
        for (Character[] p1ga: p1g) {
            for (Character[] p2ga: p2g) {
                offspring.add(new Character[][]{
                    new Character[] {
                        p2ga[0], p1ga[0]
                    },
                    new Character[] {
                        p2ga[1], p1ga[1]
                    }
                });
            }
        }
        //Make StringBuilder
        StringBuilder sb = new StringBuilder();
        //Make that tabletop!
        sb.append(CreateTableTop(p1g));
        //Output Offspring (Row-by-Row). Now with row headers!
        int myIter = 0;
        for (Character[][] child : offspring) {
            if (myIter % 4 == 0) {
                sb.append('\n');
                sb.append(p2g[myIter / 4][0]);
                sb.append(p2g[myIter / 4][1]);
                sb.append('|');
            }
            if (!Character.isUpperCase(child[0][0]) && Character.isUpperCase(child[0][1])) {
                sb.append(child[0][1]);
                sb.append(child[0][0]);
            } else {
                sb.append(child[0][0]);
                sb.append(child[0][1]);
            }
            if (!Character.isUpperCase(child[1][0]) && Character.isUpperCase(child[1][1])) {
                sb.append(child[1][1]);
                sb.append(child[1][0]);
            } else {
                sb.append(child[1][0]);
                sb.append(child[1][1]);
            }
            sb.append('|');
            myIter++;
        }
        //Last check!
        return sb.toString();
    }
}
