
/**************************************** 
nome: Matheus Barcellos de Castro Cunha
nusp: 11208238
*****************************************/

import java.util.Scanner;
import java.util.Locale; 


class estrutura {
	double grade;
	String name;	
}

class resultado_final {
	double grade;
	String name;	
	String cargo;
}

public class Ep1 {

	public static void ordenar  (resultado_final mat[][]) {

		double aux;
		String aux_name;
		String aux_cargo;

		for (int i = 0; i < mat.length; i++){
			for (int j = 0; j < mat[i].length; j++){
				for (int z = 0; z < mat[i].length; z++){
					if (mat[i][j].grade > mat[i][z].grade) {
						aux = mat[i][j].grade;
						aux_name = mat[i][j].name;
						aux_cargo = mat[i][j].cargo;
						mat[i][j].grade = mat[i][z].grade;
						mat[i][j].name = mat[i][z].name;
						mat[i][j].cargo = mat[i][z].cargo;
						mat[i][z].grade = aux;
						mat[i][z].name = aux_name;
						mat[i][z].cargo = aux_cargo;
					}
				}
			}
		}
	}

	public static void main (String args[]) {

		int numero_de_notas = 14;

		Scanner sc = new Scanner (System.in);
		String linha;

		while (sc.hasNext()){

			int numero_de_cargos = sc.nextInt();
			sc.nextLine();

			estrutura[][] notas_base = new estrutura[numero_de_cargos][numero_de_notas];

			for (int i = 0; i < numero_de_cargos; i++) {
				for (int j = 0; j < numero_de_notas; j++) {
					notas_base[i][j] = new estrutura();
				}
			}

			for (int i = 0; i < numero_de_cargos; i++) {

				String nome = sc.nextLine();

				notas_base[i][0].name = nome;

				for (int j = 0; j < numero_de_notas; j++) { 
					sc.useLocale(Locale.ENGLISH);
					notas_base[i][j].grade = sc.nextDouble();
				}
				sc.nextLine();
			}

			int numero_de_pessoas;

			numero_de_pessoas = sc.nextInt();

			sc.nextLine();

			estrutura[][] notas_pessoas = new estrutura[numero_de_pessoas][numero_de_notas];
			resultado_final[][] resultado = new resultado_final[numero_de_cargos][numero_de_pessoas];

			for (int i = 0; i < numero_de_pessoas; i++) {
				for (int j = 0; j < numero_de_notas; j++) {
					notas_pessoas[i][j] = new estrutura();	
				}		
			}

			for (int i = 0; i < numero_de_cargos; i++) {
				for (int j = 0; j < numero_de_pessoas; j++) {
					resultado[i][j] = new resultado_final();
				}		
			}


			for (int i = 0; i < numero_de_pessoas; i++) {

				String nome = sc.nextLine();

				notas_pessoas[i][0].name = nome;

				for (int j = 0; j < numero_de_notas; j++) {
					sc.useLocale(Locale.ENGLISH);
					notas_pessoas[i][j].grade = sc.nextDouble();
				}
				sc.nextLine();
			}

			double acumulado = 0.0;

			for (int i = 0; i < numero_de_cargos; i++){
				acumulado = 0.0;
				for (int j = 0; j < numero_de_pessoas; j++){
					acumulado = 0.0;
					for (int z = 0; z < numero_de_notas; z++){
						acumulado += notas_pessoas[j][z].grade * notas_base[i][z].grade;
					}
					resultado[i][j].grade = acumulado;
					resultado[i][j].name = notas_pessoas[j][0].name;
					resultado[i][j].cargo = notas_base[i][0].name;
				}
			}

			ordenar(resultado);

			for (int i = 0; i < numero_de_cargos; i++) {
				System.out.println();
				System.out.println(resultado[i][0].cargo);
				for (int j = 0; j < numero_de_pessoas; j++) {
					System.out.println(resultado[i][j].name);
				}
			}
		}
	}
}