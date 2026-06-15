public class Main {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        System.out.println("Suma: " + calc.sumar(8, 3));
        System.out.println("Resta: " + calc.restar(5, 4));
        System.out.println("Multiplicación: " + calc.multiplicar(12, 7));
        System.out.println("División: " + calc.dividir(486, 9));
    }
}