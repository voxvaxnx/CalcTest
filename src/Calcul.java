class Calcul {
    int vol1;
    int vol2;
    int lastText;
    int rezult;
    String znak;

    Calcul(int vol1, String znak, int vol2) {
        this.vol1 = vol1;
        this.vol2 = vol2;
        this.znak = znak;
        switch (znak) {
            case "+":
                this.rezult = vol1 + vol2;
                break;
            case "-":
                this.rezult = vol1 - vol2;
                break;
            case "*":
                this.rezult = vol1 * vol2;
                break;
            case "/":
                this.rezult = vol1 / vol2;
                break;
            default:
                System.out.println("Исключение: Неверный знак (Допустимо: +, -, *, / )");
                System.exit(0);
        }

        this.lastText = this.rezult;
    }
}


