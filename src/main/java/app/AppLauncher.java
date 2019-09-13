package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import resource.InvoiceLoadController;

@SpringBootApplication
@ComponentScan(basePackageClasses = InvoiceLoadController.class)
public class AppLauncher {

   public static void  main(String args []){

       SpringApplication.run(AppLauncher.class,args);
    }
}
