package todo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class BoxLayoutPanel extends JPanel {

    private List panelComponents;
    private int axis;

    @Autowired
    public void setAxis(@Value("1") int axis) {
        this.axis = axis;
    }

    @Autowired
    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    @PostConstruct
    public void init() {
        setLayout(new BoxLayout(this, axis));

        for (Iterator iter = panelComponents.iterator();
             iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component);
        }
    }
}