package cuentaBancaria;

public class CuentaBancaria {

    //Atributos
    private String titular;
    private String numeroCuenta;
    private double saldo;

    //Cosntructor Vacio
    public CuentaBancaria() {
        this.titular = "Sin asignar";
        this.numeroCuenta = "0000";
        this.saldo = 0.0;
    }

    //Constructor con parámetros
    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0.0;
        }
    }

    //Getters y Setters -> No siempre tienen que estar los Getter y Setter de todas los atributos
    //De acuerdo al cord del negocio y los niveles de privacidad que se requieran de los atributos
    public String getTitular() {
        return this.titular;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Metodos propios de la clase:
    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a depositar debe ser mayor a cero.");
            return;
        }
        saldo += monto;
        System.out.println("Deposito exitoso. Nuevo saldo: $" + saldo);
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser mayor a cero.");
            return;
        }
        if (monto > saldo) {
            System.out.println("Error: fondos insuficientes. Saldo actual: $" + saldo);
            return;
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
    }

    public String toString() {
    return "Cuenta " + numeroCuenta + " | Titular: " + titular + " | Saldo: $" + saldo;
    }
}