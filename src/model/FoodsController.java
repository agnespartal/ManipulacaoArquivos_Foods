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

	public void fruitsController(String caminho, String arquivo) throws Exception {
		File arq = new File(caminho, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			System.out.format("%-30s\t" + "%-50s\t" + "%-30s\n", "FOOD NAME", "SCIENTFIC NAME", "SUBGROUP");
			while (linha != null) {
				if (linha.contains(",")) {
					String[] vetLinha = linha.split(",");
					if (vetLinha[2].contains("Fruits")) {
						System.out.format("%-30s\t" + "%-50s\t" + "%-30s\n", vetLinha[0], vetLinha[1], vetLinha[3]);
					}
					linha = buffer.readLine();
				}
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido ou não existe");
		}
	}
}
