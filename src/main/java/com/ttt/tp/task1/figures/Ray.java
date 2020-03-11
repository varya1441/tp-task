package com.ttt.tp.task1.figures;

import java.awt.Graphics;
import java.awt.Point;

public class Ray extends LineSegment {

	public Ray(Point start, Point end) {
		super(start, end);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(getLocation().x,getLocation().y,getEnd().x,getEnd().y);
	}
}
