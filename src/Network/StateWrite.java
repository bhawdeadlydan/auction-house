package Network;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class StateWrite implements IStateClientNetwork {
	
	int[] message;
	ByteBuffer buffer;
	SocketChannel channel;
	
	public StateWrite(SocketChannel channel, int[] message) {
		this.channel = channel;
		this.message = message;
	}
	
	@Override
	public void execute() throws IOException {
		// Prepare buffer.
		prepareBuffer();
		
		// Put message in buffer.
		processMessage();
		
		// Send message.
		while (buffer.hasRemaining()){
			channel.write(buffer);
		}
	}

	@Override
	public void prepareBuffer() {
		buffer = ByteBuffer.allocate((message.length + 1) * Integer.SIZE / 8);
	}

	public void processMessage() {	
		// Set message length.
		buffer.putInt(message.length * Integer.SIZE / 8);
		
		// Put message in buffer.
		for (int i = 0; i < message.length; i++)
		{
			buffer.putInt(message[i]);
		}
		
		buffer.flip();
	}

}