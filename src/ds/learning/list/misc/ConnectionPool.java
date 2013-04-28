package ds.learning.list.misc;

import java.util.ArrayList;
import java.util.List;

// Wait and notify Example - Implementing a connection pool
// http://www.javamex.com/tutorials/wait_notify_how_to.shtml
public class ConnectionPool {
	
	  //Unsynchronized list of connections 
	  private List<Connection> connections = createConnections();

	  //Create connections during start up
	  private List<Connection> createConnections() {
	    List<Connection> conns = new ArrayList<Connection>(5);
	    for (int i = 0; i < 5; i++) {
	    //... add a Connection to conns
	    }
	    return conns;
	  }
	  
	  // getConnection from the pool(list)
	  public Connection getConnection() throws InterruptedException {
		  synchronized (connections) {
		    while (connections.isEmpty()) {
		      connections.wait();
		    }
		    return connections.remove(0);
		  }
		}
	  
	  //return connection to the pool
	  public void returnConnection(Connection conn) {
		  synchronized (connections) {
		    connections.add(conn);
		    connections.notify();
		  }
		}
	  
}

class Connection {
	// Assume this to be the DB connection class
}