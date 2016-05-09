package rmi;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * Diese Klasse stellt eine einfache SocketFactory-Implementierung zur
 * Verfügung.
 * 
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
public class MySocketFactory extends RMISocketFactory implements Serializable {


	private static final long serialVersionUID = -675606124977518929L;
	private InetAddress hostIp = null;

	public MySocketFactory() {
	}

	public MySocketFactory(InetAddress hostIp) {
		this.hostIp = hostIp;
	}

	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		return new ServerSocket(port, 25, hostIp);
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException {
		return new Socket(hostIp, port);
	}

	@Override
	public boolean equals(Object param) {
		return (param != null && param.getClass() == this.getClass());
	}
}
