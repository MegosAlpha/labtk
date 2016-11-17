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
    public void GetData() {
        System.out.print("Parent 1: ");
        String p1_string = scanner.next();
        System.out.print("Parent 2: ");
        String p2_string = scanner.next();
        Character[] p1 = ArrayUtils.toObject(p1_string.toCharArray());
        Character[] p2 = ArrayUtils.toObject(p2_string.toCharArray());
        ArrayList<Character[]> offspring = new ArrayList<>();
        for (Character allele : p1) {
            for (Character allele2 : p2) {
                Character[] geneArray = {allele, allele2};
                offspring.add(geneArray);
            }
        }
        offspring.forEach((Character[] child) -> {
            StringBuilder sb = new StringBuilder();
            if (!Character.isUpperCase(child[0]) && Character.isUpperCase(child[1])) {
                sb.append(child[1]);
                sb.append(child[0]);
                System.out.println(sb.toString());
            } else {
                sb.append(child[0]);
                sb.append(child[1]);
                System.out.println(sb.toString());
            }
        });
    }
}
