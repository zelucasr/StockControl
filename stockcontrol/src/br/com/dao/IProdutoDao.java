package br.com.dao;

import java.util.List;
import br.com.model.Produto;

public interface IProdutoDao {
	void save(Produto produto);
	void delete(String name);
	List<Produto> findAll();
	Produto getByName(String name);
}