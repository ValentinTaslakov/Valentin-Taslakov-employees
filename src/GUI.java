import engine.Engine;
import fileReader.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class GUI extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JTextArea pane;
    private JButton button;

    public GUI() {
        frame = new JFrame();
        button = new JButton("Open file!");
        button.addActionListener(this);

        pane = new JTextArea(100, 100);
        pane.setBounds(0, 20, 700, 200);
        pane.setText("Chose your file with button!");


        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);

        frame.setSize(500, 500);
        frame.add(pane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {

            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(this);

            if (i == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                String filepath = file.getPath();

                Engine engine = new Engine();
                String result = engine.run(filepath);
                pane.setText(result);

            }
        }
    }
}
