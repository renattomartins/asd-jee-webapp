package br.pucminas.aulapratica.jee.trabalho_jee.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.ClienteEntity;
import br.pucminas.aulapratica.jee.trabalho_jee.repository.ClienteRepository;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.ClienteResource;

@Stateless
public class ClienteBusiness {
	
	@Inject
	private ClienteRepository clienteRepository;

	public void salvarCliente(ClienteResource clienteResource){
		
		ClienteEntity clienteEntity = new ClienteEntity();
		
		clienteEntity.setNome(clienteResource.getNome());
		clienteEntity.setCpf(clienteResource.getCpf());
		clienteEntity.setEmail(clienteResource.getEmail());
		clienteEntity.setDataNascimento(clienteResource.getDataNascimento());
		
		clienteRepository.salvar(clienteEntity);
	}
	
	/* Implementação da listagem de clientes conforme desafio 2 */
	
}
