package com.trilogi.controllers;

import com.trilogi.entities.Researcher;
import com.trilogi.services.ResearcherService;
import java.util.Scanner;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class ResearcherController {
    private final ResearcherService service;
    private final Scanner scanner;

    // Constructor Injection
    public ResearcherController(ResearcherService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void showMenu() {
        System.out.println(ansi()
                .fg(YELLOW).bold()
                .a("=================================")
                .reset());
        System.out.println(ansi()
                .bold().bg(RED)
                .a("        RESEARCHERS MENU         ")
                .reset());
        System.out.println(ansi()
                .fg(YELLOW).bold()
                .a("=================================")
                .reset());
        System.out.println(ansi()
                .a("\n1. Add New Researcher")
                .a("\n2. Update Researcher Details")
                .a("\n3. Deactivate Researcher")
                .a("\n4. List All Researchers")
                .a("\n0. Back to Main Menu\n")
                .reset());
    }

    public void handleMenu() {
        while (true) {
            showMenu();
            System.out.print(ansi().fg(CYAN).a("Select option: ").reset());

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewResearcher();
                    break;
                case 2:
                    updateResearcher();
                    break;
                case 3:
                    deactivateResearcher();
                    break;
                case 4:
                    listAllResearchers();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(ansi()
                            .fg(RED).a("✗ Invalid option").reset());
            }
        }
    }

    private void addNewResearcher() {
        System.out.print("Enter researcher name: ");
        String name = scanner.nextLine();

        System.out.print("Enter researcher email: ");
        String email = scanner.nextLine();

        try {
            Researcher researcher = new Researcher();
           // researcher.setName(name);
           // researcher.setEmail(email);

            service.registerNewResearcher(researcher);

            System.out.println(ansi()
                    .fg(GREEN).a("✓ Researcher added successfully!").reset());
        } catch (Exception e) {
            System.out.println(ansi()
                    .fg(RED).a("✗ Error: " + e.getMessage()).reset());
        }
    }

    private void updateResearcher() {
        System.out.print("Enter researcher ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        // Implementation here...
        System.out.println(ansi().fg(YELLOW).a("⚠ Not implemented yet").reset());
    }

    private void deactivateResearcher() {
        System.out.print("Enter researcher ID to deactivate: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        try {
            boolean success = service.deactivateResearcher(id);
            if (success) {
                System.out.println(ansi()
                        .fg(GREEN).a("✓ Researcher deactivated").reset());
            } else {
                System.out.println(ansi()
                        .fg(YELLOW).a("⚠ Researcher not found").reset());
            }
        } catch (Exception e) {
            System.out.println(ansi()
                    .fg(RED).a("✗ Error: " + e.getMessage()).reset());
        }
    }

    private void listAllResearchers() {
        try {
            var researchers = service.getAllResearchers();

            System.out.println(ansi()
                    .fg(CYAN).bold().a("\nResearchers:").reset());
            System.out.println("─────────────────────────────");

            for (Researcher r : researchers) {
                System.out.println(ansi()
                   //     .a("ID: ").fg(YELLOW).a(r.getId()).reset()
                     //   .a(" | Name: ").a(r.getName())
                        .reset());
            }

            if (researchers.isEmpty()) {
                System.out.println(ansi()
                        .fg(YELLOW).a("⚠ No researchers found").reset());
            }
        } catch (Exception e) {
            System.out.println(ansi()
                    .fg(RED).a("✗ Error: " + e.getMessage()).reset());
        }
    }
}