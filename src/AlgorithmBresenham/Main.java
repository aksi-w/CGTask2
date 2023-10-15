package AlgorithmBresenham;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainWindow mv = new MainWindow();
        mv.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //завершение программы при закрытии окна
        mv.setSize(1000, 800); //размер
        mv.setVisible(true); //окно видимое

    }
}
