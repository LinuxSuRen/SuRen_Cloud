package org.suren.test;

public class SDR {
	private int id;
	private String name;
	private String status;
	private String read;
	private float val;
	/**
	 * @param id
	 * @param name
	 * @param status
	 * @param read
	 * @param val
	 */
	public SDR(int id, String name, String status, String read, float val) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.read = read;
		this.val = val;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the read
	 */
	public String getRead() {
		return read;
	}
	/**
	 * @return the val
	 */
	public float getVal() {
		return val;
	}
}
