package view;

import model.FoodsController;

public class Principal {

	public static void main(String[] args) {
		String caminho = "C:\\TEMP";
		String arquivo = "generic_food.csv";
		FoodsController f = new FoodsController();
		try {
			f.fruitsController(caminho, arquivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
