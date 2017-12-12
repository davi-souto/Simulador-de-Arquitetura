package com.arquitetura.simulador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Computador pc = new Computador();
		Scanner sc = new Scanner(System.in);
		int memoDados = 10;
		List<Integer> memoriaDadosInit = new ArrayList<>();
		for (int i = 0; i < memoDados; i++) {
			memoriaDadosInit.add(0);
		}
		pc.setMemoriaDados(memoriaDadosInit);

		System.out.println("Escreva suas instrucões!");
		boolean key = true;
		String ir;

		while (key) {
			ir = "";
			String instru = sc.next().toUpperCase();
			ir += instru;
			switch (instru) {
			case "PUSH":
				String src = sc.next().toUpperCase();
				ir += " " + src;
				if (!pc.push(src))
					System.out.println("Pilha Cheia");
				break;
			case "POP":
				String dest = sc.next().toUpperCase();
				ir += " " + dest;
				int aviso = pc.pop(dest);
				if (aviso == 1)
					System.out.println("Endereço Inválido");
				else if (aviso == 2)
					System.out.println("Pilha Vazia");
				break;
			case "ADD":
				pc.add();
				break;
			case "SUB":
				pc.sub();
				break;
			case "AND":
				pc.and();
				break;
			case "OR":
				pc.or();
				break;
			case "XOR":
				pc.xor();
				break;
			case "NOT":
				pc.not();
				break;
			case "EXIT":
				key = false;
				break;
			}
			if (key) {
				pc.setIr(ir);
				System.out.println("##############################");
				System.out.println("IR: " + pc.getIr());
				System.out.println("PC: " + pc.getPc());
				System.out.println("MAR: " + pc.getMar());
				System.out.println("MBR: " + pc.getMbr());
				System.out.println("Pilha: " + pc.getStack().toString().replace(", ", " | "));
				System.out.println("==============================");
				System.out.println("Memória: ");
				String memoria[] = pc.getMemoria();
				List<Integer> memoriaDados = pc.getMemoriaDados();
				int i;
				for (i = 0; i < pc.getMemoriaLimite(); i++) {
					if (memoria[i] != null) {
						System.out.print(String.format("M" + i + ": %-10s", memoria[i]));
					} else {
						System.out.print(String.format("M" + i + ": %-10s", " "));
					}
					System.out.println("\t" + "M" + (i + 10) + ": " + memoriaDados.get(i));
				}
				System.out.println("==============================");
			}
			if (pc.memoriaCheia()) {
				System.out.println("Memória cheia...");
				break;
			}
		}

		sc.close();
	}
}
