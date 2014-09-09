package uk.josephmansfield.interplanar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class Level {

	private Map map;
	private final MapObjects collisionObjects;

	public Level(Map map) {
		this.map = map;

		MapLayer collisionLayer = map.getLayers().get("Collision");
		collisionObjects = collisionLayer.getObjects();
	}

	public void populatePhysicsWorld(World physicsWorld) {
		for (MapObject collisionObject : collisionObjects) {
			if (collisionObject instanceof RectangleMapObject) {
				RectangleMapObject rectangleCollisionObject = (RectangleMapObject) collisionObject;
				Rectangle collisionRectangle = rectangleCollisionObject.getRectangle();

				CollisionBody collisionBody = new CollisionBody(collisionRectangle);
				collisionBody.addToPhysicsWorld(physicsWorld);
			}
		}
	}

	public static Level fromMapPath(String filePath) {
		Map map = new TmxMapLoader().load(filePath);

		return new Level(map);
	}
}
