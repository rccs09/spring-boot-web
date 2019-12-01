package com.rccs.springboot.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url;
	private Page<T> page;
	private int totalPaginas;
	private int numElemXPagina;
	private int paginaActual;
	private List<PageItem> paginas;
	
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		totalPaginas = page.getTotalPages();
		numElemXPagina = page.getSize();
		paginaActual = page.getNumber() + 1;
		
		int desde, hasta;
		if(totalPaginas <= numElemXPagina) {
			desde = 1;
			hasta = totalPaginas;
		}else {
			if(paginaActual<= (numElemXPagina/2)) {
				desde = 1;
				hasta = totalPaginas;
			}else if(paginaActual<= totalPaginas - (numElemXPagina/2)) {
				desde = totalPaginas - numElemXPagina + 1;
				hasta = totalPaginas;
			}else {
				desde = paginaActual - (numElemXPagina/2);
				hasta = numElemXPagina;
			}
		}
		
		for (int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde+i, paginaActual==desde+i));
		}
		
	}


	public String getUrl() {
		return url;
	}


	public int getTotalPaginas() {
		return totalPaginas;
	}


	public int getPaginaActual() {
		return paginaActual;
	}


	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	
	public boolean isFist() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean hasNext() {
		return page.hasNext();
	}
	
	public boolean hasPrevious() {
		return page.hasPrevious();
	}
}
