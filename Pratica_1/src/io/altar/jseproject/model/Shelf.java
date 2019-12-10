package io.altar.jseproject.model;

public class Shelf {
	
	private long id;
	private int capacity;
	private long productId; 
	private float dailyPrice;
	
	public Shelf() {
			}

	public Shelf(int capacity, float dailyPrice) {
			this.capacity = capacity;
		this.dailyPrice = dailyPrice;
	}

	public Shelf(long id, int capacity, long productId, float dailyPrice) {
		this.id = id;
		this.capacity = capacity;
		this.productId = productId;
		this.dailyPrice = dailyPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	@Override
	public String toString() {
		return "Shelf [id=" + id + ", capacity=" + capacity + ", productId=" + productId + ", dailyPrice=" + dailyPrice
				+ "]";
	}
	
	
	
}
