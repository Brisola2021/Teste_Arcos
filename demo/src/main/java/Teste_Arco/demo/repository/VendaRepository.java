package Teste_Arco.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste_Arco.demo.model.VendaModel;

@Repository
public interface VendaRepository extends JpaRepository<VendaModel, Long> {
	public List<VendaModel> findAllByPcpfContainingIgnoreCase(String pcpf);

}
