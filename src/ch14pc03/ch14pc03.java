package ch14pc03;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 'Watch Me' Applet
 * Applet where eyes follow the mouse movement
 * @author frank
 */
public class ch14pc03 extends JApplet implements MouseListener, MouseMotionListener {
    // Variables
    private final int leftEyeX = 30;
    private final int leftEyeY = 40;
    private final int rightEyeX = 90;
    private final int rightEyeY = 40;
    private int leftPupilX = leftEyeX + 10;
    private int leftPupilY = leftEyeY + 20;
    private int rightPupilX = rightEyeX + 10;
    private int rightPupilY = rightEyeY + 20;
    private final double proportion = 0.25;
    
    /**
     * Initialize method
     */
    public void init() {
        // Set background color to white
        getContentPane().setBackground(Color.WHITE);
        
        // Add a mouse listener to this applet
        addMouseListener(this);
        
        // Add a mouse motion listener to this applet
        addMouseMotionListener(this);
    }
    
    /**
     * Method to draw the eyes
     * @param g Graphics The Graphics object
     */
    public void paint(Graphics g) {
        // Call the super class to paint
        super.paint(g);
        
        // Draw eye outline
        g.setColor(Color.BLACK);
        g.drawOval(leftEyeX, leftEyeY, 40, 80);
        g.drawOval(rightEyeX, rightEyeY, 40, 80);
        
        // Draw Pupils
        g.fillOval(leftPupilX, leftPupilY, 20, 40);
        g.fillOval(rightPupilX, rightPupilY, 20, 40);
    }
    
    /**
     * Pupils follow mouse movement
     * @param e MouseEvent The event when the mouse is moved
     */
    public void mouseMoved(MouseEvent e) {
        // Variables
        double eyeProportionX = e.getX() * proportion;
        double eyeProportionY = e.getY() * proportion;
        
        leftPupilX = (int)eyeProportionX;
        leftPupilX += leftEyeX;
        leftPupilY = (int)eyeProportionY;
        leftPupilY += leftEyeX;
        
        rightPupilX = (int)eyeProportionX;
        rightPupilX += rightEyeX - 20;
        rightPupilY = (int)eyeProportionY - 10;
        rightPupilY += rightEyeY;
        
        if (leftPupilX < 30) {
            leftPupilX = 30;
        }
        else if (leftPupilX > 50) {
            leftPupilX = 50;
        }
        
        if (leftPupilY < 40) {
            leftPupilY = 40;
        }
        else if (leftPupilY > 80) {
            leftPupilY = 80;
        }
        
        if (rightPupilX < 90) {
            rightPupilX = 90;
        }
        else if (rightPupilX > 110) {
            rightPupilX = 110;
        }
        
        if (rightPupilY < 40) {
            rightPupilY = 40;
        }
        else if (rightPupilY > 80) {
            rightPupilY = 80;
        }
        
        repaint();
    }
    
    /**
     * Pupils return to center to "look forward"
     * @param e MouseEvent The event when the mouse exits the area
     */
    public void mouseExited(MouseEvent e) {
        // Draw pupils
        leftPupilX = leftEyeX + 10;
        leftPupilY = leftEyeY + 20;
        rightPupilX = rightEyeX + 10;
        rightPupilY = rightEyeY + 20;
        
        repaint();
    }
    
    
    // Non-applicable mouse motion listeners
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
}
