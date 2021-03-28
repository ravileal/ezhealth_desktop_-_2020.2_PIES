package model;

public class AlimentoModel extends Alimento {
	
	public Alimento toAlimento() {
		Alimento ali = new Alimento();
		ali.setId(id);
		ali.setNome(nome);
		ali.setQuantidade(quantidade);
		ali.setCalorias(calorias); 
		ali.setProteina(proteina);
		ali.setCarboidrato(carboidrato);
		ali.setGordura(gordura);
		ali.setTaxaAcucar(taxaAcucar);
		ali.setGlutem(glutem);
		ali.setLactose(lactose);
		ali.setFavorito(favorito);
		return ali;
	}
	
}
