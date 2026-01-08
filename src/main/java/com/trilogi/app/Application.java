package com.trilogi.app;

import com.trilogi.controllers.ResearcherController;
import com.trilogi.services.ResearcherService;
import org.fusesource.jansi.AnsiConsole;
import java.util.Scanner;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Application {
    private static ServiceContainer container;
    private static Scanner scanner;

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        scanner = new Scanner(System.in);
        container = new ServiceContainer();

        try {
            // Initialize and check database
            if (!initializeDatabase()) {
                System.exit(1);
            }

            showWelcome();
            runMainMenu();

        } catch (Exception e) {
            System.out.println(ansi()
                    .fg(RED).bold()
                    .a("✗ Fatal error: " + e.getMessage())
                    .reset());
            e.printStackTrace();
        } finally {
            cleanup();
        }
    }

    private static boolean initializeDatabase() {
        try {
            var em = container.getService(jakarta.persistence.EntityManager.class);

            if (em.isOpen()) {
                System.out.println(ansi()
                        .fg(GREEN).a("✓ Database connection established").reset());
                return true;
            } else {
                System.out.println(ansi()
                        .fg(RED).a("✗ Database connection failed").reset());
                return false;
            }
        } catch (Exception e) {
            System.out.println(ansi()
                    .fg(RED).a("✗ Database initialization error: " + e.getMessage())
                    .reset());
            return false;
        }
    }

    private static void showWelcome() {
        System.out.println(ansi()
                .fg(CYAN).bold()
                .a("=================================")
                .reset());
        System.out.println(ansi()
                .bold().bg(MAGENTA)
                .a("   Welcome to Oddities Manager  ")
                .reset());
        System.out.println(ansi()
                .fg(CYAN).bold()
                .a("=================================")
                .reset());
        System.out.println();
    }

    private static void runMainMenu() {
        while (true) {
            showMainMenu();
            System.out.print(ansi().fg(CYAN).a("Select option: ").reset());

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleOdditiesMenu();
                    break;
                case 2:
                    handleResearcherMenu();
                    break;
                case 3:
                    handleLendingMenu();
                    break;
                case 4:
                    System.out.println(ansi()
                            .fg(GREEN).a("✓ Goodbye!").reset());
                    return;
                default:
                    System.out.println(ansi()
                            .fg(RED).a("✗ Invalid option").reset());
            }

            // Close EntityManager after each operation
            container.closeEntityManager();
        }
    }

    private static void showMainMenu() {
        System.out.println(ansi()
                .fg(YELLOW).bold()
                .a("\n=================================")
                .reset());
        System.out.println(ansi()
                .bold().bg(RED)
                .a("           MAIN MENU             ")
                .reset());
        System.out.println(ansi()
                .fg(YELLOW).bold()
                .a("=================================")
                .reset());
        System.out.println(ansi()
                .a("\n1. Oddities Management")
                .a("\n2. Researcher Management")
                .a("\n3. Lending Management")
                .a("\n4. Exit Application\n")
                .reset());
    }

    private static void handleOdditiesMenu() {
        // Get controller with DI
        // OddityController controller = new OddityController(
        //     container.getService(OddityService.class),
        //     scanner
        // );
        // controller.handleMenu();
        System.out.println(ansi().fg(YELLOW).a("⚠ Not implemented yet").reset());
    }

    private static void handleResearcherMenu() {
        // Get controller with DI
        ResearcherController controller = new ResearcherController(
                container.getService(ResearcherService.class),
                scanner
        );
        controller.handleMenu();
    }

    private static void handleLendingMenu() {
        // Get controller with DI
        // LendingController controller = new LendingController(
        //     container.getService(LendingService.class),
        //     scanner
        // );
        // controller.handleMenu();
        System.out.println(ansi().fg(YELLOW).a("⚠ Not implemented yet").reset());
    }

    private static void cleanup() {
        if (scanner != null) {
            scanner.close();
        }
        if (container != null) {
            container.shutdown();
        }
        AnsiConsole.systemUninstall();
    }
}