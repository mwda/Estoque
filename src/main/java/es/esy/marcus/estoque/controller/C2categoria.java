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

import es.esy.marcus.estoque.dao.CategoriaDao;
import es.esy.marcus.estoque.domain.Categoria;

@SuppressWarnings("serial")
public class C2categoria extends SelectorComposer<Component> {

	@Wire
	private Listbox listCategoria;
	@Wire
	private Textbox txboxCategoria;
	@Wire
	private Textbox txboxDescricao;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		PreencherLista();
	}

	public void PreencherLista() {
		CategoriaDao cDao = new CategoriaDao();
		List<Categoria> lCategoria = cDao.listar();
		listCategoria.setModel(new ListModelList<Categoria>(lCategoria));
	}

	@Listen("onClick = #btnSalvar")
	public void Salvar() {
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

	@Listen("onDeleteItem = #listCategoria")
	public void delete(Event event) {

		Categoria catexluir = new Categoria();
		catexluir = (Categoria) event.getData();

		CategoriaDao cDao = new CategoriaDao();
		cDao.excluir(catexluir);
		PreencherLista();
	}
}
