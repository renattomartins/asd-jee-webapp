package br.pucminas.aulapratica.jee.trabalho_jee.business;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<ClienteResource> listarCliente() {
		List<ClienteEntity> entidades = clienteRepository.listar();
		List<ClienteResource> resources = new ArrayList<ClienteResource>();
		
		if (entidades == null)
			return null;
		
		for(ClienteEntity cliente : entidades) {
			ClienteResource resource = new ClienteResource();
			resource.setNome(cliente.getNome());
			resource.setCpf(cliente.getCpf());
			resource.setEmail(cliente.getEmail());
			resource.setDataNascimento(cliente.getDataNascimento());
			
			resources.add(resource);
		}
		return resources;
	}
	
}
