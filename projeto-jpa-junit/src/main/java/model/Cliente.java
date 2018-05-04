package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE")
	@SequenceGenerator(name = "CLIENTE", sequenceName = "SEQ_ID_CLIENTE", initialValue = 1, allocationSize = 1)
	@Column(name = "id_cliente", nullable = true)
	int idCliente;
	@Column(name = "nome_completo", nullable = true)
	String nomeCompleto;
	String cpf;
	String email;
	String telefone;
	String endereco;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + "]";
	}

}
