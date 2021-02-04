import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Playground {

    private final JFrame frame = new JFrame("Playground");
    private final Map<Integer, Image> additionalImages;

    public Playground(int numberOfColumns, int numberOfRows, Map<Integer, Image> additionalImages) {
        this.additionalImages = additionalImages;
        frame.setSize(800, 800);
        GridLayout grid = new GridLayout(numberOfColumns, numberOfRows);
        frame.setLayout(grid);
        frame.setMinimumSize(new Dimension(grid.getColumns() * 48, grid.getRows() * 48));
    }

    public void showField(int[][] field) {
        for (int[] columns: field) {
            for (int imageName: columns) {
                if (additionalImages.containsKey(imageName)) {
                    Image image = additionalImages.get(imageName);
                    JLabel label = new JLabel(new ImageIcon(image));
                    frame.add(label);
                } else {
                    Image image = new ImageIcon("resources/" + imageName + ".png").getImage();
                    JLabel label = new JLabel(new ImageIcon(image));
                    frame.add(label);
                }
            }
        }

        frame.setVisible(true);
    }

    public void updateField(int[][] newField) {
        frame.getContentPane().removeAll();

        for (int[] columns: newField) {
            for (int imageName: columns) {
                if (additionalImages.containsKey(imageName)) {
                    Image image = additionalImages.get(imageName);
                    JLabel label = new JLabel(new ImageIcon(image));
                    frame.add(label);
                } else {
                    Image image = new ImageIcon("resources/" + imageName + ".png").getImage();
                    JLabel label = new JLabel(new ImageIcon(image));
                    frame.add(label);
                }
            }
        }

        frame.validate();
        frame.repaint();
    }

    public static void main(String[] args) {

    }

}
