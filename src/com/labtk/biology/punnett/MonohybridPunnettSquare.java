/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labtk.biology.punnett;

import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author noah
 */
public class MonohybridPunnettSquare {
    public String CreateTableTop(Character[] p1g) {
        StringBuilder sb = new StringBuilder();
        sb.append(" |");
        sb.append(p1g[0]);
        sb.append(" |");
        sb.append(p1g[1]);
        sb.append(" |\n--------");
        return sb.toString();
    }
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
                Character[] geneArray = {allele, allele2};
                offspring.add(geneArray);
            }
        }
        //Prepare StringBuilder and Iterator
        StringBuilder sb = new StringBuilder();
        int myIter = 0;
        //Build the tabletop
        String tt = CreateTableTop(p2);
        sb.append(tt);
        //Output Offspring
        for (Character[] child : offspring) {
            if (myIter % 2 == 0) {
                sb.append('\n');
                sb.append(p1[myIter/2]);
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
