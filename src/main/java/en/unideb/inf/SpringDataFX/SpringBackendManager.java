package en.unideb.inf.SpringDataFX;

import en.unideb.inf.SpringDataFX.frontend.BackendManager;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringBackendManager implements BackendManager {
    private ConfigurableApplicationContext ctx;

    @Override
    public void start() {
        if ((ctx !=null) || (ctx.isActive())) return;
        ctx = SpringApplication.run(SpringDataFxApplication.class);
    }

    @Override
    public void stop() {
        if ((ctx ==null) || (ctx.isClosed())) return;
        ctx.close();
    }

    @Override
    public void print() {
        if ((ctx ==null) || (ctx.isClosed())) return;
        ((SpringDataFxApplication)ctx.getBean(SpringDataFxApplication.class))
                .printPersons();
    }
}
