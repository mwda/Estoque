package es.esy.marcus.estoque.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

@SuppressWarnings("serial")
public class CCategoria extends SelectorComposer<Component>{
	
	//Wired Componentes
	@Wire
	Textbox txboxCategoria;
	@Wire
	Textbox txboxDescricao;
	
	
	@Listen("onClick = #btnSalvar")
	public void Salvar(){
		this.alert("sdfds");
			
	}
}
