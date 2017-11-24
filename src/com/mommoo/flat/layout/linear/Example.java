package com.mommoo.flat.layout.linear;

import com.mommoo.flat.frame.FlatFrame;
import com.mommoo.flat.layout.linear.constraints.LinearConstraints;
import com.mommoo.flat.layout.linear.constraints.LinearSpace;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.*;

public class Example {

    public static void main(String[] args){
        FlatFrame frame = new FlatFrame();
        frame.setSize(500,500 + FlatFrame.getTitleBarHeight());
        frame.setResizable(true);
        frame.setTitle("Flat layout test example");
        frame.setLocationOnScreenCenter();
//        frame.getContainer().add(new LinearLayoutPanel3());
        JPanel panel = new JPanel(new LinearLayout(Orientation.VERTICAL, Alignment.CENTER));
        panel.setBackground(Color.RED);
        panel.add(new JButton("1"), new LinearConstraints(LinearSpace.WRAP_CENTER_CONTENT));
        frame.getContainer().setLayout(new LinearLayout(Orientation.HORIZONTAL, Alignment.CENTER));
        frame.getContainer().add(panel, new LinearConstraints(1, LinearSpace.MATCH_PARENT));
        frame.show();
    }

    private static class LinearLayoutPanel extends JPanel {
        private LinearLayout linearLayout;
        private LinearLayoutPanel(){
            setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
            setLinearLayout();
            addComponent();
        }

        private void setLinearLayout(){
            linearLayout = new LinearLayout();
            linearLayout.setOrientation(Orientation.VERTICAL);
            linearLayout.setGap(15);
            setLayout(linearLayout);
        }

        private void addComponent(){
            add(createColorRect(Color.RED, "FIRST"), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            add(createColorRect(Color.GREEN, "SECOND"), new LinearConstraints().setWeight(3).setLinearSpace(LinearSpace.MATCH_PARENT));
            add(createColorRect(Color.YELLOW, "THIRD"), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
        }
    }

    private static class LinearLayoutPanel2 extends JPanel{
        private LinearLayoutPanel2(){
            setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
            setLinearLayout();
            LinearConstraints linearConstraints = new LinearConstraints();
            add(createRowPanel(Color.RED, Color.WHITE, Color.BLUE), linearConstraints.setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            add(createRowPanel(Color.PINK, Color.GRAY, Color.YELLOW), linearConstraints.setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            add(createRowPanel(Color.GREEN, Color.ORANGE, Color.MAGENTA), linearConstraints.setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
        }

        private void setLinearLayout(){
            LinearLayout linearLayout = new LinearLayout();
            linearLayout.setOrientation(Orientation.VERTICAL);
            linearLayout.setGap(15);
            setLayout(linearLayout);
        }

        private JPanel createRowPanel(Color color1, Color color2, Color color3){
            JPanel panel = new JPanel();
            panel.setLayout(new LinearLayout(15));
            LinearConstraints linearConstraints = new LinearConstraints();
            panel.add(createColorRect(color1,""), linearConstraints.setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            panel.add(createColorRect(color2,""), linearConstraints.setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            panel.add(createColorRect(color3,""), linearConstraints.setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
            return panel;
        }
    }

    private static JComponent createColorRect(Color color, String text){
        JLabel label = new JLabel(text,SwingConstants.CENTER);
        label.setOpaque(true);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 40.0f));
        label.setBackground(color);
        label.setPreferredSize(new Dimension(100,100));
        return label;
    }

    private static class LinearLayoutPanel3 extends JPanel{
        private LinearLayoutPanel3(){
            setLayout(new LinearLayout(30,Alignment.CENTER));
            add(createColorRect(Color.RED, "1"));
            add(createColorRect(Color.BLUE, "2"));
        }
    }
}
