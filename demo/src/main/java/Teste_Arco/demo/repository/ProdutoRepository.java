package Teste_Arco.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste_Arco.demo.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> { 
	public List<ProdutoModel> findAllByPdescricaoContainingIgnoreCase(String pdescricao);

}
