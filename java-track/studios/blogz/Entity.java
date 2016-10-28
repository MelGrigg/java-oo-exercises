package blogz;

abstract class Entity {
	
	private final int uid;
	private static int count;
	
	public Entity() {
		this.uid = Entity.count;
		Entity.count++;
	}
	
	public int getUID() {
		return this.uid;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Entity))
			return false;
		Entity x = (Entity)other;
		return (this.uid == x.getUID());
	}

}
