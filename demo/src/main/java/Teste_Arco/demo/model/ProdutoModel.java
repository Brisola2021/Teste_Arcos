package Teste_Arco.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity 
@Table(name="tb_produto")
public class ProdutoModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pcodigo;
	
	@NotBlank
	@Size
	private String ppreco;
	
	@NotBlank
	@Size
	private String pdescricao;
	
	@UpdateTimestamp
    private LocalDate data;
	
	@ManyToOne
    @JsonIgnoreProperties("produto")  //parar loop infinito
    private EstoqueModel estoque;
	
	 // @ManyToOne
	   // @JsonIgnoreProperties("postagem")  //parar loop infinito
	   //private UsuarioModel usuario;
	

	public long getPcodigo() {
		return pcodigo;
	}

	public void setPcodigo(long pcodigo) {
		this.pcodigo = pcodigo;
	}

	public String getPpreco() {
		return ppreco;
	}

	public void setPpreco(String ppreco) {
		this.ppreco = ppreco;
	}

	public String getPdescricao() {
		return pdescricao;
	}

	public void setPdescricao(String pdescricao) {
		this.pdescricao = pdescricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public EstoqueModel getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueModel estoque) {
		this.estoque = estoque;
	}

}
	

	
   

	


