package com.arquitetura.simulador;

import java.util.List;
import java.util.ArrayList;

public class Computador {
	private List<Integer> stack;
	private int limiteStack;
	private int pc;
	private String ir;
	private String mar;
	private int mbr;
	private int memoriaLimite;
	private String[] memoria;
	private List<Integer> memoriaDados;
	private int countMemoria;

	public Computador() {
		memoriaLimite = 10;
		memoria = new String[memoriaLimite];
		countMemoria = 0;
		stack = new ArrayList<>();
		limiteStack = 0;
		pc = 0;
		zeraMarMbr();
	}

	public Computador(int memoriaLimite) {
		this.memoriaLimite = memoriaLimite;
		memoria = new String[memoriaLimite];
		countMemoria = 0;
		stack = new ArrayList<>();
		limiteStack = 0;
		pc = 0;
		zeraMarMbr();
	}

	public void setMemoriaDados(List<Integer> memoriaDados) {
		this.memoriaDados = memoriaDados;

	}

	private void zeraMarMbr() {
		mar = "";
		mbr = 0;
	}

	public boolean push(String reg) {
		pc++;
		if (limiteStack <= 4) {
			int in;
			switch (reg) {
			case "M10":
				in = memoriaDados.get(0);
				break;
			case "M11":
				in = memoriaDados.get(1);
				break;
			case "M12":
				in = memoriaDados.get(2);
				break;
			case "M13":
				in = memoriaDados.get(3);
				break;
			case "M14":
				in = memoriaDados.get(4);
				break;
			case "M15":
				in = memoriaDados.get(5);
				break;
			case "M16":
				in = memoriaDados.get(6);
				break;
			case "M17":
				in = memoriaDados.get(7);
				break;
			case "M18":
				in = memoriaDados.get(8);
				break;
			case "M19":
				in = memoriaDados.get(9);
				break;
			default:
				in = Integer.parseInt(reg);
				reg = "Pilha[" + limiteStack + "]";
				break;
			}
			stack.add(in);
			limiteStack++;
			mar = reg;
			mbr = in;
			return true;
		}
		return false;
	}

	public int pop(String reg) {
		pc++;
		if (limiteStack > 0) {
			int in;
			switch (reg) {
			case "M10":
				in = 0;
				break;
			case "M11":
				in = 1;
				break;
			case "M12":
				in = 2;
				break;
			case "M13":
				in = 3;
				break;
			case "M14":
				in = 4;
				break;
			case "M15":
				in = 5;
				break;
			case "M16":
				in = 6;
				break;
			case "M17":
				in = 7;
				break;
			case "M18":
				in = 8;
				break;
			case "M19":
				in = 9;
				break;
			default:
				return 1;
			}
			limiteStack--;
			int valor = stack.remove(limiteStack);
			memoriaDados.set(in, valor);
			mar = reg;
			mbr = valor;
			return 0;
		}
		return 2;
	}

	public boolean add() {
		zeraMarMbr();
		pc++;
		if (limiteStack <= 4) {
			stack.add(stack.get(limiteStack - 1) + stack.get(limiteStack - 2));
			limiteStack++;
			return true;
		}
		return false;
	}

	public boolean sub() {
		zeraMarMbr();
		pc++;
		if (limiteStack <= 4) {
			stack.add(stack.get(limiteStack - 2) - stack.get(limiteStack - 1));
			limiteStack++;
			return true;
		}
		return false;
	}

	public boolean and() {
		zeraMarMbr();
		pc++;
		if (limiteStack <= 4) {
			stack.add(stack.get(limiteStack - 2) & stack.get(limiteStack - 1));
			limiteStack++;
			return true;
		}
		return false;
	}

	public boolean or() {
		zeraMarMbr();
		pc++;
		if (limiteStack <= 4) {
			stack.add(stack.get(limiteStack - 2) | stack.get(limiteStack - 1));
			limiteStack++;
			return true;
		}
		return false;
	}

	public boolean xor() {
		zeraMarMbr();
		pc++;
		if (limiteStack <= 4) {
			stack.add(stack.get(limiteStack - 2) ^ stack.get(limiteStack - 1));
			limiteStack++;
			return true;
		}
		return false;
	}

	public boolean not() {
		zeraMarMbr();
		pc++;
		if (limiteStack <= 4) {
			stack.add(~stack.get(limiteStack - 1));
			limiteStack++;
			return true;
		}
		return false;
	}

	public String[] getMemoria() {
		return memoria;
	}

	public boolean memoriaCheia() {
		if (countMemoria >= memoriaLimite) {
			return true;
		} else {
			return false;
		}
	}

	public void setIr(String ir) {
		this.ir = ir;
		memoria[countMemoria] = ir;
		countMemoria++;
	}

	public List<Integer> getStack() {
		return stack;
	}

	public List<Integer> getMemoriaDados() {
		return memoriaDados;
	}

	public int getPc() {
		return pc;
	}

	public String getIr() {
		return ir;
	}

	public int getMemoriaLimite() {
		return memoriaLimite;
	}

	public String getMar() {
		return mar;
	}

	public int getMbr() {
		return mbr;
	}
}
