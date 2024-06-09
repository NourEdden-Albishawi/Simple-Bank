package HTU;

import controllers.AppController;
import managers.PanelManager;

public class Main {

    private static PanelManager panelManager;

    public static void main(String[] args) {

        panelManager = new PanelManager();
        new AppController(panelManager);
    }

    public static PanelManager getPanelManager() {
        return panelManager;
    }
}
