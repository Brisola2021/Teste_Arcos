package Teste_Arco.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste_Arco.demo.model.EstoqueModel;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long> {
	public List<EstoqueModel> findAllByPquantidadeContainingIgnoreCase(String pquantidade);

}
