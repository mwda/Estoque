package es.esy.marcus.estoque.controller;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import es.esy.marcus.estoque.dao.CategoriaDao;
import es.esy.marcus.estoque.domain.Categoria;

@SuppressWarnings({ "serial", "rawtypes" })
public class CCategoria extends GenericForwardComposer {

	Window dlgCategoria;
	Textbox txboxCategoria;
	Textbox txboxDescricao;

	public void onClick$btnNovaCategoria() {
		this.dlgCategoria.setVisible(true);

	}

	public void onClick$btnSalvar() {	
		try {
			System.out.println("passei btnsalvar");
			Categoria categoria = new Categoria();
			categoria.setCategoria(this.txboxCategoria.getValue());
			categoria.setDescricao(this.txboxDescricao.getValue());
			CategoriaDao categoriaDao = new CategoriaDao();
			categoriaDao.salvar(categoria);
			Messagebox.show("Categoria Salva");
			this.dlgCategoria.setVisible(false);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messagebox.show("Erro ao Salvar Categoria");
		}
	}
	@Listen("onClick=#btnSalvar")
	public void onClick$btnFechar() {
		System.out.println("passei btnfechar");
		this.txboxCategoria.setValue(null);
		this.txboxDescricao.setValue(null);
		this.dlgCategoria.setVisible(false);
	}
	
	
}
