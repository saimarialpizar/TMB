package tmb;

public class ControladorTMB {
    private static ControladorTMB instancia;

    private ControladorTMB() {}

    public static ControladorTMB getInstancia() {
        if (instancia == null) {
            instancia = new ControladorTMB();
        }
        return instancia;
    }

    public double calcularTMB(String sexo, double pesoKg, double alturaCm, int edad) {
        if (pesoKg <= 0 || alturaCm <= 0 || edad <= 0) {
            throw new IllegalArgumentException("Los valores deben ser mayores que 0");
        }

        if (sexo.equalsIgnoreCase("hombre")) {
            return 88.362 + (13.397 * pesoKg) + (4.799 * alturaCm) - (5.677 * edad);
        } else if (sexo.equalsIgnoreCase("mujer")) {
            return 447.593 + (9.247 * pesoKg) + (3.098 * alturaCm) - (4.330 * edad);
        } else {
            throw new IllegalArgumentException("El sexo debe ser 'hombre' o 'mujer'");
        }
    }

    public String interpretarTMB(double tmb) {
        if (tmb < 1500) return "Metabolismo bajo";
        else if (tmb < 2000) return "Metabolismo promedio";
        else return "Metabolismo alto";
    }
}
