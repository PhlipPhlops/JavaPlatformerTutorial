package com.phlipphlops.neon.window;

import com.phlipphlops.neon.framework.GameObject;
import com.phlipphlops.neon.framework.ObjectId;
import com.phlipphlops.neon.objects.Block;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    private GameObject tempObject;

    public void tick() {

        for (int i = 0; i < object.size(); i++) {
            tempObject = object.get(i);

            tempObject.tick(object);
        }
    }

    public void render(Graphics g) {

        for (int i = 0; i < object.size(); i++) {
            tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void createLevel() {
        for (int xx = 0; xx < Game.WIDTH+32; xx += 32) {
            addObject(new Block(xx, Game.HEIGHT-64, ObjectId.Block));
        }
    }
}
