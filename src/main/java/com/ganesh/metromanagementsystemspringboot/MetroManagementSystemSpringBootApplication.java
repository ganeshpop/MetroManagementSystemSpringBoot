package com.ganesh.metromanagementsystemspringboot;

import com.ganesh.pojos.Color;
import com.ganesh.presentation.MetroPresentationHelper;
import com.ganesh.presentation.MetroPresentationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.ganesh")
public class MetroManagementSystemSpringBootApplication implements CommandLineRunner {
    private MetroPresentationInterface metroPresentation;
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    @Qualifier("metroPresentation")
    public void setMetroPresentation(MetroPresentationInterface metroPresentation) {
        this.metroPresentation = metroPresentation;
    }

    public static void main(String[] args) {
        ApplicationContext metroContainer =  SpringApplication.run(MetroManagementSystemSpringBootApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        while(true) {
            int cardId = metroPresentation.authenticateUser();
            if (cardId < 0) continue;
            while (true) {
                metroPresentation.showMenu(cardId);
                System.out.println(Color.ANSI_RESET + "Enter choice : ");
                String choice = scanner.nextLine();
                if (metroPresentation.performMenu(MetroPresentationHelper.isInt(choice), cardId) < 0)
                    break;
            }
        }
    }
}
