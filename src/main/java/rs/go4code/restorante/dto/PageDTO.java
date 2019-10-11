package rs.go4code.restorante.dto;

import java.util.Collection;

public class PageDTO<T> {
	
	private int currentPage;
	private int itemsPerPage;
	private long totalItems;
	private Collection<T> items;
		
	public PageDTO() {
		super();
	}

	public PageDTO(int currentPage, int itemsPerPage, long totalItem, Collection<T> items) {
		super();
		this.currentPage = currentPage;
		this.itemsPerPage = itemsPerPage;
		this.totalItems = totalItem;
		this.items = items;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setIntemPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}

	public Collection<T> getItems() {
		return items;
	}

	public void setItems(Collection<T> items) {
		this.items = items;
	}

}
