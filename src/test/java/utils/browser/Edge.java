package utils.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge implements IBrowser {
    @Override
    public WebDriver createInstance() {
        return new EdgeDriver();
    }
}
