package blogz;

import java.util.ArrayList;

abstract class Entity {
	
	private final int uid;
	private static int count;
	
	public Entity() {
		this.uid = Entity.count;
		Entity.count++;
	}

}
