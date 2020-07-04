package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartActionListener implements ActionListener {
    private Window window;

    public RestartActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //window.changeEnableOfResultButton();
        window.redraw();
    }


}
