package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FoodsController {

	public FoodsController() {
		super();
	}

	public void fruitsController(String caminho, String arquivo) throws Exception{
		File arq = new File(caminho,arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			System.out.println("FOOD NAME \t\t SCIENTFIC NAME \t\t SUBGROUP\n");
			while (linha != null) {
				if (linha.contains(",")) {
					String[] vetLinha = linha.split(",");
					if (vetLinha[2].contains("Fruits")) {
						if(vetLinha[0].length() > 7 && vetLinha[0].length() <= 12) {
							System.out.print(vetLinha[0] + "\t\t");
						}else if(vetLinha[0].length() > 12) {
							System.out.print(vetLinha[0] + " \t");
						}else {
							System.out.print(vetLinha[0] + "\t\t\t");
						}
						if (vetLinha[1].length() > 14 && vetLinha[1].length() <= 20) {
							System.out.print(vetLinha[1] + "\t\t");
						}else if (vetLinha[1].length() > 20){
							System.out.print(vetLinha[1] + " \t");
						}else {
							System.out.print(vetLinha[1] + "\t\t\t");
						}
						System.out.println(vetLinha[3]);
						}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido ou não existe");
		}
	}
}
