/**
 * Новый класс и тип чисел - комплексные
 */
public class Complex {
    protected int[] z = {0, 0};
    public void putRe(int a){
        z[0] = a;
    }

    public void putIm(int a){
        z[1] = a;
    }

    public int[] getZ(){
        return z;
    }

    public String showZ(){
        return String.valueOf(z[0]) + " + " + String.valueOf(z[1]) + "i" ;
    }

}