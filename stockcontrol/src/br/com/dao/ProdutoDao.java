package br.com.dao;

import java.util.ArrayList;
import br.com.model.Produto;

public class ProdutoDao implements IProdutoDao{
	
	private ArrayList<Produto> lista = new ArrayList<Produto>(); 
	
	public void save(Produto produto){
		if(getByName(produto.getNome()) != null){
			Produto temp = getByName(produto.getNome());
			int id = lista.indexOf(temp);
			temp.setQtd(temp.getQtd()+produto.getQtd());
			temp.setDescricao(produto.getDescricao());
			lista.set(id, temp);
		}else{
			lista.add(produto);
		}
	}
	
	public void delete(int id){
		lista.remove(id);
	}
	
	public Produto getByName(String name){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome().equals(name)){
				return lista.get(i);
			}
		}
		return null;
	}
	
	public Produto getById(int id){
		if(lista.size()>id){
			return lista.get(id);
		}
		else{
			return null;
		}
	}
	
	public ArrayList<Produto> findAll(){
		return lista;
	}

	public void delete(String name) {
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome().equals(name)){
				lista.remove(i);
			}
		}		
	}

}