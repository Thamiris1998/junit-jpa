package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class ClienteDao {
	
	//Cria a conexão com o banco de dados Oracle para fazer a inserção dos dados
	public static void main(String[]args) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
			EntityManager em = factory.createEntityManager();
			Cliente c = new Cliente();

			c.setNomeCompleto("Thamiris Lopes");
			c.setCpf("000.000.000-00");
			c.setEmail("thamirisvasconsellos@hotmail.com");
			c.setTelefone("20000-0000");
			c.setEndereco("Rio de Janeiro");

			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();

	}

}
