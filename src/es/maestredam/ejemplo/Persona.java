package es.maestredam.ejemplo;

public class Persona implements java.io.Serializable {

    private static final long serialVersionUID = 7995840867241454221L;

    private String nombre;
    private boolean mayorEdad;
    private double saldo;

    // Constructor
    public Persona(String nombre, boolean mayorEdad, double saldo) {
        this.nombre = nombre;
        this.mayorEdad = mayorEdad;
        this.saldo = saldo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public boolean isMayorEdad() {
        return mayorEdad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo es negativo");
        }
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", mayorEdad=" + mayorEdad + ", saldo=" + saldo + "]";
    }
}
