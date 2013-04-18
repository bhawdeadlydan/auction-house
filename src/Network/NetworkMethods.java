package Network;

public enum NetworkMethods {
	START_TRANSFER(-1),
	TRANSFER(0),
	LOGIN(1),
	REGISTER_SERVICE(2),
	NEW_USER(3),
	MAKE_OFFER(4),
	LOGOUT(5),
	USER_LEFT(6),
	UPDATE_TRANSFER(7),
	OFFER_EXCEEDED(8),
	DROP_OFFER_REQUEST(9),
	REFUSE_OFFER(10),
	OFFER_REFUSED(11),
	REMOVE_OFFER(12),
	OFFER_REMOVED(13);

	private int id;

	NetworkMethods(int id)
	{
		this.id = id;
	}

	public int getInt()
	{
		return id;
	}
}
