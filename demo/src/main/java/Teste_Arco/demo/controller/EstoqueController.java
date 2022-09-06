package Teste_Arco.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import Teste_Arco.demo.model.EstoqueModel;
import Teste_Arco.demo.repository.EstoqueRepository;


@RestController
@RequestMapping("/estoque") 
@CrossOrigin(origins = "*", allowedHeaders = "*")



public class EstoqueController {
	
		
	@Autowired 
	private EstoqueRepository estoqueRepository;
	
	@GetMapping
	public ResponseEntity<List<EstoqueModel>> getAll() {
		return ResponseEntity.ok(estoqueRepository.findAll());
	}
	
	@GetMapping("/{pcodigo}")
	public ResponseEntity<EstoqueModel> getById(@PathVariable Long pcodigo) {
		return estoqueRepository.findById(pcodigo)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/pquantidade/{pquantidade}")
	public ResponseEntity<List<EstoqueModel>> getByPquantidade(@PathVariable String pquantidade) {
		return ResponseEntity.ok(estoqueRepository.findAllByPquantidadeContainingIgnoreCase(pquantidade));
	}
	
	@PostMapping
	public ResponseEntity<EstoqueModel> postEstoque(@Valid @RequestBody EstoqueModel estoque) {
		return ResponseEntity.status(HttpStatus.CREATED).body(estoqueRepository.save(estoque));
	}
	
	@PutMapping
	public ResponseEntity<EstoqueModel> putEstoque(@Valid @RequestBody EstoqueModel estoque) {
					
		return estoqueRepository.findById(estoque.getPcodigo())
				.map(resposta -> {
					return ResponseEntity.ok().body(estoqueRepository.save(estoque));
				})
				.orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping("/{pcodigo}")
	public ResponseEntity<?> deleteEstoque(@PathVariable Long pcodigo) {
		
		return estoqueRepository.findById(pcodigo)
				.map(resposta -> {
					estoqueRepository.deleteById(pcodigo);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
}
