package es.esy.marcus.estoque.controller;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import es.esy.marcus.estoque.dao.CategoriaDao;
import es.esy.marcus.estoque.domain.Categoria;

@SuppressWarnings({ "serial", "rawtypes" })
public class CCategoria2 extends GenericForwardComposer {

	Window dlgCategoria;
	Textbox txboxCategoria;
	Textbox txboxDescricao;
	private ListModel<Categoria> listaCategoria;

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
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messagebox.show("Erro ao Salvar Categoria");
		}
	}

	public void onClick$btnFechar() {
		this.execution.sendRedirect(null);
	}

	public ListModel<Categoria> listar(){
		CategoriaDao categoriaDao = new CategoriaDao();
		this.listaCategoria =  (ListModel<Categoria>) categoriaDao.listar();
		return this.listaCategoria;
		
	}

}
