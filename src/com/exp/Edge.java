package com.exp;

class Edge {

	private int src;
	private int dest;
	private int weight = 0;

	/**
	 * @param src
	 * @param dest
	 */
	public Edge(int src, int dest) {		
		this.src = src;
		this.dest = dest;
	}

	/**
	 * @param src
	 * @param dest
	 * @param weight
	 */
	public Edge(int src, int dest, int weight) {
		super();
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	/**
	 * @return the src
	 */
	public int getSrc() {
		return src;
	}

	/**
	 * @param src
	 *            the src to set
	 */
	public void setSrc(int src) {
		this.src = src;
	}

	/**
	 * @return the dest
	 */
	public int getDest() {
		return dest;
	}

	/**
	 * @param dest
	 *            the dest to set
	 */
	public void setDest(int dest) {
		this.dest = dest;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dest;
		result = prime * result + src;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (dest != other.dest)
			return false;
		if (src != other.src)
			return false;
		return true;
	}

}