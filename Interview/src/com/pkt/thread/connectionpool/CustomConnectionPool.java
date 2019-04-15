package com.pkt.thread.connectionpool;

public interface CustomConnectionPool extends ConnectionPool {
	public int getNumberOfAvailableConnections();

	public int getNumberOfBusyConnections();

	public void closeAllConnections();
}
