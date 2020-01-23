/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author Lucas Oliveira
 */
public abstract class BaseComponent extends JLabel {
    protected int X;
    protected int Y;
    protected int W;
    protected int H;
    protected String iconPath;
    protected ImageIcon default_image;
    protected Cursor cursor_type;
}
