package es.esy.marcus.estoque.controller;

import java.util.List;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import es.esy.marcus.estoque.dao.CategoriaDao;
import es.esy.marcus.estoque.domain.Categoria;

@SuppressWarnings("serial")
public class CCategoria extends SelectorComposer<Component> {

	@Wire
	private Window dlgCategoria;
	@Wire
	private Textbox txboxCategoria;
	@Wire
	private Textbox txboxDescricao;
	@Wire
	private Listbox listCategoria;
	private Categoria categoria;
	private ListModelList<Categoria> listModel;
	
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		PreencherLista();
	}

	public void PreencherLista() {
		CategoriaDao cDao = new CategoriaDao();
		List<Categoria> lCategoria = cDao.listar();
		listModel = new ListModelList<Categoria>(lCategoria);
		listCategoria.setModel(listModel);
	}

	@Listen("onClick = #btnNovaCategoria")
	public void NovaCategoria() {
		this.dlgCategoria.setVisible(true);

	}

	@Listen("onClick = #btnSalvar")
	public void Salvar() {
		try {
			this.categoria = new Categoria();
			System.out.println("passei btnsalvar");
			CategoriaDao categoriaDao = new CategoriaDao();
			this.categoria.setCategoria(this.txboxCategoria.getValue());
			this.categoria.setDescricao(this.txboxDescricao.getValue());
			categoriaDao.salvar(this.categoria);
			Messagebox.show("Categoria Salva");
			this.categoria = new Categoria();
			PreencherLista();

		} catch (RuntimeException e) {
			e.printStackTrace();
			Messagebox.show("Erro ao Salvar Categoria");
		}
	}

	@Listen("onDeleteItem = #listCategoria")
	public void Deletar(Event event) {

		Categoria catexluir = new Categoria();
		catexluir = (Categoria) event.getData();

		CategoriaDao cDao = new CategoriaDao();
		cDao.excluir(catexluir);
		PreencherLista();

	}
}
