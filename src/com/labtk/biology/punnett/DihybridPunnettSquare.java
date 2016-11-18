/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labtk.biology.punnett;

import java.util.ArrayList;

/**
 *
 * @author noah
 */
public class DihybridPunnettSquare {
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
    public String CreateTableTop(Character[][] p2g) {
        //Set up StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        sb.append('|');
        //Start up tabletop creation
        for (Character[] g : p2g) {
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
                        p1ga[0], p2ga[0]
                    },
                    new Character[] {
                        p1ga[1], p2ga[1]
                    }
                });
            }
        }
        //Make StringBuilder
        StringBuilder sb = new StringBuilder();
        //Make that tabletop!
        sb.append(CreateTableTop(p2g));
        //Output Offspring (Row-by-Row). Now with row headers!
        int myIter = 0;
        for (Character[][] child : offspring) {
            if (myIter % 4 == 0) {
                //System.out.println(sb.toString());
                //sb = new StringBuilder();
                sb.append('\n');
                sb.append(p1g[myIter / 4][0]);
                sb.append(p1g[myIter / 4][1]);
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
