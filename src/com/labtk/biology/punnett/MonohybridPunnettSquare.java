/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labtk.biology.punnett;

import java.util.Scanner;
import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author noah
 */
public class MonohybridPunnettSquare {
    Scanner scanner = new Scanner(System.in);
    public void CreateTableTop(Character[] p1g) {
        StringBuilder sb = new StringBuilder();
        sb.append(" |");
        sb.append(p1g[0]);
        sb.append(" |");
        sb.append(p1g[1]);
        sb.append(" |");
        System.out.println(sb.toString());
        System.out.print("--------");
    }
    public void GetPunnettSquare() {
        //Make sure the user knows what is running
        System.out.println("Monohybrid Punnett Square Creator");
        //Get parental data
        System.out.print("Parent 1: ");
        String p1_string = scanner.next();
        System.out.print("Parent 2: ");
        String p2_string = scanner.next();
        //Check parental data for violations
        if (p1_string.length() != 2) {
            System.out.println("Invalid Length on Parent 1!");
            return;
        }
        if (p2_string.length() != 2) {
            System.out.println("Invalid Length on Parent 2!");
            return;
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
        //Build the tabletop
        CreateTableTop(p2);
        //Prepare StringBuilder and Iterator
        StringBuilder sb = new StringBuilder();
        int myIter = 0;
        //Output Offspring
        for (Character[] child : offspring) {
            if (myIter % 2 == 0) {
                System.out.println(sb.toString());
                sb = new StringBuilder();
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
        System.out.println(sb.toString());
        //Clean-up and close scanner
        scanner.close();
    }
}
