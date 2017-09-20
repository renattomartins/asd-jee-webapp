package br.pucminas.aulapratica.jee.trabalho_jee.controller;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.pucminas.aulapratica.jee.trabalho_jee.business.ClienteBusiness;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.ClienteResource;

@Model
public class ClienteBean {

	@EJB
	private ClienteBusiness clienteBusiness;
	
	private ClienteResource clienteResource = new ClienteResource();
	
	/* Implementação da listagem de clientes conforme desafio 2 */
	

	public ClienteResource getClienteResource() {
		return clienteResource;
	}


	public void setClienteResource(ClienteResource clienteResource) {
		this.clienteResource = clienteResource;
	}


	public void salvarCliente() {
		clienteBusiness.salvarCliente(clienteResource);
		FacesContext.getCurrentInstance().addMessage("formCliente:messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente adicionado com sucesso", ""));
	}

}
