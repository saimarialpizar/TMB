package main;

import singleton.ControladorTMB;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ControladorTMB controlador = ControladorTMB.getInstancia();

        System.out.println("=== Calculadora de Tasa Metabólica Basal (TMB) ===");

        System.out.print("Ingrese su sexo (hombre/mujer): ");
        String sexo = sc.nextLine();

        System.out.print("Ingrese su peso en kg: ");
        double peso = sc.nextDouble();

        System.out.print("Ingrese su altura en cm: ");
        double altura = sc.nextDouble();

        System.out.print("Ingrese su edad en años: ");
        int edad = sc.nextInt();

        double tmb = controlador.calcularTMB(sexo, peso, altura, edad);
        String interpretacion = controlador.interpretarTMB(tmb);

        System.out.printf("Su TMB es: %.2f calorías/día (%s)%n", tmb, interpretacion);

        ControladorTMB otraReferencia = ControladorTMB.getInstancia();
        System.out.println("¿Ambas referencias son el mismo objeto? " + (controlador == otraReferencia));
    }
}
