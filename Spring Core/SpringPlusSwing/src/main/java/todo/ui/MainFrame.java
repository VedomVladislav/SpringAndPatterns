package todo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@Configuration
public class MainFrame extends JFrame {

    private BoxLayoutPanel mainPanel;
    private String title;

    public MainFrame() {

    }

    @Autowired
    public void setMainPanel(BoxLayoutPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Autowired
    public void setTitle(@Value("My To Do List") String title) {
        this.title = title;
    }

    @PostConstruct
    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 400));

        setVisible(true);
        setState(Frame.NORMAL);
        show();
    }
}