package Ribossomo;

public class sintese {
	public static void main(String[] arguments) {
		boolean ini = false;
		String RNAm = "ACUGACAUGUUACUCACUAUUUGACAG";
		String[] subStr = dividirEmSubstrings(RNAm);

		for (int i = 0; i < subStr.length; i++) {
			if (subStr[i].compareTo("AUG") == 0) {
				System.out.println("(inicio) Metionina" + "(" + subStr[i] + ")");
				ini = true;
			}
			if (ini == true) {
				if (subStr[i].compareTo("AUU") == 0 || subStr[i].compareTo("AUC") == 0
						|| subStr[i].compareTo("AUA") == 0) {
					System.out.println("Isoleucina" + "(" + subStr[i] + ")" + i);
				}
			}
		}
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
