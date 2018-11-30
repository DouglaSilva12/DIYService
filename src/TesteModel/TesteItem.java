package TesteModel;
import java.util.*;
import Model.Item;
import Model.Produto;
import Model.TipoItem;

public class TesteItem {
	
	public static void main(String[] args) {
		
		// Instanciando os primeiros tipos de itens(P�o e carne)
		
		
		TipoItem paoFrances = new TipoItem();
		TipoItem carneBoi = new TipoItem();
		TipoItem queijoPrato = new TipoItem();
			
		paoFrances.setValorTipoItem(1.00);
		paoFrances.setIdTipoItem(1);
		paoFrances.setNomeTipoItem("P�O");
		
		carneBoi.setValorTipoItem(10.0);
		carneBoi.setIdTipoItem(1);
		carneBoi.setNomeTipoItem("CARNE");
		
		queijoPrato.setIdTipoItem(1);
		queijoPrato.setNomeTipoItem("QUEIJO PRATO");
		queijoPrato.setValorTipoItem(0.75);
			
		
		// Instanciando a classe dos itens (p�o frances como tipo de p�o)
		
		Item pao = new Item(1, paoFrances);
		Item carne = new Item(1, carneBoi);
		Item queijo = new Item(1, queijoPrato);
		
		//Cria��o da lista de itens para compor o produto final
		// itensHamburguer � uma lista de itens
			
		List<Item> itensHamburguer = new ArrayList<Item>();
		
		// adicionando itens na lista
		
		itensHamburguer.add(carne);
		itensHamburguer.add(pao);
		itensHamburguer.add(queijo);
		
		
		// instanciando Produto como resultado dos itens juntos
		
		Produto hamburguer = new Produto(1, "Hamburguer de carne", itensHamburguer);
		
		/*Imprimir dados (teste)
		  Imprimir do objeto hamburguer na lista de itens
		  escolhidos, na posi��o 0, o valor e nome do tipo de item.
		*/
		
		System.out.println(hamburguer.getItensEscolhidos().get(0).getTipoItem().getNomeTipoItem());
		System.out.println(hamburguer.getItensEscolhidos().get(0).getTipoItem().getValorTipoItem());
	

		// for para imprimir os itens e seus valores da lista produto 
		
		for( Item x: hamburguer.getItensEscolhidos()) {
			System.out.println( x.getTipoItem().getNomeTipoItem());
			System.out.println( x.getTipoItem().getValorTipoItem());

		}
		
		// m�todo para calcular o valor dos itens na lista
	
		hamburguer.calculaValor();
		System.out.println(hamburguer.getValor());
	
	}
}
