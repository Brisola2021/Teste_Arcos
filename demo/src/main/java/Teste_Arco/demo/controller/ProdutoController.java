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



import Teste_Arco.demo.model.ProdutoModel;
import Teste_Arco.demo.repository.EstoqueRepository;
import Teste_Arco.demo.repository.ProdutoRepository;



@RestController
@RequestMapping("/produto") 
@CrossOrigin(origins = "*", allowedHeaders = "*")


public class ProdutoController {
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Autowired 
	private EstoqueRepository estoqueRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAll (){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{pcodigo}")
	public ResponseEntity<ProdutoModel> getBypcodigo(@PathVariable Long pcodigo) {
		return produtoRepository.findById(pcodigo)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/pdescricao/{pdescricao}")
	public ResponseEntity<List<ProdutoModel>> getByPdescricao(@PathVariable String pdescricao){
		return ResponseEntity.ok(produtoRepository.findAllByPdescricaoContainingIgnoreCase(pdescricao));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto (@Valid @RequestBody ProdutoModel produto){

		if (estoqueRepository.existsById(produto.getPcodigo()))
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> putPostagem (@Valid @RequestBody ProdutoModel produto){
		
			if (produtoRepository.existsById(produto.getPcodigo())){
			
			if (estoqueRepository.existsById(produto.getPcodigo()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(produtoRepository.save(produto));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}			
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{pcodigo}")
	public ResponseEntity<?> deleteProduto(@PathVariable Long pcodigo) {
		
		return produtoRepository.findById(pcodigo)
				.map(resposta -> {
					produtoRepository.deleteById(pcodigo);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
