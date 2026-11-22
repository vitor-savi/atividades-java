package questao10;

// no diagrama a classe aparece como C_12, mas o main do enunciado usa C1_2
public class C1_2 extends C implements I1, I2 {

    private float[][] atributo3;

    public C1_2() {
        super();
        System.out.println("  Construtor C1_2()");
        atributo3 = new float[2][2];
    }

    public C1_2(String p1, float p2) {
        super(p1, p2);
        System.out.println("  Construtor C1_2(String, float)");
        atributo3 = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                atributo3[i][j] = 1;
            }
        }
    }

    @Override
    public void operacao1() {
        System.out.println("Passou por operacao1()");
        System.out.println("  atributo1 = " + atributo1);
        System.out.println("  atributo2 = " + atributo2);
        System.out.println("  atributo3 =");
        for (int i = 0; i < atributo3.length; i++) {
            System.out.print("   ");
            for (int j = 0; j < atributo3[i].length; j++) {
                System.out.print(" " + atributo3[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void operacao2() {
        System.out.println("Passou por operacao2()");
    }

    public static void main(String args[]) {
        System.out.println("Iniciando o programa...");
        System.out.println("Instanciando C1_2 sem parametros:");
        C1_2 objC1 = new C1_2();
        System.out.println("Instanciando C1_2 com parametros:");
        C1_2 objC2 = new C1_2("XPTO", 3.141516f);
        System.out.println("Chamando operacoes na instancia 1:");
        objC1.operacao1();
        objC1.operacao2();
        System.out.println("Chamando operacoes na instancia 2:");
        objC2.operacao1();
        objC2.operacao2();
        System.out.println("Instanciando objeto em referencia para interface:");
        I1 objC3 = new C1_2("YSBC", 1.99f);
        System.out.println("Chamando operacoes na referencia para interface:");
        objC3.operacao1();
    }
}
