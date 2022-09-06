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
@Table(name="tb_venda")
public class VendaModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pcodigo;
	
	@NotBlank
	@Size
	private String pquantidade;
	
	@NotBlank
	@Size
	private String pcpf;
	
	@UpdateTimestamp
    private LocalDate data;

	@ManyToOne
    @JsonIgnoreProperties("produto")  //parar loop infinito
    private ProdutoModel produto;

    @ManyToOne
    @JsonIgnoreProperties("venda")  //parar loop infinito
    private VendaModel venda;
	
	
	public long getPcodigo() {
		return pcodigo;
	}

	public void setPcodigo(long pcodigo) {
		this.pcodigo = pcodigo;
	}

	public String getPquantidade() {
		return pquantidade;
	}

	public void setPquantidade(String pquantidade) {
		this.pquantidade = pquantidade;
	}

	public String getPcpf() {
		return pcpf;
	}

	public void setPcpf(String pcpf) {
		this.pcpf = pcpf;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	

	
	

}
