/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labtk.biology.punnett;

import java.util.Scanner;
import java.util.ArrayList;

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
        Character[] p1 = {'A', 'a'};
        Character[] p2 = {'A', 'a'};
        ArrayList<Character[]> offspring = new ArrayList<>();
        for (Character allele : p1) {
            for (Character allele2 : p2) {
                Character[] geneArray = {allele, allele2};
                offspring.add(geneArray);
            }
        }
        offspring.forEach((child) -> {
            int allele_num = 0;
            for (Character allele : child){
                if (allele_num == 1) {
                    System.out.println(allele);
                    allele_num = 0;
                }
                else if (allele_num == 0){
                    System.out.print(allele);
                    allele_num = 1;
                }
            }
        });
    }
}
