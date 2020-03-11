package com.ttt.tp.task1.draw;

import com.ttt.tp.task1.enums.FigureType;
import com.ttt.tp.task1.figures.*;
import com.ttt.tp.task1.figures.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Point startPoint;
    private Point endPoint;
    private JPanel panel;
    private List<Figure> figureList = new ArrayList<Figure>();

    private Color brColor;
    private Color bckColor;

    private Figure figure;
    private FigureType figureType;

    public FigureType getFigureType() {
        return figureType;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }


    public Color getBrColor() {
        return brColor;
    }

    public void setBrColor(Color brColor) {
        this.brColor = brColor;
    }


    public void setBckColor(Color bckColor) {
        this.bckColor = bckColor;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public DrawPanel() {
        panel = this;
        startPoint = new Point();
        endPoint = new Point();
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                startPoint.x = e.getX();
                startPoint.y = e.getY();


                System.out.println("start: " + startPoint);

            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Palette palette = new Palette();
                Graphics graphicsPanel = e.getComponent().getGraphics();
                endPoint.x = e.getX();
                endPoint.y = e.getY();
                switch (figureType) {
                    case LINE:
                        figure = new Line(startPoint, endPoint);
                        break;
                    case CIRCLE:
                        //  figure = new PolyLine(startPoint, endPoint);
                        break;
                    case ELLIPSE:
                        figure = new Ellipse(startPoint, endPoint);
                        break;
                    case LINESEGMENT:
                        figure = new LineSegment(startPoint, endPoint);
                        break;
                    case RAY:
                        figure = new Ray(startPoint, endPoint);
                        break;
                    case CUSTOMPOLYGON:
                        figure = new CustomPolygon(new Point[]{startPoint, endPoint}, 2);
                        break;
                    case POLYLINE:
                        figure = new PolyLine(new Point[]{startPoint, endPoint}, 2);
                        break;
                    case RECTANGLE:
                        figure = new Rectangle(startPoint, endPoint);
                        ((Rectangle)figure).setBgColor(bckColor);
                        break;
                    case RHOMBUS:
                        figure = new Rhombus(new Point[]{startPoint, endPoint, startPoint});
                        break;
                    case REGULARPOLYGON:
                        figure = new RegularPolygon(startPoint, endPoint, 4);
                        break;
                }



                figure.setBorderColor(brColor);
                figure.draw(graphicsPanel);
                System.out.println("end: " + endPoint);

            }


        });

    }

    public void draw() {
    }

}
