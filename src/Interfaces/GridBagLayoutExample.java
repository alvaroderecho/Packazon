package Interfaces;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class GridBagLayoutExample extends JFrame {

        public GridBagLayoutExample() {
                GridBagLayout grid = new GridBagLayout();
                GridBagConstraints gbc = new GridBagConstraints();
                setLayout(grid);
                setTitle("GridBag Layout Example");                
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = 0;
                add(new Button("Button One"), gbc);
                gbc.gridx = 1;
                gbc.gridy = 0;
                add(new Button("Button two"), gbc);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.ipady = 20;
                gbc.gridx = 0;
                gbc.gridy = 1;
                add(new Button("Button Three"), gbc);
                gbc.gridx = 1;
                gbc.gridy = 1;
                add(new Button("Button Four"), gbc);
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridwidth = 2;
                add(new Button("Button Five"), gbc);
                setSize(300, 300);
                setPreferredSize(getSize());
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);

        }

        public static void main(String[] args) {
                GridBagLayoutExample a = new GridBagLayoutExample();
        }
}
