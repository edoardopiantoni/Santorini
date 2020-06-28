package it.polimi.ingsw.view.client.gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static it.polimi.ingsw.view.client.gui.BackgroundButton.backgroundButtonPersonalized;
import static it.polimi.ingsw.view.client.gui.Board.internalFrameSetUp;

/**
 * Class with generic utils methods
 * @author Luigi Scibona
 * @version 1.0
 * @since 2020/06/28
 */

public class GuiUtils {

    /**
     * Private Class Builder
     */

    private GuiUtils(){throw new IllegalStateException("GuiUtils class cannot be instantiated");}

    /**
     * Method that remove the ActionListener selected from the supplied JButton
     * @param button JButton to delete the ActionListener
     * @param clas Class of the ActionListener to be deleted
     */

    public static void eliminateActionClass(JButton button, Class clas){
        java.util.List<ActionListener> toRemove = new ArrayList<>();
        for (int x = 0; x < button.getActionListeners().length; x++){
            if (button.getActionListeners()[x].getClass().equals(clas))
                toRemove.add(button.getActionListeners()[x]);
        }
        for (ActionListener action : toRemove){
            button.removeActionListener(action);
        }
    }

    /**
     * Method that remove the MouseListener selected from the supplied JButton
     * @param button JButton to delete the MouseListener
     * @param clas Class of the MouseListener to be deleted
     */

    public static void eliminateMouseClass(JButton button, Class clas){
        java.util.List<MouseListener> toRemove = new ArrayList<>();
        for (int x = 0; x < button.getMouseListeners().length; x++){
            if (button.getMouseListeners()[x].getClass().equals(clas))
                toRemove.add(button.getMouseListeners()[x]);
        }
        for (MouseListener mouse : toRemove){
            button.removeMouseListener(mouse);
        }
    }

    /**
     * Method that remove ALL the ActionListener from the supplied JButton
     * @param button JButton to delete the ActionListener
     */

    public static void eliminateAllActionClass(JButton button){
        java.util.List<ActionListener> toRemove = new ArrayList<>();
        for (int x = 0; x < button.getActionListeners().length; x++){
            toRemove.add(button.getActionListeners()[x]);
        }
        for (ActionListener action : toRemove){
            button.removeActionListener(action);
        }
    }

    /**
     * Method that remove ALL the MouseListener from the supplied JButton
     * @param button JButton to delete the MouseListener
     */

    public static void eliminateAllMouseClass(JButton button){
        List<MouseListener> toRemove = new ArrayList<>();
        for (int x = 0; x < button.getMouseListeners().length; x++){
            toRemove.add(button.getMouseListeners()[x]);
        }
        for (MouseListener mouse : toRemove){
            button.removeMouseListener(mouse);
        }
    }

    /**
     * Method that set the close button and the background of the provided JDesktopPane
     * @param pane JDesktopPane provided
     * @param frame Dimension of the frame
     * @param button Dimension of the button
     * @param close MyButton close
     */

    public static void backAndCloseSetter(JDesktopPane pane, Dimension frame, Dimension button, MyButton close){
        close.setBounds(((frame.width * 50/100) - (button.width / 2)), (frame.height * 83 / 100),  button.width, button.height);
        pane.add(close);

        JButton back = backgroundButtonPersonalized(2, frame);
        back.setBounds(0, 0, frame.width, frame.height);
        pane.add(back);
    }

    public static JInternalFrame internalAndBackgroundSetter(JDesktopPane pane, Dimension intFrameSize, JButton background){
        JInternalFrame intFrame = new JInternalFrame("", false, false, false, false);
        intFrame.setPreferredSize(intFrameSize);
        internalFrameSetUp(intFrame);
        BasicInternalFrameUI bii = (BasicInternalFrameUI) intFrame.getUI();
        bii.setNorthPane(null);
        intFrame.setVisible(false);
        pane.add(intFrame);

        background.setBounds(0, 0,intFrameSize.width, intFrameSize.height);
        background.setOpaque(false);
        background.setContentAreaFilled(false);
        background.setBorderPainted(false);
        intFrame.add(background);

        return intFrame;
    }

    /**
     * Method for setting the JButtons of the cards
     */

    public static void setButtonStyle(List<JButton> cards, JInternalFrame intFrame, Dimension frameSize, Dimension intFrameSize, JButton buttonBackground, JLabel cover, JLabel label, boolean center, int type){
        for (JButton button : cards){
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.addMouseListener(new ColorBorderGodCards());
            button.addMouseListener(new ShowPower(intFrame, frameSize, intFrameSize, buttonBackground, cover, label, center, type));
        }
    }
}
