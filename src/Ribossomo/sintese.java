package Ribossomo;
/*ALUNO: Kiro Marcell de Almeida Meneses Araújo 
 *TÓPICOS EM BIOCOMPUTAÇÃO
 *PROGRAMA QUE TRANSFORMA DNA EM RNA MENSAGEIRO, E ENTÃO SIMULA UM RIBOSSOMO, USANDO
 *O RNA MENSAGEIRO PARA CRIAR UMA CADEIA DE AMINOÁCIDOS.*/
public class sintese {
	public static void main(String[] arguments) {
		boolean ini = false;
		String DNA = "ACTGGAGCCACCTATGTGAACTACGACGTGACCCTCTTACGTGAAATATCCACCAGCGACTAATATCTCCCCCGGAGATGTAGAGACTGGGACATTGCTGGAGTCTTCTGGTGATGTGTTAAACTGTCAAATGATCCGTCCCTTGCTCCT";
		String RNAm = DNA_para_RNAm(DNA);
		String[] subStr = dividirEmSubstrings(RNAm);

		for (int i = 0; i < subStr.length; i++) {
			if (subStr[i].compareTo("AUG") == 0) {
				System.out.println("(inicio) Metionina" + "(" + subStr[i] + ")");
				ini = true;
			}
			if (ini == true) {
				if (subStr[i].compareTo("AUU") == 0 || subStr[i].compareTo("AUC") == 0
						|| subStr[i].compareTo("AUA") == 0) {
					System.out.println("Isoleucina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("CUU") == 0 || subStr[i].compareTo("CUC") == 0
						|| subStr[i].compareTo("CUA") == 0 || subStr[i].compareTo("CUG") == 0
						|| subStr[i].compareTo("UUA") == 0 || subStr[i].compareTo("UUG") == 0) {
					System.out.println("Leucina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("UUU") == 0 || subStr[i].compareTo("UUC") == 0) {
					System.out.println("Fenilalanina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("GUU") == 0 || subStr[i].compareTo("GUC") == 0
						|| subStr[i].compareTo("GUA") == 0 || subStr[i].compareTo("GUG") == 0) {
					System.out.println("Valina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("UCU") == 0 || subStr[i].compareTo("UCC") == 0
						|| subStr[i].compareTo("UCA") == 0 || subStr[i].compareTo("UCG") == 0) {
					System.out.println("Serina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("CCU") == 0 || subStr[i].compareTo("CCC") == 0
						|| subStr[i].compareTo("CCA") == 0 || subStr[i].compareTo("CCG") == 0) {
					System.out.println("Prolina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("ACU") == 0 || subStr[i].compareTo("ACC") == 0
						|| subStr[i].compareTo("ACA") == 0 || subStr[i].compareTo("ACG") == 0) {
					System.out.println("Treonina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("GCU") == 0 || subStr[i].compareTo("GCC") == 0
						|| subStr[i].compareTo("GCA") == 0 || subStr[i].compareTo("GCG") == 0) {
					System.out.println("Alanina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("UAU") == 0 || subStr[i].compareTo("UAC") == 0
						|| subStr[i].compareTo("UGU") == 0 || subStr[i].compareTo("UGC") == 0) {
					System.out.println("Tirosina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("CAU") == 0 || subStr[i].compareTo("CAC") == 0) {
					System.out.println("Histidina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("CAA") == 0 || subStr[i].compareTo("CAG") == 0) {
					System.out.println("Glutamina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("AAU") == 0 || subStr[i].compareTo("AAC") == 0
						|| subStr[i].compareTo("GAU") == 0 || subStr[i].compareTo("GAC") == 0) {
					System.out.println("Asparagina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("AAA") == 0 || subStr[i].compareTo("AAG") == 0
						|| subStr[i].compareTo("GAA") == 0 || subStr[i].compareTo("GAG") == 0) {
					System.out.println("Lisina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("UGU") == 0 || subStr[i].compareTo("UGC") == 0) {
					System.out.println("Tirosina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("UGG") == 0) {
					System.out.println("Triptofano" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("CGU") == 0 || subStr[i].compareTo("CGC") == 0
						|| subStr[i].compareTo("CGA") == 0 || subStr[i].compareTo("CGG") == 0
						|| subStr[i].compareTo("AGA") == 0 || subStr[i].compareTo("AGG") == 0) {
					System.out.println("Arginina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("AGU") == 0 || subStr[i].compareTo("AGC") == 0) {
					System.out.println("Serina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("GGU") == 0 || subStr[i].compareTo("GGC") == 0
						|| subStr[i].compareTo("GGA") == 0 || subStr[i].compareTo("GGG") == 0) {
					System.out.println("Glicina" + "(" + subStr[i] + ")");
				} else if (subStr[i].compareTo("UAA") == 0 || subStr[i].compareTo("UAG") == 0
						|| subStr[i].compareTo("UGA") == 0) {
					System.out.println("(FIM)" + "(" + subStr[i] + ")");
					return;
				}
			}
		}
	}

	public static String DNA_para_RNAm(String DNA) {
		String RNAm = new String();
		
		for(int i = 0; i < DNA.length(); i++) {
			if(DNA.charAt(i) == 'A') {
				RNAm += 'U';
			} else if(DNA.charAt(i) == 'T') {
				RNAm += 'A';
			} else if(DNA.charAt(i) == 'C') {
				RNAm += 'G';
			} else if(DNA.charAt(i) == 'G') {
				RNAm += 'C';
			}
		}
		System.out.println("RNAm formado: " + RNAm);
		return RNAm;
	}
	
	public static String[] dividirEmSubstrings(String RNAm) {
		// Guarda o tamanho da string
		int tamanho = RNAm.length();
		// n é a variavel que divide a String em 'n' partes iguais
		int n = RNAm.length() / 3;
		int temp = 0, chars = tamanho / n;
		// Guarda o array da String
		String[] subStr = new String[n];
		// Verifica se a string pode ser dividida em 'n' partes
		if (tamanho % n != 0) {
			System.out.println("Não foi possível dividir em " + n + " partes iguais");
		} else {
			for (int i = 0; i < tamanho; i = i + chars) {
				// Dividindo a string em 'n' partes iguais usando str.substring()
				String part = RNAm.substring(i, i + chars);
				subStr[temp] = part;
				temp++;
			}
		}
		return subStr;
	}

}
