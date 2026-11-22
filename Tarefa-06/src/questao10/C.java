package questao10;

public class C {

    protected String atributo1;
    protected float atributo2;

    public C() {
        System.out.println("  Construtor C()");
        atributo1 = "VAZIO";
        atributo2 = -999.99f;
    }

    public C(String p1, float p2) {
        System.out.println("  Construtor C(String, float)");
        atributo1 = p1;
        atributo2 = p2;
    }
}
