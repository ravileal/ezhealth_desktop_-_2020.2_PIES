package Util;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class DragListener extends MouseInputAdapter{
    private Point location;
    private MouseEvent mouseEvent;
 
    @Override
	public void mousePressed(MouseEvent mouseEvent){
    	this.mouseEvent = mouseEvent;
    }
 
    @Override
	public void mouseDragged(MouseEvent mouseEvent){
        Component component = mouseEvent.getComponent();
        location = component.getLocation(location);
        int x = this.location.x - this.mouseEvent.getX() + mouseEvent.getX();
        int y = this.location.y - this.mouseEvent.getY() + mouseEvent.getY();
        component.setLocation(x, y);
     }
}
