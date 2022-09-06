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


import Teste_Arco.demo.model.VendaModel;
import Teste_Arco.demo.repository.VendaRepository;



@RestController
@RequestMapping("/venda")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VendaController {
	
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@GetMapping("/all")
	public ResponseEntity <List<VendaModel>> getAll(){
		
		return ResponseEntity.ok(vendaRepository.findAll());
		
	}
	
	@GetMapping("/{pcodigo}")
	public ResponseEntity<VendaModel> getById(@PathVariable Long pcodigo) {
		return vendaRepository.findById(pcodigo)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/pcpf/{pcpf}")
	public ResponseEntity<List<VendaModel>> getByPcpf(@PathVariable String pcpf) {
		return ResponseEntity.ok(vendaRepository.findAllByPcpfContainingIgnoreCase(pcpf));
	}
	
	@PostMapping
	public ResponseEntity<VendaModel> postVenda(@Valid @RequestBody VendaModel venda) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaRepository.save(venda));
	}
	
	@PutMapping
	public ResponseEntity<VendaModel> putVenda(@Valid @RequestBody VendaModel pcpf) {
					
		return vendaRepository.findById(pcpf.getPcodigo())
				.map(resposta -> {
					return ResponseEntity.ok().body(vendaRepository.save(pcpf));
				})
				.orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping("/{pcodigo}")
	public ResponseEntity<?> deleteEstoque(@PathVariable Long pcodigo) {
		
		return vendaRepository.findById(pcodigo)
				.map(resposta -> {
					vendaRepository.deleteById(pcodigo);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
}
