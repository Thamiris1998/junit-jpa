package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import model.Cliente;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class ClienteDaoTest {

	EntityManager emOracle;
	EntityManager emPostgres;
	
	//Anotação necessaria para toda vez que o teste for executado a conexão dos bancos serem realizadas antes
	//Para isso foi usada a anotação @Before
	@Before
	public void init() {
		EntityManagerFactory factoryOracle = Persistence.createEntityManagerFactory("oracle");
		emOracle = factoryOracle.createEntityManager();

		EntityManagerFactory factoryPostgres = Persistence.createEntityManagerFactory("postgres");
		emPostgres = factoryPostgres.createEntityManager();
	}

	@Test
	public void testClienteVerificaDadosSalvosNoBancoOracleParaSalvarNoBancoPostgreSQL() {
		//Criada query para fazer a busca do nome
		Query query = emOracle.createQuery("select c from Cliente c where c.nomeCompleto like :nome");
		query.setParameter("nome", "Thamiris Lopes");
		//Criada lista para pegar o resultado da query
		List<Cliente> listaCliente = query.getResultList();
		//Criado for para pegar cada valor da listaCliente(referente ao banco de dados Oracle)
		for (Cliente clienteOracle : listaCliente) {
			Cliente clientePostgre = new Cliente();
			//Obtido valor da listaCliente o mesmo é passado para o banco de dados PostgreSQL como mostra abaixo
			clientePostgre.setNomeCompleto(clienteOracle.getNomeCompleto());
			clientePostgre.setCpf(clienteOracle.getCpf());
			clientePostgre.setEmail(clienteOracle.getEmail());
			clientePostgre.setTelefone(clienteOracle.getTelefone());
			clientePostgre.setEndereco(clienteOracle.getEndereco());

			emPostgres.getTransaction().begin();
			emPostgres.persist(clientePostgre);
			emPostgres.getTransaction().commit();
			emPostgres.close();
			
			//Imprime o que foi salvo no banco de dados PostgreSQL
			System.out.println(clientePostgre);
		}
	}
}